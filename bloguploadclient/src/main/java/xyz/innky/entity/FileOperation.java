package xyz.innky.entity;

import java.io.File;

public class FileOperation {
    public enum Operation{
        DEL,UPLOAD,OVER_WRITE,MKDIR,RMDIR
    }
    public Operation operation;
    public File file;

    @Override
    public String toString() {
        return "{" +
                "operation=" + operation +
                ", file=" + file.getName() +
                '}';
    }

    public FileOperation(Operation operation, File file) {
        this.operation = operation;
        this.file = file;
    }
}
