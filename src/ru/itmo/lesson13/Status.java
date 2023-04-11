package ru.itmo.lesson13;

import java.io.FileNotFoundException;
import java.util.jar.JarException;

public enum Status {
    JAR_ERROR("JarException"), FILE_NOT_FOUND("FileNotFoundException"), ACCESS_DENIED("AccessDeniedException");

    private String name;

    Status(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
