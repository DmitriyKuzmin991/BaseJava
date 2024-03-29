package storage;

import model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage extends AbstractArrayStorage {
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (storage.length == countResumes) {
            System.out.println("Сохранить не удалось. Архив полон.");
        } else if (isExisted(index)) {
            System.out.println("Резюме с id: " + r.getUuid() + " уже есть в архиве");
        } else {
            storage[countResumes] = r;
            countResumes++;
            System.out.println("Резюме с id: " + r.getUuid() + " сохранено");
        }
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (isExisted(index)) {
            storage[index] = storage[countResumes - 1];
            storage[countResumes - 1] = null;
            countResumes--;
            System.out.println("Резюме с id: " + uuid + " удалено");
        } else {
            System.out.println("Резюме с id: " + uuid + " не найденно");
        }
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
