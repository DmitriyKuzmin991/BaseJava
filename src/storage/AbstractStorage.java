package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getIndex(uuid);
        if (isExisting(searchKey)) {
            throw new ExistStorageException(uuid);
        } else {
            insertResume((int) searchKey, resume);
            System.out.println("Резюме с id: " + uuid + " сохранено");
        }
    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getIndex(uuid);
        if (!isExisting(searchKey)) {
            throw new NotExistStorageException(uuid);
        } else {
            removeResume(searchKey);
            System.out.println("Резюме с id: " + uuid + " удалено");
        }
    }

    @Override
    public final void update(Resume resume) {
        Object searchKey = getIndex(resume.getUuid());
        if (isExisting(searchKey)) {
            updateResume(searchKey, resume);
            System.out.println("Резюме с id: " + resume.getUuid() + " обновленно");
        } else {
            throw new NotExistStorageException(resume.getUuid());
        }
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getIndex(uuid);
        if (isExisting(searchKey)) {
            System.out.println("Резюме с индексом " + uuid + " найдено.");
            return getResume(searchKey);
        } else {
            throw new NotExistStorageException(uuid);
        }
    }

    protected final boolean isExisting(Object searchKey) {
        return (int) searchKey > -1;
    }

    private int getExistingSearchKey(Object searchKey, String uuid) {
        if (isExisting(searchKey)) {
            throw new ExistStorageException(uuid);
        }
            return (int) searchKey;
    }

    private int getNotExistingSearchKey(Object searchKey, String uuid) {
        if (!isExisting(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
        return (int) searchKey;
    }

        protected abstract void updateResume (Object searchKey, Resume resume);

        protected abstract Resume getResume (Object searchKey);

        protected abstract void insertResume (Object searchKey, Resume resume);

        protected abstract void removeResume (Object searchKey);

        protected abstract int getIndex (String uuid);
    }