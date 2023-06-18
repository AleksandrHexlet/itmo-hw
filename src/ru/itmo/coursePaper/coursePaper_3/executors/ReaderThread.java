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

                Message fromServer = (Message)readWrite.readMessage();
                System.out.println("в ReaderThread ; thread name == " + Thread.currentThread().getName());
                // 2.6. выводит полученный ответ в консоль
                System.out.println("Answer from server to client:  ===  " + fromServer.getText());

            }
        } catch (IOException e) {
            System.out.println("Сервер не отвечает. Программа завершила работу. \n Сообщение об ошибке из ReaderThread : " + e.getMessage());
        return;
        }
    }

}