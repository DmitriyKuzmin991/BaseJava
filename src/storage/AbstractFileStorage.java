package storage;

import exception.StorageException;
import model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private final File directory;

    protected abstract void doWrite(Resume resume) throws IOException;

    protected abstract Resume doRead(File file) throws IOException;

    protected abstract void doRemove(File file) throws IOException;

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
        try {
            doRemove(file);
        } catch (IOException e) {
            throw new StorageException("removed error", file.getName(), e);
        }
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
        File[] entries = getCheckedListFiles();
        List<Resume> result = new ArrayList<>(entries.length);
        for (File file : entries) {
            result.add(getResume(file));
        }
        return result;
    }

    @Override
    public void clear() {
        File[] entries = getCheckedListFiles();
        for (File file : entries) {
            removeResume(file);
        }
    }

    @Override
    public int size() {
        File[] entries = getCheckedListFiles();
        return entries.length;
    }

    private File[] getCheckedListFiles() {
        File[] entries = directory.listFiles();
        if (entries == null) {
            throw new StorageException(directory.getAbsolutePath() + " не является папкой/нет доступа", "");
        }
        return entries;
    }
}

