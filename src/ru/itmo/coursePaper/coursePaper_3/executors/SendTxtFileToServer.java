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
//            // �������� ��� ����� �� ������������
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//            System.out.print("������� ��� �����. ��� ����� ������ ���������� � saveFile � ������: ");
//            String fileName = null;
//            try {
//                fileName = reader.readLine();
//            } catch (IOException ex) {
//                System.out.println("�� ������� ��������� ��� txt �����");
//                ex.printStackTrace();
//            }
//
//
//    // ������� ���� � ���������� � ���� ������ �� �������
//            System.out.print("������� ���������� �����: ");
//            File file = new File(filePath, fileName);
//            try( FileWriter writer = new FileWriter(file)){
//
//            String line;
//            while ((line = reader.readLine()) != null) {
//                writer.write(line);
//                writer.write(System.lineSeparator());
//            }
//
//             System.out.println("���� ������� ������.");
//            } catch (IOException ex) {
//                System.err.println("������ �������� �����: " + ex.getMessage());
//                ex.printStackTrace();
//            } finally {
//                // ��������� ������
//                // ������� ����
//                file.delete();
//            }
//
//
//
//
//            try {
//
//
//                // ���������� ��� ����� �� ������
//                OutputStream outputStream = socket.getOutputStream();
//
//                byte[] fileNameBytes = fileName.getBytes();
//                outputStream.write(fileNameBytes, 0, fileNameBytes.length);
//
//                // ���������� ���� �� ������
//
//                FileInputStream fileInputStream = new FileInputStream(file);
//                readWrite.writeTxtFile(fileInputStream);
//                System.out.println("���� ��������� �� ������: " + file.getAbsolutePath());
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//
////            // ���������� ������ ����� � �����
////            FileInputStream fileInputStream = new FileInputStream(file);
////            Message message = new Message("/saveFile");
////            // ���������� ������� ���������� ����� �� ������
////            readWrite.writeMessage(message);
////            // ���������� ���� �� ������
////            readWrite.writeTxtFile(fileInputStream);
////            fileInputStream.close();
//
//            // �������� ����� �� �������
//            InputStream inputStream = socket.getInputStream();
//            BufferedReader responseReader = new BufferedReader(new InputStreamReader(inputStream));
//            String responseLine;
//            while ((responseLine = responseReader.readLine()) != null) {
//                System.out.println("����� �������: " + responseLine);
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
//            System.out.println("������ �������� ��������. " +
//                    "��������, ����� ���������� ��������� �� ����� ��������");
//        }
//    }
//}
//
//
//
