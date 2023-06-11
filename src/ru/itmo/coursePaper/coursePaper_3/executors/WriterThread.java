package ru.itmo.coursePaper.coursePaper_3.executors;


import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class WriterThread implements Runnable {


    ReadWrite readWrite;

    public WriterThread(ReadWrite readWrite) throws IOException {
        this.readWrite = readWrite;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                // 2.1. запрашивает текст сообщения (запрос) у пользователя
                System.out.println("Доступные опции: " + "\n" + "1) Введите /sendfile для создания и отправки файла на сервер" + "\n" +
                        "2) Введите /getfile для создания и отправки файла на сервер" + "\n" +
                        "3) Введите /exit для выхода");

                String text = scanner.nextLine();
                System.out.println("console text ===  " + text);
                // Чтение сообщения из консоли


                try {
                    Message message = new Message(text);
                    System.out.println("console text message.getText() ===  " + message.getText());
                    //отправляем сообщение на сервер
                    readWrite.writeMessage(message);
                } catch (IOException e) {
                    System.out.println("Сервер не отвечает");
//                    e.printStackTrace();
                    System.out.println(e.getMessage());
                }
            }
        } catch (Exception e) {

            System.out.println("Что-то пошло не так ");
//            e.printStackTrace();
        }

    }

    public void start() {
        try {
            // Создание объекта WriterThread и запуск потока
            WriterThread sender = new WriterThread(readWrite);
            Thread thread = new Thread(sender);
//            try {
//                thread.join();
//            } catch (InterruptedException e) {
//                System.out.println(e.getMessage());
//            }
            thread.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}