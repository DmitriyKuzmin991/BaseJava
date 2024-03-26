package storage;

import model.Resume;

/**
 * Test for your storage.ArrayStorage implementation
 */
public class MainTestArrayStorage {
    static final ArrayStorage ARRAY_STORAGE = new ArrayStorage();

    public static void main(String[] args) {
        Resume r1 = new Resume();
        r1.setUuid("uuid1");
        Resume r2 = new Resume();
        r2.setUuid("uuid2");
        Resume r3 = new Resume();
        r3.setUuid("uuid3");
        Resume r4 = new Resume();
        r4.setUuid("uuid4");

        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);
        System.out.println();

        System.out.println("Проверка update:");
        ARRAY_STORAGE.update(r4);
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.update(r4);
        System.out.println();

        System.out.println("Проверка delete:");
        ARRAY_STORAGE.delete(r4.getUuid());
        ARRAY_STORAGE.delete(r4.getUuid());
        System.out.println();

        System.out.println("Проверка сохранения:");
        ARRAY_STORAGE.save(r4);
        ARRAY_STORAGE.save(r4);
        System.out.println();

//        System.out.println("Проверка переполнения архива");
//        Resume[] resumes = new Resume[8];
//        for (int i = 0; i < resumes.length; i++) {
//            resumes[i] = new Resume();
//            resumes[i].setUuid("uuid" + (i + 5));
//        }
//        for (Resume r : resumes) {
//            ARRAY_STORAGE.save(r);
//        }
//        System.out.println();

        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        printAll();
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();
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
