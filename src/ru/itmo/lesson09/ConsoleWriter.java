package ru.itmo.lesson09;

import ru.itmo.lesson09.interfaces.CommonInterface;


public class ConsoleWriter implements CommonInterface {


    @Override
    public void log(String str) {
        System.out.println("message from ConsoleWriter: "+ str);
    }

}
