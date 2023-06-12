package ru.itmo.coursePaper.coursePaper_3.executors;

import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

import java.io.*;
import java.net.*;

public class ReaderThread extends Thread {

ReadWrite readWrite;
    public ReaderThread(ReadWrite readWrite) throws IOException {
        this.readWrite = readWrite;

    }

    @Override
    public void run() {
        try {
            while (true) {
                // Чтение сообщения от сервера

                Message fromServer = readWrite.readMessage();
                System.out.println("в ReaderThread ; thread name == " + Thread.currentThread().getName());
                // 2.6. выводит полученный ответ в консоль
                System.out.println("Answer from server to client:  ===  " + fromServer.getText());

            }
        } catch (IOException e) {
            System.out.println("Чтение сообщения от сервера ReaderThread : " + e.getMessage());
        }
    }
    public void start() {
        try {
            // Создание объекта ReaderThread и запуск потока
            ReaderThread receiver = new ReaderThread(readWrite);
            Thread thread = new Thread(receiver);
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