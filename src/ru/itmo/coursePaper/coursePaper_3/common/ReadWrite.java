//
//package ru.itmo.coursePaper.coursePaper_3.common;
//
//import java.io.*;
//import java.net.Socket;
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//
//public class ReadWrite implements AutoCloseable{
//    private Socket socket;
//    private ObjectInputStream input;
//    private ObjectOutputStream output;
//
//    public ReadWrite(Socket socket) throws IOException {
//        output = new ObjectOutputStream(socket.getOutputStream());
////        input = new ObjectInputStream(socket.getInputStream());
//        this.socket = socket;
//    }
//
//    public Socket getSocket() {
//        return socket;
//    }
//
//    public Message readMessage() throws IOException /*, ClassNotFoundException*/ {
//        Message msg = new Message("test!!!!!!!!!!!!!!!!! readMessage");
//        try {
////            System.out.println("ReadWrite.readMessage == " + ((Message) input.readObject()).getText());
//            msg = (Message) input.readObject();
//            return  msg;
//        } catch (ClassNotFoundException e) {
//            System.out.println("Класс Message не найден");
//        }
//        return msg;
//    }
////    public Message readTxtFile(Socket socket, String fileName) throws IOException  {
////        // читаем txt файл с сервера и сохраняем его в папке FilesPackageClient
////     String pathToFile= "src/ru/itmo/coursePaper/coursePaper_3/FilesPackageClient" + fileName;
////        try {
//////            сохраняем файл на клиенте
////            byte[] buffer = new byte[1024];
////
////            InputStream inputStream = socket.getInputStream();
////            int bytesRead;
////            File file = new File("src/ru/itmo/coursePaper/coursePaper_3/FilesPackageClient" + fileName);
////            FileOutputStream fileOutputStream = new FileOutputStream(file);
////            while ((bytesRead = inputStream.read(buffer)) != -1) {
////                fileOutputStream.write(buffer, 0, bytesRead);
////            }
////            fileOutputStream.close();
////            System.out.println("Файл сохранен на клиенте: " + file.getAbsolutePath());
////
////
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
////        return new Message("Файл "+ fileName + " сохранён по адресу " + pathToFile);
////    }
//
//
//
//    public void writeMessage(Message message) throws IOException {
//        message.setSent(LocalDateTime.now());
//        //отправляем сообщение на сервер
//        output.writeObject(message);
//
//        output.flush();
//    }
//
////    public void writeTxtFile( FileInputStream fileInputStream) throws IOException {
////        byte[] buffer = new byte[1024];
////        int bytesRead;
////        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
////            output.write(buffer, 0, bytesRead);
////        }
////        output.flush();
////
////    }
//
//    @Override
//    public void close()  {
//        try {
//            input.close();
//            output.close();
//            socket.close();
//        } catch (IOException e) {
//            System.out.println("Ошибка закрытия ресурсов. " +
//                    "Например, обрыв соединения произошел по время закрытия");
//        }
//    }
//}


package ru.itmo.coursePaper.coursePaper_3.common;

