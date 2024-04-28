package storage;

import model.Resume;

import java.util.Collections;
import java.util.Comparator;

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
        int positionElement = (int)searchKey;
        System.arraycopy(storage, positionElement + 1, storage, positionElement, (countResumes - positionElement));
        countResumes--;
    }

    @Override
    protected Object getSearchKey(String uuid) {
        Resume keySearch = new Resume(uuid,"");
        return Collections.binarySearch(getAll(),keySearch,
                Comparator.comparing(Resume::getUuid));
    }
}