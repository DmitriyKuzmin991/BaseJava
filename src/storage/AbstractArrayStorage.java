package storage;

import exception.ExistStorageException;
import exception.NotExistStorageException;
import exception.StorageException;
import model.Resume;

import java.util.Arrays;

public abstract class AbstractArrayStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes;

    public final void save(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (countResumes >= STORAGE_LIMIT) {
            throw new StorageException("Сохранить " +resume.getUuid() + " не удалось. Архив полон.",
                    resume.getUuid());
        } else if (isExisting(index)) {
            throw new ExistStorageException("Резюме с id: " + resume.getUuid() + " уже есть в архиве",
                    resume.getUuid());
        } else {
            insertResume(index, resume);
            countResumes++;
            System.out.println("Резюме с id: " + resume.getUuid() + " сохранено");
        }
    }

    public final void delete(String uuid) {
        int index = getIndex(uuid);
        if (!isExisting(index)) {
            throw new NotExistStorageException("Резюме с id: " + uuid + " не найденно", uuid);
        } else {
            removeResume(index);
            countResumes--;
            System.out.println("Резюме с id: " + uuid + " удалено");
        }
    }

    public final void update(Resume resume) {
        int index = getIndex(resume.getUuid());
        if (isExisting(index)) {
            storage[index] = resume;
            System.out.println("Резюме с id: " + resume.getUuid() + " обновленно");
        } else {
            throw new NotExistStorageException("Резюме с id: " + resume.getUuid() + " не найденно", resume.getUuid());
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
        if (isExisting(index)) {
            System.out.println("Резюме с индексом " + uuid + " найдено.");
            return storage[index];
        } else {
            throw new NotExistStorageException("Резюме с id: " + uuid + " не найденно", uuid);
        }
    }

    public final Resume[] getAll() {
        return Arrays.copyOf(storage, countResumes);
    }

    protected final boolean isExisting(int index) {
        return index > -1;
    }

    protected abstract void insertResume(int index, Resume resume);

    protected abstract void removeResume(int index);

    protected abstract int getIndex(String uuid);
}
