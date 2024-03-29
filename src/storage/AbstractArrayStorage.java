package storage;

import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes;

    public abstract void save(Resume r);

    public abstract void delete(String uuid);

    protected abstract int getIndex(String uuid);

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExisted(index)) {
            storage[index] = resume;
            System.out.println("Резюме с id: " + resume.getUuid() + " обновленно");
        } else {
            System.out.println("Резюме с id: " + resume.getUuid() + " не найденно");
        }
    }

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
