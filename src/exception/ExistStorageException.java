package exception;

public class ExistStorageException extends StorageException {
    public ExistStorageException(String uuid) {
        super("Резюме с id: " + uuid + " уже есть в архиве", uuid);
    }
}
