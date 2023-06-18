package ru.itmo.coursePaper.coursePaper_3.executors;


import java.io.Serial;
import java.io.Serializable;

public class FileData implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private String fileName;
    private String fileContent;

    public FileData(String fileName, String fileContent) {
        this.fileName = fileName;
        this.fileContent = fileContent;
    }

    public String getFileName() {
        return fileName;
    }

    public String getFileContent() {
        return fileContent;
    }
}