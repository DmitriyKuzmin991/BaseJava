package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes;

    public final void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (countResumes >= STORAGE_LIMIT) {
            System.out.println("Сохранить не удалось. Архив полон.");
        } else if (isExisted(index)) {
            System.out.println("Резюме с id: " + resume.getUuid() + " уже есть в архиве");
        } else {
            add(index, resume);
            System.out.println("Резюме с id: " + resume.getUuid() + " сохранено");
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isExisted(index)) {
            System.out.println("Резюме с id: " + uuid + " не найденно");
        } else {
            remove(index);
            System.out.println("Резюме с id: " + uuid + " удалено");
        }
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExisted(index)) {
            storage[index] = resume;
            System.out.println("Резюме с id: " + resume.getUuid() + " обновленно");
        } else {
            System.out.println("Резюме с id: " + resume.getUuid() + " не найденно");
        }
    }

    protected abstract void add(int index, Resume resume);

    protected abstract void remove(int index);

    protected abstract int getIndex(String uuid);

    public final void clear() {
        Arrays.fill(storage, 0, countResumes, null);
        countResumes = 0;
        System.out.println("Архив очищен");
    }

    public final int size() {
        return countResumes;
    }

    public final Resume get(String uuid) {
        int index = getIndex(uuid);
        if (isExisted(index)) {
            System.out.println("Резюме с индексом " + uuid + " найдено.");
            return storage[index];
        } else {
            System.out.println("Резюме с индексом " + uuid + " не найдено.");
            return null;
        }
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    protected final boolean isExisted(int index) {
        return index > -1;
    }
}
