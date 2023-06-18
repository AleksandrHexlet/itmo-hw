package src.ru.itmo.coursePaper.coursePaper_3.executors;



import src.ru.itmo.coursePaper.coursePaper_3.common.Message;
import src.ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

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

                Message fromServer = (Message)readWrite.readMessageInClientFromServer();

                // выводит полученный ответ в консоль
                System.out.println("Answer from server to client:  === \n" + fromServer.getText());

            }
        } catch (IOException e) {
            System.out.println("Сервер не отвечает. Программа завершила работу. \n Сообщение об ошибке из ReaderThread : " + e.getMessage());
        return;
        }
    }

}