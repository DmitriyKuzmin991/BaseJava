package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    protected void insertResume(int index, Resume resume) {
        index = Math.abs(index);
        int insertPosition = index - 1;
        if (index <= countResumes) {
            System.arraycopy(storage, insertPosition, storage, index, (countResumes - insertPosition));
        }
        storage[insertPosition] = resume;
        countResumes++;
    }

    @Override
    protected void removeResume(int index) {
        index = Math.abs(index);
        System.arraycopy(storage, index + 1, storage, index, (countResumes - index));
        countResumes--;
    }

    @Override
    protected int getIndex(String uuid) {
        Resume keySearch = new Resume();
        keySearch.setUuid(uuid);
        return Arrays.binarySearch(getAll(), 0, size(), keySearch);
    }
}