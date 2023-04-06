package ru.itmo.lesson09.utils;

import ru.itmo.lesson09.AppFileWriter;
import ru.itmo.lesson09.ConsoleWriter;
import ru.itmo.lesson09.interfaces.СommonInterface;

public class Delimiter extends ParentUtils implements СommonInterface {



    public Delimiter(СommonInterface сommonInterfaceOUT) {
        super(сommonInterfaceOUT);
    }


    @Override
    public void log(String str) {
         str = "===" + str + "===";
          сommonInterface.log(str);


    };

    /*
        После вызова метода log к переданному в метод тексту (с обеих сторон)
        должны быть добавлены символы === (функционал обеспечивает метод класса Delimiter).
        Далее переданный в метод текст, к которому уже добавлены символы ===, приводится к верхнему регистру
        (функционал обеспечивает метод класса Upper).
         Далее сформированный текст выводится в консоль ( функционал обеспечивает метод класса ConsoleWriter)
         */


}


/*
После вызова метода log к переданному в метод тексту (с обеих сторон)
должны быть добавлены символы === (функционал обеспечивает метод класса Delimiter).
Далее переданный в метод текст, к которому уже добавлены символы ===, приводится к верхнему регистру
(функционал обеспечивает метод класса Upper).
Далее сформированный текст выводится в консоль ( функционал обеспечивает метод класса ConsoleWriter)
 */