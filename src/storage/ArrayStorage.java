package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int countResumes;

    void clear() {
        for (int i = 0; i < countResumes; i++) {
            storage[i] = null;
        }
        countResumes = 0;
        System.out.println("Архив очищен");
    }

    void save(Resume r) {
        if (countResumes < storage.length) {
            storage[countResumes++] = r;
            System.out.println("Резюме сохранено");
        } else {
            System.out.println("Резюме не сохранено. Архив полный.");
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return storage[i];
            }
        }
        return null;
    }

    /*
    Способ удаления:
    Если нужное резюме единственное или находится на последнем месте в архиве,
    просто присваеваем на его место null. Иначе меняем ссылку последнему резюме на найденную позицию,
    а последнему элементу присваеваем null.
     */
    //// 123 213 2444 555 66
    void delete(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                if (countResumes != 1 && i != countResumes - 1) {
                    storage[i] = storage[countResumes - 1];
                }
                storage[countResumes - 1] = null;
                countResumes--;
                System.out.println("Резюме удалено");
                return;
            }
        }
        System.out.println("Резюме не найденно");
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    int size() {
        return countResumes;
    }
}
