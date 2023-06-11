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
//    Socket socket;
//    ReadWrite readWrite;
//    Scanner scanner = new Scanner(System.in);
//    public SendTxtFileToServer(Socket socket) throws IOException {
//        System.out.println("SendTxtFileToServer port === " +  socket.getPort());
////        this.outputStream = outputStream;
//        this.socket = socket;
//    }
//
//    public void sendFileToServer() {
//
//        try {
//            readWrite = new ReadWrite(socket);
//            // Получаем имя файла от пользователя
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            System.out.print("Введите имя файла. Имя файла должно начинаться с saveFile и пробел: ");
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
//                OutputStream outputStream = socket.getOutputStream();
//
//                byte[] fileNameBytes = fileName.getBytes();
//                outputStream.write(fileNameBytes, 0, fileNameBytes.length);
//
//                // отправляем файл на сервер
//
//                FileInputStream fileInputStream = new FileInputStream(file);
//                readWrite.writeTxtFile(fileInputStream);
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
//            InputStream inputStream = socket.getInputStream();
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
//        try {
//            socket.close();
//        } catch (IOException e) {
//            System.out.println("Ошибка закрытия ресурсов. " +
//                    "Например, обрыв соединения произошел по время закрытия");
//        }
//    }
//}
//
//
//
