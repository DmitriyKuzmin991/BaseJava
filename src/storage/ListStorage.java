package storage;

import model.Resume;

import java.util.ArrayList;
import java.util.List;

public class ListStorage extends AbstractStorage {
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
    protected Resume getResume(Object searchKey) {
        int index = (int) searchKey;
        return storage.get(index);
    }

    @Override
    public Resume[] getAll() {
        return storage.toArray(new Resume[0]);
    }

    @Override
    protected void insertResume(Object searchKey, Resume resume) {
        storage.add(resume);
    }

    @Override
    protected void removeResume(Object searchKey) {
        int index = (int) searchKey;
        storage.remove(index);
    }

    @Override
    protected Object getSearchKey(String uuid) {
        return storage.indexOf(new Resume(uuid));
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        int index = (int)searchKey;
        storage.set(index, resume);
    }
}