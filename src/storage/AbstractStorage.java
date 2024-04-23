package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Comparator;
import java.util.List;

public abstract class AbstractStorage implements Storage {
    @Override
    public final void save(Resume resume) {
        Object searchKey = getNotExistingSearchKey(resume.getUuid());
        insertResume(searchKey, resume);
    }

    @Override
    public final void delete(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        removeResume(searchKey);
    }

    @Override
    public final void update(Resume resume) {
        Object searchKey = getExistingSearchKey(resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public final Resume get(String uuid) {
        Object searchKey = getExistingSearchKey(uuid);
        return getResume(searchKey);
    }

    protected abstract boolean isExisting(Object searchKey);

    protected Object getExistingSearchKey(String uuid) {
        Object key = getSearchKey(uuid);
        if (!isExisting(key)) {
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected Object getNotExistingSearchKey(String uuid) {
        Object key = getSearchKey(uuid);
        if (isExisting(key)) {
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    protected List<Resume> sortFullNameAndUuid(List<Resume> resumes) {
        resumes.sort(Comparator.comparing(Resume::getFullName).thenComparing(Resume::getUuid));
        return resumes;
    }
    protected abstract void updateResume(Object searchKey, Resume resume);

    protected abstract Resume getResume(Object searchKey);

    protected abstract void insertResume(Object searchKey, Resume resume);

    protected abstract void removeResume(Object searchKey);

    protected abstract Object getSearchKey(String uuid);
}