package ru.itmo.coursePaper.coursePaper_3.executors;

import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class SendTxtFileToServer {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 1234);
        System.out.println("Connected to server");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

//        if (input.contains(".txt")) {
//            String[] data = input.split(" ", 2);
//            String fileName = data[0];
//            String fileContent = data[1];
//
//            if (fileName.length() <= 10 && fileContent.getBytes().length <= 1048576) {
//                FileData fileData = new FileData(fileName, fileContent.getBytes());
//                ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//                objectOutputStream.writeObject(fileData);
//                System.out.println("File sent to server");
//            } else {
//                System.out.println("File name should be less than 10 characters and file content should be less than 1 MB");
//            }
//        } else {
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
//            objectOutputStream.writeObject(input);
//            System.out.println("Message sent to server");
//        }

        socket.close();
    }
}


//    В данном коде мы создаем клиентский сокет и подключаемся к серверу.
//    Затем мы считываем ввод пользователя из консоли. Если ввод содержит ".txt", то
//    мы разделяем строку на имя файла и его содержимое и создаем объект FileData.
//    Если имя файла короче 10 символов и содержимое файла меньше 1 МБ, то мы сериализуем объект и отправляем
//    его на сервер. Если ввод не содержит ".txt", то мы сериализуем строку и отправляем ее на сервер.















//package ru.itmo.coursePaper.coursePaper_3.executors;
//
//import ru.itmo.coursePaper.coursePaper_3.common.Message;
//import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
//
//import java.io.*;
//import java.net.*;
//import java.util.Scanner;
//
//public class SendTxtFileToServer implements AutoCloseable{
//
//    String filePath = "src/ru/itmo/coursePaper/coursePaper_3/FilesPackageClient/";
////    OutputStream outputStream;
//
//    ReadWrite readWrite;
//    Scanner scanner = new Scanner(System.in);
//    public SendTxtFileToServer(ReadWrite readWrite) throws IOException {
//        System.out.println("SendTxtFileToServer port === " +  readWrite.getSocket().getPort());
////        this.outputStream = outputStream;
//        this.readWrite = readWrite;
//    }
//
//
//
//    public void sendFileToServer() {
//
//        try {
////            readWrite = new ReadWrite(socket);
//            // Получаем имя файла от пользователя
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            System.out.print("Введите имя файла. Имя файла должно заканчиваться расширением .txt : ");
//            String fileName = null;
//            try {
//                fileName = reader.readLine();
//            } catch (IOException ex) {
//                System.out.println("Не удалось прочитать имя txt файла");
//                ex.printStackTrace();
//            }
//
//
//    // Создаем файл и записываем в него данные из консоли
//            System.out.print("Введите содержимое файла: ");
//            File file = new File(filePath, fileName);
//            try( FileWriter writer = new FileWriter(file)){
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.write(System.lineSeparator());
//            }
//
//             System.out.println("Файл успешно создан.");
//            } catch (IOException ex) {
//                System.err.println("Ошибка создания файла: " + ex.getMessage());
//                ex.printStackTrace();
//            } finally {
//                // Завершаем запрос
//                // Удаляем файл
//                file.delete();
//            }
//
//
//
//
//            try {
//
//
//                // отправляем имя файла на сервер
//
//                OutputStream outputStream = readWrite.getOutput();
//
//                byte[] fileNameBytes = fileName.getBytes();
//                outputStream.write(fileNameBytes, 0, fileNameBytes.length);
//
//                // отправляем файл на сервер
//
//                FileInputStream fileInputStream = new FileInputStream(file);
//                readWrite.writeAndSendTxtFile(fileInputStream);
//                System.out.println("Файл отправлен на сервер: " + file.getAbsolutePath());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
////            // Записываем данные файла в поток
////            FileInputStream fileInputStream = new FileInputStream(file);
////            Message message = new Message("/saveFile");
////            // отправляем команду сохранения файла на сервер
////            readWrite.writeMessage(message);
////            // отправляем файл на сервер
////            readWrite.writeTxtFile(fileInputStream);
////            fileInputStream.close();
//
//            // Получаем ответ от сервера
//            InputStream inputStream = readWrite.getInput();
//            BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream));
//            String responseLine;
//            while ((responseLine = responseReader.readLine()) != null) {
//                System.out.println("Ответ сервера: " + responseLine);
//            }
//            responseReader.close();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//        }
//
//    @Override
//    public void close()  {
//        readWrite.close();
//    }
//}
//
//
//
