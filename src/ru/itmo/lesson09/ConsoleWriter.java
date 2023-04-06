package ru.itmo.lesson09;

import ru.itmo.lesson09.interfaces.СommonInterface;

public class ConsoleWriter implements СommonInterface {


    @Override
    public void log(String str) {
        System.out.println("message from ConsoleWriter: "+ str);
    }

}
