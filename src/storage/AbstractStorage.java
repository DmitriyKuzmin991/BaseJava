package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    private static final Logger LOG = Logger.getLogger(ArrayStorage.class.getName());

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
        LOG.log(Level.INFO, "Saved " + resume.getUuid());
        insertResume(searchKey, resume);
    }

    @Override
    public final void delete(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        LOG.log(Level.INFO, "Deleted " + uuid);
        removeResume(searchKey);
    }

    @Override
    public final void update(Resume resume) {
        SK searchKey = getExistingSearchKey(resume.getUuid());
        LOG.log(Level.INFO, "Updated " + resume.getUuid());
        updateResume(searchKey, resume);
    }

    @Override
    public final Resume get(String uuid) {
        SK searchKey = getExistingSearchKey(uuid);
        LOG.log(Level.INFO, "Get " + uuid);
        return getResume(searchKey);
    }

    protected SK getExistingSearchKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (!isExisting(key)) {
            LOG.warning("Resume with " +  uuid + " uuid is not already existing.");
            throw new NotExistStorageException(uuid);
        }
        return key;
    }

    protected SK getNotExistingSearchKey(String uuid) {
        SK key = getSearchKey(uuid);
        if (isExisting(key)) {
            LOG.warning("Resume with " +  uuid + " uuid is already existing.");
            throw new ExistStorageException(uuid);
        }
        return key;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.log(Level.INFO, "GetAll resume in storage");
        List<Resume> list = getAll();
        Collections.sort(list);
        return list;
    }
}