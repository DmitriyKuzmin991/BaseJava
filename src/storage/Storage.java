package storage;

import model.Resume;

public interface Storage {
    void save(Resume resume);
    void delete(String uuid);
    void update(Resume resume);
    Resume get(String uuid);
    Resume[] getAll();
    void clear();
    int size();
}
