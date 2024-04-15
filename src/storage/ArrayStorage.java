package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Object searchKey, Resume resume) {
        checkLimit(resume.getUuid());
        storage[countResumes] = resume;
        countResumes++;
    }

    @Override
    protected void removeResume(Object searchKey) {
        storage[(int)searchKey] = storage[countResumes - 1];
        storage[countResumes - 1] = null;
        countResumes--;
    }

    protected int getIndex(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
