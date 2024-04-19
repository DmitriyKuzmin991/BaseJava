package storage;

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
        return storage[(int) keySearch];
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    @Override
    protected final void updateResume(Object keySearch, Resume resume) {
        storage[(int) keySearch] = resume;
    }

    @Override
    protected boolean isExisting(Object searchKey) {
        return (int)searchKey > -1;
    }
}