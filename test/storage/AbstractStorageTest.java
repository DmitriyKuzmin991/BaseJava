package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ResumeTestData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public abstract class AbstractStorageTest {
    protected final Storage storage;

    protected static final String FULLNAME1 = "ChuckNorris";
    protected static final String FULLNAME2 = "JeckieChan";
    protected static final String FULLNAME3 = "ArnoldAloisSchwarzenegger";
    protected static final String FULLNAME4 = "BruceLi";

    protected static final Resume RESUME_1 = ResumeTestData.getTestResume("uuid1", FULLNAME1);
    protected static final Resume RESUME_2 = ResumeTestData.getTestResume("uuid2", FULLNAME2);
    protected static final Resume RESUME_3 = ResumeTestData.getTestResume("uuid3", FULLNAME3);
    protected static final Resume RESUME_4 = ResumeTestData.getTestResume("uuid4", FULLNAME4);

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
        storage.delete(RESUME_3.getUuid());
        assertSize(2);
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(RESUME_3.getUuid()));
    }

    @Test
    protected void deleteNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete(FULLNAME4));
    }

    @Test
    protected void update() {
        Resume test = new Resume(RESUME_3.getUuid(),FULLNAME3);
        storage.update(test);
        Assertions.assertSame(test, storage.get(test.getUuid()));
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
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get(FULLNAME4));
    }

    @Test
    protected void getAllSortedTest() {
        storage.save(RESUME_4);
        List<Resume> actual = storage.getAllSorted();
        List<Resume> expected = Arrays.asList(RESUME_3,RESUME_4,RESUME_1,RESUME_2);
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