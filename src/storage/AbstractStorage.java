package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Collections;
import java.util.List;

public abstract class AbstractStorage <SK> implements Storage {

    protected abstract void updateResume(SK searchKey, Resume resume);

    protected abstract Resume getResume(SK searchKey);

    protected abstract void insertResume(SK searchKey, Resume resume);

    protected abstract void removeResume(SK searchKey);

    protected abstract SK getSearchKey(String uuid);

    protected abstract boolean isExisting(SK searchKey);

    protected abstract List<Resume> getAll();

    @Override
    public final void save(Resume resume) {
        SK searchKey = getNotExistingSearchKey(resume.getUuid());
        insertResume(searchKey, resume);
    }

    @Override
    public final void delete(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        removeResume(searchKey);
    }

    @Override
    public final void update(Resume resume) {
        SK searchKey = getExistingSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public final Resume get(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        return getResume(searchKey);
    }

    protected SK getExistingSearchKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected SK getNotExistingSearchKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExisting(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }
}