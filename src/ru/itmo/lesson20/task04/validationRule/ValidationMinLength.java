package ru.itmo.lesson20.task04.validationRule;

import ru.itmo.lesson20.task04.IValidation;

public class ValidationMinLength implements IValidation {
    @Override
    public boolean validationFile(String nameFile) {

        if (nameFile.length() >= 2) {
            System.out.println("nameFile = "+ nameFile +" ;ValidationMinLength nameFile.length() = true");
            return true;
        } else {
            System.out.println("nameFile = "+ nameFile +" ;ValidationMinLength nameFile.length() = false");
            return false;
        }
    }
}
