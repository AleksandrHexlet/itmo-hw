//package ru.itmo.coursePaper.coursePaper_3.executors;
//
//import ru.itmo.coursePaper.coursePaper_3.common.Message;
//import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
//
//import java.io.IOException;
//import java.net.Socket;
//import java.net.UnknownHostException;
//import java.util.Scanner;
//
//public class GetTxtFileFromServer implements AutoCloseable{
//
////    Socket socket;
//    String text = "getFileList";
//    Scanner scanner = new Scanner(System.in);
//    ReadWrite readWrite;
//
//    public GetTxtFileFromServer(ReadWrite readWrite ) {
//        this.readWrite = readWrite;
//    }
//
//    public void getFileFromServer(){
//
//
//
//        while (true) {
//
//            // 2.2. устанавливаем соединение с сервером
//            try {
//                // 2.3. создаём экземпляр сообщения
//                Message message = new Message(text);
//                // 2.4. отправляем сообщение на сервер
//                readWrite.writeMessage(message);
//                // 2.5. получаем ответ
//                Message fromServer = (Message)readWrite.readMessage();
//                // 2.6. выводит полученный ответ в консоль
//                System.out.println("Выберите файл который хотите получить: " + fromServer.getText());
//                String nameFile = scanner.nextLine();
//
//
//                // 2.7. создаём экземпляр сообщения
//                Message messageWithNameFile = new Message(nameFile);
//                try {
//                    // 2.8. отправляем сообщение на сервер
//                    readWrite.writeMessage(messageWithNameFile);
//
//                } catch (IOException e) {
//                    System.out.println("Сервер не отвечает");
//                    e.printStackTrace();
//                }
//                try {
//                    // 2.9. получаем ответ
//                    // читаем txt файл с сервера и сохраняем его в папке FilesPackageClient
//                    // и написали об этом в консоль для клиента
//                    Message filefromServer = readWrite.clientReadTxtFile(messageWithNameFile.getText());
//
//                    // 3.0. выводит полученный ответ в консоль
//                    System.out.println(filefromServer.getText());
//                } catch (IOException e) {
//                    System.out.println("Ошибка при получении данных от сервера");
//                    e.printStackTrace();
//                }
//            } catch (UnknownHostException e) {
//                System.out.println("Ошибка в IP сервера");
//            } catch (IOException e) {
//                System.out.println("Сервер не отвечает");
//            }
//        }
//    }
//
//
//
//    @Override
//    public void close()  {
//        try {
//         readWrite.close();
//        } catch (RuntimeException exception) {
//            System.out.println("Ошибка закрытия ресурсов. " +
//                    "Например, обрыв соединения произошел по время закрытия");
//        }
//    }
//}
