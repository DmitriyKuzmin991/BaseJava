package storage;

import exception.StorageException;
import model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected abstract void doWrite(Resume resume) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "directory most not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not  directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + " is not readable/writeable");
        }
        this.directory = directory;
    }

    @Override
    protected void updateResume(File file, Resume resume) {
        try {
            doWrite(resume);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void insertResume(File file, Resume resume) {
        try {
            file.createNewFile();
            doWrite(resume);
        } catch (IOException e) {
            throw new StorageException("IO error", file.getName(), e);
        }
    }


    @Override
    protected void removeResume(File file) {
        file.delete();
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected boolean isExisting(File file) {
        return file.exists();
    }

    @Override
    protected List<Resume> getAll() {
        File[] entries = directory.listFiles();
        if (entries != null) {
            List<Resume> result = new ArrayList<>();
            for (File file : entries) {
                try {
                    result.add(doRead(file));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return result;
        } else {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public void clear() {
        File[] entry = directory.listFiles();
        if (entry != null) {
            for (File file : entry) {
                file.delete();
            }
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if (list != null) {
            return list.length;
        }
        return 0;
    }
}