import ru.itmo.coursePaper.coursePaper_3.executors.FileData;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ReadWrite implements AutoCloseable{
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;

    public ReadWrite(Socket socket) throws IOException {
        output = new ObjectOutputStream(socket.getOutputStream());
        input = new ObjectInputStream(socket.getInputStream());
        this.socket = socket;
    }

    public Socket getSocket() {
        return socket;
    }
    public ObjectOutputStream getOutput() {
        return output;
    }
    public ObjectInputStream getInput() {
        return input;
    }



//    ==================================== Client methods ===========================================
    public Message readMessageInClientFromServer() throws IOException /*, ClassNotFoundException*/ {
        // клиент читает сообщение (Message) от сервера
        Message msg = new Message("test!!!!!!!!!!!!!!!!! readMessage");
        try {
//            System.out.println("ReadWrite.readMessage == " + ((Message) input.readObject()).getText());
            msg = (Message) input.readObject();
            return  msg;
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Message не найден");
        }
        return msg;
    }


    public Message clientReadTxtFile(String fileName) throws IOException  {
        // читаем txt файл с сервера и сохраняем его в папке FilesPackageClient
     String pathToFile= "src/ru/itmo/coursePaper/coursePaper_3/FilesPackageClient" + fileName;
        try {
//            сохраняем файл на клиенте
            byte[] buffer = new byte[1024];

            InputStream inputStream = input;
            int bytesRead;
            File file = new File("src/ru/itmo/coursePaper/coursePaper_3/FilesPackageClient" + fileName);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
            fileOutputStream.close();
            System.out.println("Файл сохранен на клиенте: " + file.getAbsolutePath());


        } catch (IOException e) {
            e.printStackTrace();
        }
        return new Message("Файл "+ fileName + " сохранён по адресу " + pathToFile);
    }

    public void writeMessage(Message message) throws IOException {
        // отправляем текстовое сообщение(Message) на сервер
        message.setSent(LocalDateTime.now());
        //отправляем сообщение на сервер
        output.writeObject(message);
//        System.out.println("ReadWrite str 64.send message to server or to client == "+ message.getText());
        output.flush();
    }

    public void clientWriteAndSendTxtFile( String userInput) throws IOException {
        // клиент считывает с консоли имя и содержимое файла и отправляем его на сервер
        String[] data = userInput.split(" ", 2);
        String fileName = data[0];
        String fileContent = data[1];
        if (fileName == null || fileName == "" || fileName.length()<2) {
            System.out.println("Имя файла не может быть пустым и его длина должна быть более 1 буквы");
            return;
        }
        if (fileName.length() <= 10 && fileContent.getBytes().length <= 1025) { // имя файла менее 10 букв и размер файла менее 1025 byte
            FileData fileData = new FileData(fileName, fileContent.getBytes());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(fileData);
            System.out.println("TXT File sent to server");
            System.out.println("fileName === " + fileName);
            System.out.println("fileContent === " + fileContent);

        } else {
            System.out.println("File name should be less than 10 characters and file content should be less than 1 MB");
            return;
        }
    }


//    ==================================== Server methods ===========================================

    private void write(Message message,CopyOnWriteArraySet<ReadWrite> connections ) {
        // отправляем сообщения от сервера к клиенту по всем активным соединениям
        for (ReadWrite currentConnection : connections) {
            try {
                currentConnection.writeMessage(message);// отправка сообщения клиенту
            } catch (IOException e) {
                connections.remove(currentConnection);
                System.out.println("Ошибка отправки сообщения клиенту");
            }
        };


    }
    public void readMessageInServerFromClient(CopyOnWriteArraySet<ReadWrite> connections) throws IOException /*, ClassNotFoundException*/ {
// на сервере читаем сообщение от клиента и определяем его тип. Строка или Файл.
// Строку отправляем  всем активным соединениям. Файл сохраняем на сервер

        Object inputObj = null;
        try {
            inputObj = input.readObject();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        if (inputObj instanceof Message) {
            Message message = (Message) inputObj;
            System.out.println("Message received: " + message.getText());
            write(message,connections);
        } else
//            if (inputObj instanceof FileData)
        {
            FileData fileData = (FileData) inputObj;
            String fileName = fileData.getFileName();
            System.out.println("ReadWrite readMessageInServerFromClient getFileName() === " + fileData.getFileName());
            byte[] fileContent = fileData.getFileContent();
            System.out.println("ReadWrite readMessageInServerFromClient fileContent() === " + fileContent.toString());
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            fileOutputStream.write(fileContent);
            fileOutputStream.close();
            System.out.println("File saved: " + fileName);
        }

    }



    @Override
    public void close()  {
        try {
            input.close();
            output.close();
            socket.close();
        } catch (IOException e) {
            System.out.println("Ошибка закрытия ресурсов. " +
                    "Например, обрыв соединения произошел по время закрытия");
        }
    }
}








