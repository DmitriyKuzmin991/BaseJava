package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getSearchKey(uuid);
        insertResume(getNotExistingSearchKey(searchKey, uuid), resume);
        System.out.println("Резюме с id: " + uuid + " сохранено");
    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getSearchKey(uuid);
        removeResume(getExistingSearchKey(searchKey, uuid));
        System.out.println("Резюме с id: " + uuid + " удалено");
    }

    @Override
    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getSearchKey(uuid);
        updateResume(getExistingSearchKey(searchKey, uuid), resume);
        System.out.println("Резюме с id: " + uuid + " обновленно");
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getSearchKey(uuid);
        return getResume(getExistingSearchKey(searchKey, uuid));
    }

    protected boolean isExisting(int searchKey) {
        return searchKey > -1;
    }

    protected Object getExistingSearchKey(Object searchKey, String uuid) {
        int key = (int) searchKey;
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }


    protected Object getNotExistingSearchKey(Object searchKey, String uuid) {
        int key = (int) searchKey;
        if (isExisting(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }


    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void insertResume(Object searchKey, Resume resume);

    protected abstract void removeResume(Object searchKey);

    protected abstract Object getSearchKey(String uuid);
}