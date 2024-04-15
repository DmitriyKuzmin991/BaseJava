package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getIndex(uuid);
        getExistingSearchKey(searchKey, uuid);
        insertResume(searchKey, resume);
        System.out.println("Резюме с id: " + uuid + " сохранено");

    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getIndex(uuid);
        getNotExistingSearchKey(searchKey, uuid);
        removeResume(searchKey);
        System.out.println("Резюме с id: " + uuid + " удалено");

    }

    @Override
    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getIndex(uuid);
        getNotExistingSearchKey(searchKey, uuid);
        updateResume(searchKey, resume);
        System.out.println("Резюме с id: " + uuid + " обновленно");

    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getIndex(uuid);
        getNotExistingSearchKey(searchKey, uuid);
        return getResume(searchKey);
    }

    protected boolean isExisting(Object searchKey) {
        return (int) searchKey > -1;
    }

    private void getExistingSearchKey(Object searchKey, String uuid) {
        if (isExisting(searchKey)) {
            throw new ExistStorageException(uuid);
        }
    }

    private void getNotExistingSearchKey(Object searchKey, String uuid) {
        if (!isExisting(searchKey)) {
            throw new NotExistStorageException(uuid);
        }
    }

    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void insertResume(Object searchKey, Resume resume);

    protected abstract void removeResume(Object searchKey);

    protected abstract int getIndex(String uuid);
}