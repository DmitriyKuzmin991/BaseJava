package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage extends AbstractStorage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes;

    public final void clear() {
        Arrays.fill(storage, 0, countResumes, null);
        countResumes = 0;
        System.out.println("Архив очищен");
    }

    public final int size() {
        return countResumes;
    }

    protected final void checkLimit(String uuid) {
        if (countResumes >= STORAGE_LIMIT) {
            throw new StorageException("Сохранить " + uuid + " не удалось. Архив полон.",
                    uuid);
        }
    }

    @Override
    protected final Resume getResume(Object keySearch) {
        int index = (int) keySearch;
        return storage[index];
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    @Override
    protected final void updateResume(Object keySearch, Resume resume) {
        int index = (int) keySearch;
        storage[index] = resume;
    }

    @Override
    protected Object getExistingSearchKey(Object searchKey, String uuid) {
        int key = (int) searchKey;
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    @Override
    protected Object getNotExistingSearchKey(Object searchKey, String uuid) {
        int key = (int) searchKey;
        if (isExisting(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }
}