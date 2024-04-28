package storage;

import exception.StorageException;
import model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArrayStorage  extends AbstractStorage <Integer>{
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
    protected final Resume getResume(Integer index) {
        return storage[index];
    }

    @Override
    protected List<Resume> getAll() {
        return Arrays.asList(Arrays.copyOf(storage, countResumes));
    }

    @Override
    protected final void updateResume(Integer index, Resume resume) {
        storage[index] = resume;
    }

    @Override
    protected boolean isExisting(Integer index) {
        return index > -1;
    }
}