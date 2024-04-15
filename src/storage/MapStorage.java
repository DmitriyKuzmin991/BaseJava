package storage;

import model.Resume;

import java.util.HashMap;
import java.util.Map;

public class MapStorage extends AbstractStorage {
    private final Map<String, Resume> storage = new HashMap<>();

    @Override
    protected void insertResume(int index, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(int index, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(int index, String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected void removeResume(int index, String uuid) {
        storage.remove(uuid);
    }

    @Override
    protected int getIndex(String uuid) {
        return storage.containsKey(uuid) ? 1 : -1;
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
