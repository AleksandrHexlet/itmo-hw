package ru.itmo.lesson20.task04.validationRule;

import ru.itmo.lesson20.task04.IValidation;

public class ValidationIsLowerCaseFirstLetter implements IValidation {
    @Override
    public boolean validationFile(String nameFile) {

        boolean isLowerCase = Character.isLowerCase(nameFile.charAt(0));
        System.out.println("nameFile = "+ nameFile + " ;ValidationIsLowerCaseFirstLetter = " + isLowerCase);
        return isLowerCase;


    }
}
