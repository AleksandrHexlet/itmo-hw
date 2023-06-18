package ru.itmo.coursePaper.coursePaper_3.executors;

import ru.itmo.coursePaper.coursePaper_3.ServerApp;
import ru.itmo.coursePaper.coursePaper_3.Task;
import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadForConnection extends Thread {

    ReadWrite connection;
    CopyOnWriteArraySet<ReadWrite> connections;
    ServerApp serverApp;
    Socket socket;
    private Map<String, Task> tasksMap;

    public ThreadForConnection(ReadWrite connection, CopyOnWriteArraySet connections, ServerApp serverApp, Map<String, Task> tasksMap,  Socket socket) {
        this.connection = connection;
        this.connections = connections;
        this.serverApp = serverApp;
        this.tasksMap = tasksMap;
        this.socket = socket;
    }


    private void write(Message message) { // отправляем сообщения от сервера к клиенту
            for (ReadWrite currentConnection : connections) {
                try {
                 currentConnection.writeMessage(message);// отправка сообщения клиенту
                } catch (IOException e) {
                    connections.remove(currentConnection);
                    System.out.println("Ошибка отправки сообщения клиенту");
                }
            };


    }






//    private Message readMessage() { // чтение сообщений пришедших от клиента на сервер
//        System.out.println(1 + " str 36");
//        Message fromClient = null;
//        try {
//            fromClient = connection.readMessage(); // чтение сообщения от клиента
//            System.out.println("private Message read; fromClient.getText() === " + fromClient.getText());
//
//            return fromClient;
//        } catch (IOException e) {
//            System.out.println("Ошибка во время чтения сообщения от клиента");
//            connections.remove(connection);
//            return null;
//        }
//
//    }


//     public FileData getFileData() {
//         FileData fileData= null;
//         try {
//             System.out.println("inputReadObject : 1)  получаем файл от клиента");
//             ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
//             fileData = (FileData)objectInputStream.readObject();
//
//             System.out.println("3) getInputReadObject fileData.getFileName()" + fileData.getFileName());
//         } catch (IOException e) {
//             System.out.println("Произошла ошибка при чтении txt файла");
//             System.out.println(e.getMessage());
//         } catch (ClassNotFoundException e) {
//             System.out.println("Не удалось найти класс для приведения типов при чтении txt файла");
//             System.out.println(e.getMessage());
//         }
//         System.out.println("4) getInputReadObject fileData.getFileName()" + fileData.getFileName());
//         return fileData;
//     };

    public void serverReadTxtFile(FileData fileData)  {
        //читаем txt файл с клиента и сохраняем его в папке FilesPackageServer

        System.out.println("serverReadTxtFile fileData.getFileName() == " + fileData.getFileName());
        System.out.println("fileData.getFileContent().toString() == " + fileData.getFileContent().toString());
        if (fileData.getFileName() == null || fileData.getFileName() == "" || fileData.getFileName().length()<2) {
            System.out.println("Server response : Имя файла не может быть пустым и его длина должна быть более 1 буквы");
            return;
        }
        if (fileData.getFileContent().length <= 1048576 || fileData.getFileName().length()>9) {
            System.out.println("Server response : File name should be less than 10 characters and file content should be less than 1 MB");
            return;
        }

        String fileName = fileData.getFileName();
        byte[] fileContent = fileData.getFileContent();
        FileOutputStream fileOutputStreamServer = null;
        try {
            fileOutputStreamServer = new FileOutputStream(fileName);
            fileOutputStreamServer.write(fileContent);

            Message newFileName = new Message(fileName);
            System.out.println("имя сохранённого на сервере файла : " + newFileName.getText());
            write(newFileName);
        } catch (FileNotFoundException e) {
            System.out.println("Не удалось новый создать txt файл");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Не удалось записать txt файл");
            System.out.println(e.getMessage());
        }

        try {
            fileOutputStreamServer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File saved: " + fileName);
    }



    @Override
    public void run() {
        Object dataFromClient = null;
        while (true) {
            System.out.println(0+"начало ");

            try {
                System.out.println(0.5);
                dataFromClient = connection.readMessage();
                System.out.println(1 + "продолжение");
                if (dataFromClient instanceof Message) {

                    Message message = (Message) dataFromClient;

                    if (message == null) {
                        connections.remove(connection);
                        return;
                    }
                    write(message);
//            } else if (dataFromClient instanceof FileData) {
                } else {
                    System.out.println(3 + " еще раз продолжение");
                    try {
                        FileData fileData = (FileData) dataFromClient;
                        System.out.println(4 + " финиш");
                        System.out.println(" Run dataFromClient.getFileName() === " + fileData.getFileName());
                        serverReadTxtFile(fileData);
                    } catch (Exception e) {
                        System.out.println("Ye b gjgf");
                        e.printStackTrace();
                    }
                }

                dataFromClient = " ";
            } catch (IOException e) {
                System.out.println("Не удалось прочитать данные от клиента из потока в методе Run ThreadForConnection");
//                connections.remove(connection);
                return;
            }
        }

    }






}






















