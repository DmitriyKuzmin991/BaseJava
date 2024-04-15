package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Object searchKey, Resume resume) {
        checkLimit(resume.getUuid());
        int insertPosition = -(int)searchKey - 1;
        if (insertPosition < countResumes) {
            System.arraycopy(storage, insertPosition, storage, insertPosition + 1, (countResumes - insertPosition));
        }
        storage[insertPosition] = resume;
        countResumes++;
    }

    @Override
    protected void removeResume(Object searchKey) {
        int position = (int)searchKey;
        System.arraycopy(storage, position + 1, storage, position, (countResumes - position));
        countResumes--;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume keySearch = new Resume(uuid);
        return Arrays.binarySearch(getAll(), 0, size(), keySearch);
    }
}