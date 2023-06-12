package ru.itmo.coursePaper.coursePaper_3.common;

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

    public Message readMessage() throws IOException /*, ClassNotFoundException*/ {
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
    public Message readTxtFile(Socket socket, String fileName) throws IOException  {
        // читаем txt файл с сервера и сохраняем его в папке FilesPackageClient
     String pathToFile= "src/ru/itmo/coursePaper/coursePaper_3/FilesPackageClient" + fileName;
        try {
//            сохраняем файл на клиенте
            byte[] buffer = new byte[1024];

            InputStream inputStream = socket.getInputStream();
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

    public void writeTxtFile( FileInputStream fileInputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int bytesRead;
        while ((bytesRead = fileInputStream.read(buffer)) != -1) {
            output.write(buffer, 0, bytesRead);
        }
        output.flush();

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
