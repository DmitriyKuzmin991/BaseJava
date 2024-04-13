package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        String uuid = resume.getUuid();
        int index = getIndex(uuid);
        checkLimit(uuid);
        if (isExisting(index)) {
            throw new ExistStorageException(uuid);
        } else {
            insertResume(index, resume);
            System.out.println("Резюме с id: " + uuid + " сохранено");
        }
    }

    @Override
    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isExisting(index)) {
            throw new NotExistStorageException(uuid);
        } else {
            removeResume(index);
            System.out.println("Резюме с id: " + uuid + " удалено");
        }
    }

    @Override
    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExisting(index)) {
            updateResume(index, resume);
            System.out.println("Резюме с id: " + resume.getUuid() + " обновленно");
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (isExisting(index)) {
            System.out.println("Резюме с индексом " + uuid + " найдено.");
            return getResume(index);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected final boolean isExisting(int index) {
        return index > -1;
    }

    protected abstract void updateResume(int index, Resume resume);

    protected abstract Resume getResume(int index);

    protected abstract void insertResume(int index, Resume resume);

    protected abstract void removeResume(int index);

    protected abstract int getIndex(String uuid);

    protected abstract void checkLimit(String uuid);
}

