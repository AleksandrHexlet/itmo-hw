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
                // ������ ��������� �� �������

                Message fromServer = readWrite.readMessage();
                // 2.6. ������� ���������� ����� � �������
                System.out.println("Answer from server to client:  ===  " + "\n" + fromServer.getText());

            }
        } catch (IOException e) {
            System.out.println("ReaderThread : " + e.getMessage());
        }
    }
    public void start() {
        try {
            // �������� ������� ReaderThread � ������ ������
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