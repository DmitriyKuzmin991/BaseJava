import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    private final Resume[] storage = new Resume[10000];
    private int countResume = 0;

    void clear() {
        for (int i = 0; i < countResume; i++) {
            storage[i] = null;
        }
        countResume = 0;
        System.out.println("Архив очищен");
    }

    void save(Resume r) {
        if(countResume < storage.length){
            storage[countResume++] = r;
            System.out.println("Резюме сохранено");
        } else {
            System.out.println("Резюме не сохранено. Архив полный.");
        }
    }

    Resume get(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
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
    void delete(String uuid) {
        for (int i = 0; i < countResume; i++) {
            if (storage[i].uuid.equals(uuid)) {
                if (countResume == 1 && i == countResume - 1) {
                    storage[i] = null;
                } else {
                    storage[i] = storage[countResume - 1];
                    storage[countResume - 1] = null;
                }
                countResume--;
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
        return Arrays.copyOf(storage, countResume);
    }

    int size() {
        return countResume;
    }
}
