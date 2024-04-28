package storage;

import model.Resume;

public class MapStorageResume extends MapUiidStorage {
    @Override
    protected Object getSearchKey(String uuid) {
        return storage.get(uuid);
    }

    @Override
    protected boolean isExisting(Object searchKey) {
        return searchKey != null;
    }

    @Override
    protected void insertResume(Object uuid, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected void updateResume(Object searchKey, Resume resume) {
        storage.put(resume.getUuid(), resume);
    }

    @Override
    protected Resume getResume(Object searchKey) {
        return (Resume) searchKey;
    }

    @Override
    protected void removeResume(Object searchKey) {
        Resume r = (Resume) searchKey;
        storage.remove(r.getUuid());
    }
}
