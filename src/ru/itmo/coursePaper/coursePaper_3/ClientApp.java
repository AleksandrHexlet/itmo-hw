package ru.itmo.coursePaper.coursePaper_3;

import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
import ru.itmo.coursePaper.coursePaper_3.executors.*;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;


// 2.7. закрывает соединение с сервером


public class ClientApp {
    private InetSocketAddress remote;
    Socket socket;
    ReadWrite readWrite;

    // При создании клиента в конструктор передается экземпляр InetSocketAddress,
    // который хранит IP сервера и порт.
    public ClientApp(InetSocketAddress remote) {
        this.remote = remote;

    }

    public void start() {


        System.out.println(1);
//        try (GetTxtFileFromServer getTxtFile = new GetTxtFileFromServer(socket);
//             SendTxtFileToServer sendTxtFile = new SendTxtFileToServer(socket));
        try {
            System.out.println(2);
            socket = new Socket(remote.getHostString(), remote.getPort());
            readWrite = new ReadWrite(socket);
            System.out.println("client " + 3 + " ; port == " + socket.getPort());
            WriterThread writerThread = new WriterThread(readWrite);//поток на отправку
            writerThread.start();

            ReaderThread readerThread = new ReaderThread(readWrite); //поток на получение
            System.out.println("client " + 4);
            readerThread.start();
//            try {
//                readerThread.join();
//            } catch (InterruptedException ex) {
//                System.out.println(ex.getMessage());
//            }


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 1234;
        InetSocketAddress remote = new InetSocketAddress(ip, port);

        ClientApp clientApp = new ClientApp(remote);
        clientApp.start();
        System.out.println("client " + 7);
    }

}    /*
        InetSocketAddress local = new InetSocketAddress(ip, 1111);

        Socket socket = new Socket();
        // Socket socket = new Socket(ip, port); // соединение с удаленным сервером
        // Socket socket = new Socket(remote.getHostString(), remote.getPort());
        OutputStream output = null;
        InputStream input = null;
        try {
            // socket.bind(local);
            System.out.println(socket.isBound());

            socket.connect(remote, 10000); // соединение с удаленным сервером
            System.out.println(socket.isConnected());

            System.out.println(socket.getReceiveBufferSize());
            System.out.println(socket.getSendBufferSize());
            System.out.println(socket.getLocalSocketAddress());
            System.out.println(socket.getRemoteSocketAddress());

            output = socket.getOutputStream();
            input = socket.getInputStream();

            output.write(11);
            System.out.println(input.read());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        */





/*
Scanner scanner = new Scanner(System.in);
        flexiblePool.execute(() -> {
            while (true) {

                long threadId = Thread.currentThread().getId();
                System.out.println("id потока который выполняет задачу === " + threadId);

                // 2.1. запрашивает текст сообщения (запрос) у пользователя
                System.out.println("Доступные опции: 1) Введите /sendfile для создания и отправки файла на сервер" + "\n" +
                        " 2) Введите /getfile для создания и отправки файла на сервер" + "\n" +
                        "3) Введите /exit для выхода");
                String text = scanner.nextLine();
                // И так до тех пор, пока пользователь не введет '/exit'

                // 2.2. устанавливает соединение с сервером
                try (Socket socket = new Socket(remote.getHostString(), remote.getPort());
                     GetTxtFileFromServer getTxtFile = new GetTxtFileFromServer(socket);
                     SendTxtFileToServer sendTxtFile = new SendTxtFileToServer(socket);
                     ReadWrite readWrite = new ReadWrite(socket)) {
                    if ("/exit".equals(text)) return;
                    if ("/sendfile".equals(text)) {
                        sendTxtFile.sendFileToServer();
                    }
                    ;
                    if ("/getfile".equals(text)) {
                        getTxtFile.getFileFromServer();
                    }
                    // 2.3. создает экземпляр сообщения
                    Message message = new Message(text);
                    // 2.4. отправляет сообщение на сервер


                    System.out.println("Сообщение которое отправляет клиент на  сервер == " + message.getText());

                    readWrite.writeMessage(message);
                    // 2.5. получает ответ
                    Message fromServer = readWrite.readMessage();
                    // 2.6. выводит полученный ответ в консоль
                    System.out.println("Ответ который пришел от сервера к клиенту ClientApp 2.6  ===  " + "\n" + fromServer.getText());
                } catch (UnknownHostException e) {
                    System.out.println("Ошибка в IP сервера");
                } catch (IOException e) {
                    System.out.println("Сервер не отвечает");
                }
            }
        });

 */