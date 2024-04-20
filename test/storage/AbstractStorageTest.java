package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


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
        List<Resume> actual = storage.getAllSorted();
        List<Resume> expected = new ArrayList<>();
        assertSize(0);
        Assertions.assertEquals(actual, expected);
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
    protected void getAllSortedTest() {
        storage.clear();
        storage.save(new Resume("uuid5", "1"));
        storage.save(new Resume("uuid6", "3"));
        storage.save(new Resume("uuid7", "8"));
        storage.save(new Resume("uuid8", "22"));
        List<Resume> actual = storage.getAllSorted();
        System.out.println(actual);
        List<Resume> expected = List.of(
                new Resume("uuid5", "1"),
                new Resume("uuid8", "22"),
                new Resume("uuid6", "3"),
                new Resume("uuid7", "8")
        );
        System.out.println(expected);
        Assertions.assertEquals(expected, actual);
    }

    private void assertSize(int size) {
        Assertions.assertEquals(storage.size(), size);
    }

    private void assertGet(Resume resume) {
        Resume expected = storage.get(resume.getUuid());
        Assertions.assertEquals(expected, resume);
    }
}