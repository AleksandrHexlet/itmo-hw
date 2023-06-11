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
//    Socket socket;
//    String text = "getFileList";
//    Scanner scanner = new Scanner(System.in);
//    public GetTxtFileFromServer(Socket socket ) {
//        this.socket = socket;
//    }
//
//    public void getFileFromServer(){
//
//
//
//        while (true) {
//
//            // 2.2. ������������� ���������� � ��������
//            try (ReadWrite readWrite = new ReadWrite(socket)){
//                // 2.3. ������ ��������� ���������
//                Message message = new Message(text);
//                // 2.4. ���������� ��������� �� ������
//                readWrite.writeMessage(message);
//                // 2.5. �������� �����
//                Message fromServer = readWrite.readMessage();
//                // 2.6. ������� ���������� ����� � �������
//                System.out.println("�������� ���� ������� ������ ��������: " + fromServer.getText());
//                String nameFile = scanner.nextLine();
//
//
//                // 2.7. ������ ��������� ���������
//                Message messageWithNameFile = new Message(nameFile);
//                try {
//                    // 2.8. ���������� ��������� �� ������
//                    readWrite.writeMessage(messageWithNameFile);
//
//                } catch (IOException e) {
//                    System.out.println("������ �� ��������");
//                    e.printStackTrace();
//                }
//                try {
//                    // 2.9. �������� �����
//                    // ������ txt ���� � ������� � ��������� ��� � ����� FilesPackageClient
//                    // � �������� �� ���� � ������� ��� �������
//                    Message filefromServer = readWrite.readTxtFile(socket,messageWithNameFile.getText());
//
//                    // 3.0. ������� ���������� ����� � �������
//                    System.out.println(filefromServer.getText());
//                } catch (IOException e) {
//                    System.out.println("������ ��� ��������� ������ �� �������");
//                    e.printStackTrace();
//                }
//            } catch (UnknownHostException e) {
//                System.out.println("������ � IP �������");
//            } catch (IOException e) {
//                System.out.println("������ �� ��������");
//            }
//        }
//    }
//
//
//
//    @Override
//    public void close()  {
//        try {
////            input.close();
////            output.close();
////            socket.close();
////        } catch (IOException e) {
//        } catch (RuntimeException exception) {
//            System.out.println("������ �������� ��������. " +
//                    "��������, ����� ���������� ��������� �� ����� ��������");
//        }
//    }
//}
