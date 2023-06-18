package ru.itmo.coursePaper.coursePaper_3.common;

import ru.itmo.coursePaper.coursePaper_3.executors.FileData;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.ArrayList;

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
    public Object readMessage() throws IOException /*, ClassNotFoundException*/ {
        Object inputObj = null;
        try {
            inputObj = input.readObject();
            // читаем данные (сообщение или txt) файл из потока и дальше проверяем, что именно пришло
            FileData fileData = (FileData) inputObj;
            System.out.println("readWrite readMessage fileData===" + fileData.getFileName());
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Message не найден");
        }
        return inputObj;
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
        message.setSent(LocalDateTime.now());
        //отправляем сообщение на сервер
       output.writeObject(message);
//        System.out.println("ReadWrite str 64.send message to server or to client == "+ message.getText());
        output.flush();
    }

    public void clientWriteAndSendTxtFile( String userInput) throws IOException {
        String[] data = userInput.split(" ", 2);
        String fileName = data[0];
        String fileContent = data[1];
        if (fileName == null || fileName == "" || fileName.length()<2) {
            System.out.println("Имя файла не может быть пустым и его длина должна быть более 1 буквы");
            return;
        }
        if (fileName.length() <= 10 && fileContent.getBytes().length <= 1048576) { // имя файла менее 10 букв и размер файла менее 1 мг
            FileData fileData = new FileData(fileName, fileContent.getBytes());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(fileData);
            System.out.println("TXT File sent to server");
        } else {
            System.out.println("File name should be less than 10 characters and file content should be less than 1 MB");
        return;
        }
    }





//        public void serverWriteAndSendTxtFile()  {
//при получении запроса от клиента с именем файла мы отправляем нужный файл клиенту

//    }



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








