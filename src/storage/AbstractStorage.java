package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getNotExistingSearchKey(uuid);
        insertResume(searchKey, resume);
        System.out.println("Резюме с id: " + uuid + " сохранено");
    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        removeResume(searchKey);
        System.out.println("Резюме с id: " + uuid + " удалено");
    }

    @Override
    public final void update(Resume resume) {
        String uuid = resume.getUuid();
        Object searchKey = getExistingSearchKey(uuid);
        updateResume(searchKey, resume);
        System.out.println("Резюме с id: " + uuid + " обновленно");
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        return getResume(searchKey);
    }

    protected boolean isExisting(int searchKey) {
        return searchKey > -1;
    }

    protected Object getExistingSearchKey(String uuid) {
        int key = (int) getSearchKey(uuid);
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }


    protected Object getNotExistingSearchKey(String uuid) {
        int key = (int)getSearchKey(uuid);
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