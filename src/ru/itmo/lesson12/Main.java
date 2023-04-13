package ru.itmo.lesson12;

import java.io.FileNotFoundException;
import java.nio.file.AccessDeniedException;
import java.util.jar.JarException;

public class Main {
    public static void main(String[] args) {

        try {
            ExceptionClass.throwException(Status.FILE_NOT_FOUND);
        }catch (JarException |FileNotFoundException exception){
            exception.printStackTrace();
        }catch (AccessDeniedException exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException();
        }

        try {
            ExceptionClass.throwException(Status.JAR_ERROR);
        }catch (JarException |FileNotFoundException exception){
            exception.printStackTrace();
        } catch (AccessDeniedException exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException();
        }

        try {

            ExceptionClass.throwException(Status.ACCESS_DENIED);
        }catch (JarException |FileNotFoundException exception){
            exception.printStackTrace();
        }catch (AccessDeniedException exception){
            System.out.println(exception.getMessage());
            throw new RuntimeException();
        }




        /*
        При вызове метода throwException обработать исключения следующим образом:

FileNotFoundException - выводить в консоль стек трейс,
AccessDeniedException* - выводить в консоль сообщение исключения (метод getMessage()) и выбрасывать исключение времени выполнения,
JarException - выводить в консоль стек трейс.
enum с необходимыми константами нужно создать.
         */


    }
}
/*
Задание на исключения
Объявить метод static void throwException(Status status) throws JarException, FileNotFoundException, AccessDeniedException, который принимает на вход enum и выбрасывает следующие исключения в зависимости от значения status:

если status FILE_NOT_FOUND, выбрасывает FileNotFoundException
если status ACCESS_DENIED, выбрасывает AccessDeniedException
если status JAR_ERROR, выбрасывает JarException.
При вызове метода throwException обработать исключения следующим образом:

FileNotFoundException - выводить в консоль стек трейс,
AccessDeniedException* - выводить в консоль сообщение исключения (метод getMessage()) и выбрасывать исключение времени выполнения,
JarException - выводить в консоль стек трейс.
enum с необходимыми константами нужно создать.
 */