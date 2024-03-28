package storage;

import model.Resume;

public abstract class AbstractArrayStorage implements Storage{
    protected static final int STORAGE_LIMIT = 10000;

    protected final Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int countResumes;
    public final Resume get(String uuid){
        int index = getIndex(uuid);
        if (isExisted(index)) {
            System.out.println("Резюме с индексом " + uuid + " найдено.");
            return storage[index];
        } else {
            System.out.println("Резюме с индексом " + uuid + " не найдено.");
            return null;
        }
    }

    protected abstract int getIndex(String uuid);

    protected boolean isExisted(int index) {
        return index != -1;
    }
}
