package ru.itmo.lesson09;

import ru.itmo.lesson09.interfaces.СommonInterface;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class AppFileWriter  implements СommonInterface {

    @Override
    public void log(String str) {
        System.out.println("AppFileWriter " + str);
            try {
                Files.writeString(Paths.get("data.txt"), str, StandardOpenOption.APPEND);
                // "данные" будут записаны в конец (StandardOpenOption.APPEND) файла "data.txt"
            } catch (IOException e) {
                System.out.println("Данные не были записаны");
            }

        }

}



//    Используйте следующий код для записи в файл:

//    В программе классы ConsoleWriter и AppFileWriter - классы с основным функционалом (вывод в консоль и запись в файл), могут работать самостоятельно, например:
//
//    ConsoleWriter console = new ConsoleWriter();
//    console.log("данные"); // данные будут выведены в консоль
//
//    AppFileWriter file = new AppFileWriter();
//    file.log("данные"); // данные будут записаны в файл

