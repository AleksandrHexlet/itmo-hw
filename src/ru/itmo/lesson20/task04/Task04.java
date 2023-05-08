package ru.itmo.lesson20.task04;

import ru.itmo.lesson20.task04.validationRule.*;

public class Task04 {
    public static void main(String[] args) {
        // Объекты FileStorage хранят имена файлов, имена файлов не должны дублироваться.
        // Правила валидации могут быть разными, но должна быть возможность их объединять.
        // При создании экземпляра FileStorage передается ссылка на правила валидации
        // (одно или несколько, собранных в цепочку).
        // Должна быть возможность изменить правила валидации.
        // Перед добавлением в FileStorage, имя файла должно проходить проверку согласно
        // установленным ранее правилам.
        // Если имя не прошло проверку, оно не добавляется в хранилище


        // имя файла будет добавлено, если оно прошло проверку:
        // правилом01 + правилом02 или правилом03 + правилом04

        // Можно написать свой функциональный интерфейс, чтобы закрепить синтаксис,
        // или использовать подходящий из пакета java.util.function и разобраться с его методами


        FileStorage storage = new FileStorage(new ValidationIsLowerCaseFirstLetter()
                .andRule(new ValidationNormalLength().orRule(new ValidationMinLength()))
                .andRule(new ValidationMaxLength()));

        if (storage.addFile("Tarhun")) {
            System.out.println("File Tarhun Add");
        } else {
            System.out.println("File Tarhun not Add");
        }
        if (storage.addFile("buratino")) {
            System.out.println("File buratino Add");
        } else {
            System.out.println("File buratino not Add");
        }
        if (storage.addFile("buratino")) {
            System.out.println("File buratino second time Add");
        } else {
            System.out.println("File buratino second time not Add");
        }

        if (storage.addFile("pepsi")) {
            System.out.println("File pepsi Add");
        } else {
            System.out.println("File pepsi not Add");
        }

    }
}
