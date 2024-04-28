package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUiidStorage extends AbstractStorage {
    protected final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExisting(Object uuid) {
        return storage.containsKey((String) uuid);
    }

    @Override
    protected void insertResume(Object uuid, Resume resume) {
        storage.put((String) uuid, resume);
    }

    @Override
    protected void updateResume(Object uuid, Resume resume) {
        storage.put((String) uuid, resume);
    }

    @Override
    protected Resume getResume(Object uuid) {
        return storage.get((String) uuid);
    }

    @Override
    protected void removeResume(Object uuid) {
        storage.remove((String) uuid);
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
    protected List<Resume> getAll() {
        return new ArrayList<>(storage.values());
    }
}
