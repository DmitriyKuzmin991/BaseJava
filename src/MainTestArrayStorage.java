import exception.ExistStorageException;
import exception.NotExistStorageException;
import model.Resume;
import storage.SortedArrayStorage;
import storage.Storage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume("uuid1");
        Resume r2 = new Resume("uuid2");
        Resume r3 = new Resume("uuid333");
        Resume r4 = new Resume("uuid6");
        Resume r5 = new Resume("uuid4");
        Resume r6 = new Resume("uuid11");

        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r6);
        printAll();
        System.out.println("=====================================================================");

        try {
            System.out.println("Проверка update:");
            ARRAY_STORAGE.update(r4);
            ARRAY_STORAGE.update(r3);
        } catch (NotExistStorageException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================================================================");

        try {
            System.out.println("Проверка delete:");
            ARRAY_STORAGE.delete(r4.getUuid());
            ARRAY_STORAGE.delete(r4.getUuid());
        } catch (NotExistStorageException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================================================================");

        try {
            System.out.println("Проверка сохранения:");
            ARRAY_STORAGE.save(r4);
            ARRAY_STORAGE.save(r4);
        } catch (ExistStorageException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================================================================");

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        try {
            System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        } catch (NotExistStorageException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("=====================================================================");
        printAll();
        System.out.println("=====================================================================");
        ARRAY_STORAGE.delete(r1.getUuid());
        System.out.println("=====================================================================");
        printAll();
        System.out.println("=====================================================================");
        System.out.println("Вызываем метод clear()");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }
}
