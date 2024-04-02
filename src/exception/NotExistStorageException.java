package exception;

public class NotExistStorageException extends StorageException {
    public NotExistStorageException(String uuid) {
        super("Резюме с id: " + uuid + " не найденно", uuid);
    }
}
