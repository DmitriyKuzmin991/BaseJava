package storage;

import model.Resume;

public interface Storage {
    boolean save(Resume resume);
    boolean delete(String uuid);
    boolean update(Resume resume);
    void clear();
    int size();
    Resume get(String uuid);
    Resume[] getAll();
}
