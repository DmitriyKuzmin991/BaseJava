package storage;

import model.Resume;

import java.util.Arrays;

public class SortedArrayStorage extends AbstractArrayStorage {
    @Override
    public void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (storage.length == countResumes) {
            System.out.println("Сохранить не удалось. Архив полон.");
        } else if (index > 0) {
            System.out.println("Резюме с id: " + resume.getUuid() + " уже есть в архиве");
        } else {
            index = Math.abs(index);
            int insertPosition = index - 1;
            if (index <= countResumes) {
                System.arraycopy(storage, insertPosition, storage, index, (countResumes - insertPosition));
            }
            storage[insertPosition] = resume;
            countResumes++;
            System.out.println("Резюме с id: " + resume.getUuid() + " сохранено");
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isExisted(index)) {
            System.out.println("Резюме с id: " + uuid + " не найденно");
        } else {
            index = Math.abs(index);
            System.arraycopy(storage, index + 1, storage, index, (countResumes - index));
            System.out.println("Резюме с id: " + uuid + " удалено");
            countResumes--;
        }
    }

    @Override
    protected int getIndex(String uuid) {
        Resume keySearch = new Resume();
        keySearch.setUuid(uuid);
        return Arrays.binarySearch(getAll(), 0, size(), keySearch);
    }
}