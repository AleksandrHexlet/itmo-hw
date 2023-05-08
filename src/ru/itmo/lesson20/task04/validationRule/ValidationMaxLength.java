package ru.itmo.lesson20.task04.validationRule;

import ru.itmo.lesson20.task04.IValidation;

public class ValidationMaxLength implements IValidation {
    @Override
    public boolean validationFile(String nameFile) {

        if (nameFile.length() <= 23) {
            System.out.println("nameFile = "+ nameFile +" ;ValidationMaxLength nameFile.length() = true");
            return true;
        } else {
            System.out.println("nameFile = "+ nameFile + " ;ValidationMaxLength nameFile.length() = false");
            return false;
        }
    }
}
