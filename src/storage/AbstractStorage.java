package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getIndex(uuid);
        insertResume(getNotExistingSearchKey(searchKey, uuid), resume);
        System.out.println("Резюме с id: " + uuid + " сохранено");
    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getIndex(uuid);
        removeResume(getExistingSearchKey(searchKey, uuid), uuid);
        System.out.println("Резюме с id: " + uuid + " удалено");
    }

    @Override
    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getIndex(uuid);
        updateResume(getExistingSearchKey(searchKey, uuid), resume);
        System.out.println("Резюме с id: " + uuid + " обновленно");
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getIndex(uuid);
        return getResume(getExistingSearchKey(searchKey, uuid), uuid);
    }

    protected final boolean isExisting(int searchKey) {
        return searchKey > -1;
    }

    private int getExistingSearchKey(Object searchKey, String uuid) {
        int key = (int) searchKey;
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    private int getNotExistingSearchKey(Object searchKey, String uuid) {
        int key = (int) searchKey;
        if (isExisting(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected abstract void updateResume(int index, Resume resume);

    protected abstract Resume getResume(int index, String uuid);

    protected abstract void insertResume(int index, Resume resume);

    protected abstract void removeResume(int index, String uuid);

    protected abstract int getIndex(String uuid);
}