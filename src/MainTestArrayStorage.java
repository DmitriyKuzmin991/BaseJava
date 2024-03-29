import model.Resume;
import storage.SortedArrayStorage;
import storage.Storage;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final Storage ARRAY_STORAGE = new SortedArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid333");
        Resume r4 = new Resume();
        r4.setUuid("uuid6");
        Resume r5 = new Resume();
        r5.setUuid("uuid4");
        Resume r6 = new Resume();
        r6.setUuid("uuid11");

        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r5);
        ARRAY_STORAGE.save(r6);
        printAll();
        System.out.println("=====================================================================");

        System.out.println("Проверка update:");
        ARRAY_STORAGE.update(r4);
        ARRAY_STORAGE.update(r3);
        System.out.println("=====================================================================");

        System.out.println("Проверка delete:");
        ARRAY_STORAGE.delete(r4.getUuid());
        ARRAY_STORAGE.delete(r4.getUuid());
        System.out.println("=====================================================================");

        System.out.println("Проверка сохранения:");
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r4);
        System.out.println("=====================================================================");

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());
        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));
        System.out.println("=====================================================================");
        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        System.out.println("=====================================================================");
        printAll();
        System.out.println("=====================================================================");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {
        System.out.println("\nGet All");
        for (Resume r : ARRAY_STORAGE.getAll()) {
            System.out.println(r);
        }
    }
}
