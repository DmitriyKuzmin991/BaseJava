package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(Object searchKey, Resume resume) {
        checkLimit(resume.getUuid());
        int index = (int)searchKey;
        int insertPosition = -index - 1;
        if (insertPosition < countResumes) {
            System.arraycopy(storage, insertPosition, storage, insertPosition + 1, (countResumes - insertPosition));
        }
        storage[insertPosition] = resume;
        countResumes++;
    }

    @Override
    protected void removeResume(Object searchKey) {
        int index = (int)searchKey;
        index = Math.abs(index);
        System.arraycopy(storage, index + 1, storage, index, (countResumes - index));
        countResumes--;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume keySearch = new Resume(uuid);
        return Arrays.binarySearch(getAll(), 0, size(), keySearch);
    }
}