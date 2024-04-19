package storage;

import exception.StorageException;
import model.Resume;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static storage.AbstractArrayStorage.STORAGE_LIMIT;

abstract class AbstractArrayStorageTest extends AbstractStorageTest{
    public AbstractArrayStorageTest(Storage storage) {
        super(storage);
    }

    @Test
    protected void storageOverflowException() {
        storage.clear();
        Assertions.assertDoesNotThrow(() -> {
                    for (int i = 0; i < STORAGE_LIMIT; i++) {
                        storage.save(new Resume("uuid" + i));
                    }
                }
                , "Переполнение произошло раньше времени."
        );
        Assertions.assertThrows(StorageException.class, () -> storage.save(new Resume("uuid" + STORAGE_LIMIT)));
    }
}

