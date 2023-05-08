package ru.itmo.lesson20.task04;

import java.util.HashSet;

import java.util.Set;

public class FileStorage {
    IValidation iValidation;
    Set<String> nameFileSet = new HashSet<>();
    String name;


    public FileStorage(IValidation iValidation) {
        this.iValidation = iValidation;
    }

    public boolean addFile(String name) {
        boolean isAdd = false;
        if (iValidation.validationFile(name)) {
            isAdd = nameFileSet.add(name);
            System.out.println("isAdd = " + isAdd);
        };
        for (String nameFile: nameFileSet ) {
            System.out.println("result nameFileSet === " + nameFile);
        }
        return isAdd;
    }
}
