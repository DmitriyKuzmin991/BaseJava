package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public abstract class AbstractStorageTest {
    protected final Storage storage;

    protected static final String UUID1 = "uuid1";
    protected static final String UUID2 = "uuid2";
    protected static final String UUID3 = "uuid3";
    protected static final String UUID4 = "uuid4";

    protected static final Resume RESUME_1 = new Resume(UUID1);
    protected static final Resume RESUME_2 = new Resume(UUID2);
    protected static final Resume RESUME_3 = new Resume(UUID3);
    protected static final Resume RESUME_4 = new Resume(UUID4);

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @Test
    protected void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
    }

    @Test
    protected void saveExistException() {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(RESUME_1));
    }

    @Test
    protected void delete() {
        storage.delete(UUID3);
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID3));
    }

    @Test
    protected void deleteNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(UUID4));
    }

    @Test
    protected void update() {
        Resume test = new Resume(UUID3);
        storage.update(test);
        Assertions.assertSame(test, storage.get(UUID3));
    }

    @Test
    protected void updateNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_4));
    }

    @Test
    protected void clear() {
        storage.clear();
        Resume[] actual = storage.getAll();
        Resume[] expected = new Resume[0];
        assertSize(0);
        Assertions.assertArrayEquals(actual, expected);
    }

    @Test
    protected void size() {
        assertSize(3);
    }

    @Test
    protected void get() {
        Assertions.assertAll(
                () -> assertGet(RESUME_1),
                () -> assertGet(RESUME_2),
                () -> assertGet(RESUME_3)
        );
    }

    @Test
    protected void getNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(UUID4));
    }

    @Test
    protected void getAll() {
        Resume[] actual = storage.getAll();
        Arrays.sort(actual);
        Resume[] expected = new Resume[]{RESUME_1, RESUME_2, RESUME_3};
        Assertions.assertArrayEquals(expected,actual);
    }

    private void assertSize(int size) {
        Assertions.assertEquals(storage.size(), size);
    }

    private void assertGet(Resume resume) {
        Resume expected = storage.get(resume.getUuid());
        Assertions.assertEquals(expected, resume);
    }
}