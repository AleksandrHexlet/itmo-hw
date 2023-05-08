package ru.itmo.lesson20.task04;

import java.util.function.Predicate;

@FunctionalInterface
public interface IValidation {


    boolean validationFile(String nameFile);

    default IValidation andRule(IValidation nextRule) {
        return nameFile -> {

            boolean isValid = validationFile(nameFile) == true ? nextRule.validationFile(nameFile) : false;

            return isValid;
        };

    };

    default IValidation orRule(IValidation nextRule) {
        return nameFile -> {
            boolean state = true;
            if (!(validationFile(nameFile))) {
                state = nextRule.validationFile(nameFile);
            }
            return state;
        };
    }

}
