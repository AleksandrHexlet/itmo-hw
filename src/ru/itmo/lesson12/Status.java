package ru.itmo.lesson12;

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
