package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExisting(Object searchKey) {
        return storage.containsKey((String)searchKey);
    }

    @Override
    protected Object getExistingSearchKey(String uuid) {
        Object key = getSearchKey(uuid);
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        } else {
            return key;
        }
    }

    @Override
    protected Object getNotExistingSearchKey(String uuid) {
        Object key = getSearchKey(uuid);
        if (isExisting(key)) {
            throw new ExistStorageException(uuid);
        } else {
            return key;
        }
    }

    @Override
    protected void insertResume(Object searchKey, Resume resume) {
        storage.put((String) searchKey, resume);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storage.put((String) searchKey, resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return storage.get((String) searchKey);
    }

    @Override
    protected void removeResume(Object searchKey) {
        storage.remove((String) searchKey);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    public Resume[] getAll() {
        return storage.values().toArray(new Resume[0]);
    }
}
