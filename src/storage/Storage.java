package storage;

import model.Resume;

import java.util.List;

public interface Storage {
    void save(Resume resume);
    void delete(String uuid);
    void update(Resume resume);
    void clear();
    int size();
    Resume get(String uuid);
    List<Resume> getAllSorted();
}
