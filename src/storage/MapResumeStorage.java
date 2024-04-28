package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResumeStorage extends AbstractStorage<Resume> {
    
    private final Map<String, Resume> map = new HashMap<>();
    @Override
    protected Resume getSearchKey(String uuid) {
        return map.get(uuid);
    }

    @Override
    protected boolean isExisting(Resume searchKey) {
        return searchKey != null;
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    protected void insertResume(Resume searchKey, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Resume searchKey, Resume resume) {
        map.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Resume searchKey) {
        return searchKey;
    }

    @Override
    protected void removeResume(Resume searchKey) {
        map.remove(searchKey.getUuid());
    }

    @Override
    public void clear() {
    map.clear();
    }

    @Override
    public int size() {
        return map.size();
    }
}
