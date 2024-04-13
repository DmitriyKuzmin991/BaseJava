package storage;

import org.junit.jupiter.api.Disabled;

public class ListStorageTest extends AbstractArrayStorageTest{
    public ListStorageTest() {
        super(new ListStorage());
    }

    @Override
    @Disabled
    protected void storageOverflowException() {
        super.storageOverflowException();
    }
}
