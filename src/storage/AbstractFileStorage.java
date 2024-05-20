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

    protected abstract void doWrite(File file, Resume resume) throws IOException;

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
            doWrite(file, resume);
        } catch (IOException e) {
            throw new StorageException("File write error", resume.getUuid(), e);
        }
    }

    @Override
    protected Resume getResume(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StorageException("File read error", file.getName(), e);
        }
    }

    @Override
    protected void insertResume(File file, Resume resume) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new StorageException("Couldn't create file " + file.getAbsolutePath(), file.getName(), e);
        }
        updateResume(file, resume);
    }

    @Override
    protected void removeResume(File file) {
        if (!file.delete()) {
            throw new StorageException("File deleted error", file.getName());
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
        File[] files = getCheckedListFiles();
        List<Resume> result = new ArrayList<>(files.length);
        for (File file : files) {
            result.add(getResume(file));
        }
        return result;
    }

    @Override
    public void clear() {
        File[] files = getCheckedListFiles();
        for (File file : files) {
            removeResume(file);
        }
    }

    @Override
    public int size() {
        String[] files = directory.list();
        if (files != null) {
            return files.length;
        } else {
            throw new StorageException("Directory read error", null);
        }

    }

    private File[] getCheckedListFiles() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageException("Directory read error", null);
        }
        return files;
    }
}

