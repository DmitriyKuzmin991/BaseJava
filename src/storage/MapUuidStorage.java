package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected boolean isExisting(String uuid) {
        return storage.containsKey(uuid);
    }

    @Override
    protected void insertResume(String uuid, Resume resume) {
        storage.put(uuid, resume);
    }

    @Override
    protected void updateResume(String uuid, Resume resume) {
        storage.put(uuid, resume);
    }

    @Override
    protected Resume getResume(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void removeResume(String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected String getSearchKey(String uuid) {
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
