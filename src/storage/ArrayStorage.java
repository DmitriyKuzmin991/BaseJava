package storage;

import model.Resume;

import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private static final int STORAGE_LIMIT = 10000;
    private final Resume[] storage = new Resume[STORAGE_LIMIT];
    private int countResumes;

    public void clear() {
        Arrays.fill(storage, 0, countResumes, null);
        countResumes = 0;
        System.out.println("Архив очищен");
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        boolean isResumeExisted = (index != -1);
        if (storage.length == countResumes) {
            System.out.println("Сохранить не удалось. Архив полон.");
        } else if (isResumeExisted) {
            System.out.println("Резюме с id: " + r.getUuid() + " уже есть в архиве");
        } else {
            storage[countResumes++] = r;
            System.out.println("Резюме с id: " + r.getUuid() + " сохранено");
        }
    }

    public Resume get(String uuid) {
        int index = getIndex(uuid);
        boolean isResumeExisted = (index != -1);
        return isResumeExisted ? storage[index] : null;
    }

    public void delete(String uuid) {
        int index = getIndex(uuid);
        boolean isResumeExisted = (index != -1);
        if (isResumeExisted) {
            if (countResumes > 1 && index != countResumes - 1) {
                storage[index] = storage[countResumes - 1];
            }
            storage[countResumes - 1] = null;
            countResumes--;
            System.out.println("Резюме с id: " + uuid + " удалено");
        } else {
            System.out.println("Резюме с id: " + uuid + " не найденно");
        }

    }

    public void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        boolean isResumeExisted = (index != -1);
        if (isResumeExisted) {
            storage[index] = resume;
            System.out.println("Резюме с id: " + resume.getUuid() + " обновленно");
        } else {
            System.out.println("Резюме с id: " + resume.getUuid() + " не найденно");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    public int size() {
        return countResumes;
    }

    private int getIndex(String uuid) {
        for (int i = 0; i < countResumes; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                return i;
            }
        }
        return -1;
    }
}
