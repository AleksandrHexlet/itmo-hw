package src.ru.itmo.coursePaper.coursePaper_3.executors;



import src.ru.itmo.coursePaper.coursePaper_3.common.Message;
import src.ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

import java.io.*;
import java.net.*;
import java.util.Comparator;
import java.util.Scanner;

public class WriterThread implements Runnable {


    ReadWrite readWrite;


    public WriterThread(ReadWrite readWrite) throws IOException {
        this.readWrite = readWrite;
        System.out.println("WriterThread is ready");
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            // 2.1. запрашивает текст сообщения (запрос) у пользователя
            System.out.println("Доступные опции: " + "\n" +
                    "1) Введите имя файла.txt и через пробел его содержимое для создания и отправки файла на сервер" + "\n" +
                    "2) Введите /getfile для получения списка загруженных файлов" + "\n" +
                    "3) Введите вместе file- и имя файла для получения этого файла" + "\n" +
                    "4) Введите любую команду для рассылки этой команды всем активным пользователям " + "\n" +
                    "5) Введите /exit для выхода"
            );



            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String userInput = null;
            try {
                userInput = reader.readLine();  // Чтение сообщения из консоли
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            if (userInput.contains("file-")) {
                Message message = new Message(userInput);
                //отправляем сообщение на сервер
                try {
                    readWrite.writeMessage(message);
                } catch (IOException e) {
                    System.out.println("Сервер не отвечает");
                    System.out.println(e.getMessage());
                }
            }  else if (userInput.contains(".txt")) {
                String[] check =  userInput.split(" ");
                if(userInput.trim().contains(" ") && check[0].length()>0 && check[1].length()>0){
                    try {
                        readWrite.clientWriteAndSendTxtFile(userInput);
                    } catch (IOException e) {
                        System.out.println("Чтение txt не удалось. Повторите попытку");
                    }
                } else {
                    System.out.println("Файл не был сохранен! Для сохранения введите имя и содержимое файла");
                }

            } else {
                Message message = new Message(userInput);
                System.out.println("в WriterThread отправили сообщение  ===  " + message.getText());
                //отправляем сообщение на сервер
                try {
                    readWrite.writeMessage(message);
                }  catch (IOException e) {
                System.out.println("Сервер не отвечает");
                System.out.println(e.getMessage());
                return;
            }
            }

        }
    }


}

























//package ru.itmo.coursePaper.coursePaper_3.executors;
//
//
//import ru.itmo.coursePaper.coursePaper_3.Task;
//import ru.itmo.coursePaper.coursePaper_3.common.Message;
//import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
//
//import java.io.*;
//import java.net.*;
//import java.util.Comparator;
//import java.util.Scanner;
//
//public class WriterThread implements Runnable {
//
//
//    ReadWrite readWrite;
//
//
//    public WriterThread(ReadWrite readWrite) throws IOException {
//        this.readWrite = readWrite;
//
//    }
//
//    @Override
//    public void run() {
//        Scanner scanner = new Scanner(System.in);
//            while (true) {
//                // 2.1. запрашивает текст сообщения (запрос) у пользователя
//                System.out.println("Доступные опции: " + "\n" +
//                        "1) Введите /sendfile для создания и отправки файла на сервер" + "\n" +
//                        "2) Введите /getfile для создания и отправки файла на сервер" + "\n" +
//                        "3) Введите любую команду для рассылки этой команды всем активным пользователям " + "\n" +
//                        "4) Введите /exit для выхода"
//                );
//
////                =====================================================================
//
//                if (input.contains(".txt")) {
//                    String[] data = input.split(" ", 2);
//                    String fileName = data[0];
//                    String fileContent = data[1];
//
//                    if (fileName.length() <= 10 && fileContent.getBytes().length <= 1048576) {
//                        FileData fileData = new FileData(fileName, fileContent);
//                        ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                        objectOutputStream.writeObject(fileData);
//                        System.out.println("File sent to server");
//                    } else {
//                        System.out.println("File name should be less than 10 characters and file content should be less than 1 MB");
//                    }
//                } else {
//                    ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                    objectOutputStream.writeObject(input);
//                    System.out.println("Message sent to server");
//                }
//
//                socket.close();
//            }
////                =====================================================================
//
//                String text = scanner.nextLine();
//                System.out.println("console text ===  " + text);
//                // Чтение сообщения из консоли
//
//                try (  GetTxtFileFromServer getTxtFile = new GetTxtFileFromServer(readWrite);
//                       SendTxtFileToServer sendTxtFile = new SendTxtFileToServer(readWrite);){
//
//                    if ("/sendfile".equals(text)) {
//                        System.out.println("сработал /sendfile");
//                        sendTxtFile.sendFileToServer();
//                        continue;
//                    }
//                    ;
//                    if ("q".equals(text)) {
//                        System.out.println("сработал q");
//                        sendTxtFile.sendFileToServer();
//                        continue;
//                    }
//                    if ("/getfile".equals(text)) {
//                        System.out.println("сработал /getfile");
//                        getTxtFile.getFileFromServer();
//                        continue;
//                    }
//                    Message message = new Message(text);
//                    System.out.println("в WriterThread отправили сообщение  ===  " + message.getText());
//                    //отправляем сообщение на сервер
//                    readWrite.writeMessage(message);
//                    // System.out.println("в WriterThread отправили сообщение на сервер. Thread name == " + Thread.currentThread().getName());
//                } catch (IOException e) {
//                    System.out.println("Сервер не отвечает");
//                    System.out.println(e.getMessage());
//                    return;
//                }
//
//
//            }
//
//
//    }
//
//
//
//}
//
