package storage;

import org.junit.jupiter.api.Disabled;

public class MapStorageTest extends AbstractArrayStorageTest {
    public MapStorageTest() {
        super(new MapStorage());
    }


    @Override
    @Disabled
    protected void storageOverflowException() {
        super.storageOverflowException();
    }
}
