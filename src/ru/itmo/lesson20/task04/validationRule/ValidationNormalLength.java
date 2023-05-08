package ru.itmo.lesson20.task04.validationRule;

import ru.itmo.lesson20.task04.IValidation;

public class ValidationNormalLength implements IValidation {
    @Override
    public boolean validationFile(String nameFile) {

        if (nameFile.length() >= 7 && nameFile.length() <= 17 ) {
            System.out.println("nameFile = "+ nameFile + " ; ValidationNormalLength nameFile.length() = true");
            return true;
        } else {
            System.out.println("nameFile = "+ nameFile + " ; ValidationNormalLength nameFile.length() = false");
            return false;
        }
    }
}
