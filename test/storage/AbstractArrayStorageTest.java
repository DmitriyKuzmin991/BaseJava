package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

abstract class AbstractArrayStorageTest {
    protected static Storage storage;
    protected static final Resume RESUME_1 = new Resume("uuid1");
    protected static final Resume RESUME_2 = new Resume("uuid2");

    public AbstractArrayStorageTest(Storage st) {
        storage = st;
    }

    @BeforeEach
    public void setUp() {
        storage.clear();
        storage.save(RESUME_1);
    }

    @Test
    protected void save() {
        Assertions.assertTrue(storage.save(RESUME_2));
    }

    @Test
    protected void storageOverflowException() {
        for (int i = 2; i < 10001; i++) {
            storage.save(new Resume("uuid" + i));
        }
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume("uuid10003")));
    }

    @Test
    protected void saveExistException() {
        Assertions.assertThrows(ExistStorageException.class, () -> storage.save(RESUME_1));
    }

    @Test
    protected void delete() {
        Assertions.assertTrue(storage.delete("uuid1"));
    }

    @Test
    protected void deleteNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.delete("uuid3"));
    }

    @Test
    protected void update() {
        Assertions.assertTrue(storage.update(RESUME_1));
    }

    @Test
    protected void updateNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.update(RESUME_2));
    }

    @Test
    protected void clear() {
        storage.clear();
        Assertions.assertEquals(0, storage.size());
    }

    @Test
    protected void size() {
        Assertions.assertEquals(1, storage.size());
    }

    @Test
    protected void get() {
        Assertions.assertEquals(storage.get("uuid1"), RESUME_1);
    }

    @Test
    protected void getNotExistException() {
        Assertions.assertThrows(NotExistStorageException.class, () -> storage.get("uuid2"));
    }

    @Test
    protected void getAll() {
        boolean result = Arrays.deepEquals(storage.getAll(), new Resume[]{RESUME_1});
        Assertions.assertTrue(result);
    }
}