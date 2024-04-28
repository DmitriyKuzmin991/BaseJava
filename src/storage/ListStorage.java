package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage <Integer>{
    private final List<Resume> storage = new ArrayList<>();

    @Override
    public void clear() {
        storage.clear();
    }

    @Override
    public int size() {
        return storage.size();
    }

    @Override
    protected Resume getResume(Integer index) {
        return storage.get(index);
    }

    @Override
    protected List<Resume> getAll() {
        return new ArrayList<>(storage);
    }

    @Override
    protected void insertResume(Integer index, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void removeResume(Integer index) {
        storage.remove(index.intValue());
    }

    @Override
    protected Integer getSearchKey(String uuid) {
        for (int i = 0; i < size() ; i++) {
            String currentUuid = storage.get(i).getUuid();
            if (currentUuid.equals(uuid)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    protected boolean isExisting(Integer index) {
        return index > -1;
    }

    @Override
    protected void updateResume(Integer index, Resume resume) {
        storage.set(index, resume);
    }
}