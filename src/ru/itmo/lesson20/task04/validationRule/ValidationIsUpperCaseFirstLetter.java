package ru.itmo.lesson20.task04.validationRule;

import ru.itmo.lesson20.task04.IValidation;

public class ValidationIsUpperCaseFirstLetter implements IValidation {
    @Override
    public boolean validationFile(String nameFile) {
        boolean isUpperCase = Character.isUpperCase(nameFile.charAt(0));
        System.out.println("nameFile = "+ nameFile +" ; isUpperCase = " + isUpperCase);
        return isUpperCase;

    }
}
