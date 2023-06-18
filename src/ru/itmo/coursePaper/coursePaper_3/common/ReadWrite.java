package src.ru.itmo.coursePaper.coursePaper_3.common;



import src.ru.itmo.coursePaper.coursePaper_3.executors.FileData;

import java.io.*;
import java.net.Socket;
import java.time.LocalDateTime;
import java.util.concurrent.CopyOnWriteArraySet;

public class ReadWrite implements AutoCloseable {
    private Socket socket;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private CopyOnWriteArraySet<FileData> filesSet = new CopyOnWriteArraySet<>();

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
        Message msg = null;
        try {
//            System.out.println("ReadWrite.readMessage == " + ((Message) input.readObject()).getText());
            msg = (Message) input.readObject();
            return msg;
        } catch (ClassNotFoundException e) {
            System.out.println("Класс Message не найден");
        }
        return msg;
    }


    public void writeMessage(Message message) throws IOException {
        // отправляем текстовое сообщение(Message) на сервер
        message.setSent(LocalDateTime.now());
        //отправляем сообщение на сервер
        output.writeObject(message);
//        System.out.println("ReadWrite str 64.send message to server or to client == "+ message.getText());
        output.flush();
    }

    public void clientWriteAndSendTxtFile(String userInput) throws IOException {
        // клиент считывает с консоли имя и содержимое файла и отправляем его на сервер
        String[] data = userInput.split(" ", 2);
        String fileName = data[0];
        String fileContent = data[1];
        if (fileName == null || fileName == "" || fileName.length() < 2) {
            System.out.println("Имя файла не может быть пустым и его длина должна быть более 1 буквы");
            return;
        }
        if (fileName.length() > 1 && fileName.length() < 25 && fileContent.getBytes().length <= 1234) { // имя файла менее 10 букв и размер файла менее 1234 byte
            FileData fileData = new FileData(fileName, fileContent);

            output.writeObject(fileData);
            System.out.println("TXT File sent to server");
            System.out.println("fileName === " + fileName);
            System.out.println("fileContent === " + fileContent);

        } else {
            System.out.println("File name should be less than 10 characters and file content should be less than 1 MB");
            return;
        }
    }


//    ==================================== Server methods ===========================================

    private void write(Message message, CopyOnWriteArraySet<ReadWrite> connections) {
        // отправляем сообщения от сервера к клиенту по всем активным соединениям
        for (ReadWrite currentConnection : connections) {
            try {
                currentConnection.writeMessage(message);// отправка сообщения клиенту
            } catch (IOException e) {
                connections.remove(currentConnection);
                System.out.println("Ошибка отправки сообщения клиенту");
            }
        }
        ;


    }

    public void readMessageInServerFromClient(CopyOnWriteArraySet<ReadWrite> connections)  /*, ClassNotFoundException*/ {
        // на сервере читаем сообщение от клиента и определяем его тип. Строка или Файл.
        // Строку отправляем  всем активным соединениям. Файл сохраняем на сервер

        Object inputObj = null;
        try {
            inputObj = input.readObject();


            if (inputObj instanceof Message) {
                Message message = (Message) inputObj;
                System.out.println("Message received: " + message.getText());
                if (message.getText().contains("getfile")) {
                    Message msg = new Message(getFilesName());
                    write(msg, connections);
                } else if (message.getText().contains("file")) {

                    getSelectedFile(message.getText(), connections);
                } else {
                    write(message, connections);
                }
            } else if (inputObj instanceof FileData) {
                FileData fileData = (FileData) inputObj;
                filesSet.add(fileData);

                String fileName = fileData.getFileName();
                String fileContent = fileData.getFileContent();

                FileOutputStream fileOutputStream = new FileOutputStream(fileName);
                fileOutputStream.write(fileContent.getBytes());
                fileOutputStream.close();
                System.out.println("File saved: " + fileName);
                Message addFiles = new Message("Добавлен новый файл с именем: " + fileName);
                write(addFiles, connections);
                for (FileData file : filesSet) {
                    System.out.println("file. name from  filesSet === " + file.getFileName());  // читаем имена всех файлов
                    System.out.println("file. content from  filesSet  === " + file.getFileContent());  // читаем имена всех файлов
                }
                ;
            }
        } catch (ClassNotFoundException | IOException e) {
            System.out.println("Данные от пользователя не были прочитаны в ReadWrite readMessageInServerFromClient");
            e.printStackTrace();
        }

    }

    public String getFilesName() {
        StringBuffer stringBuffer = new StringBuffer();
        for (FileData file : filesSet) {
            stringBuffer.append(file.getFileName()).append("\n");
        }
        ;
        return stringBuffer.length() < 1 ? "На сервере нет сохранённых файлов" : stringBuffer.toString();
    }

    public void getSelectedFile(String name, CopyOnWriteArraySet<ReadWrite> connections) {
        int count = 0;
        String[] nameWithDash = name.split("-");
        String cleanName = nameWithDash[1];
        System.out.println("cleanName = " + cleanName);
        System.out.println("All name  = 0== " + nameWithDash[0] + " 1== " + nameWithDash[1]);
        StringBuffer stringBuffer = new StringBuffer();
        for (FileData file : filesSet) {
            if (file.getFileName().equals(cleanName)) {
                count++;
                System.out.println("count == " + count);
                Message message = new Message(" name: " + file.getFileName() + "\n" + "content: " + file.getFileContent());
                write(message, connections);
                break;
            }
        }
        ;
        if (count < 1) {
            count = 0;
            Message message = new Message("Файла с именем " + cleanName + " на сервере нет !  Проверьте имя файла и повторите поиск");
            write(message, connections);
        }


    }

    @Override
    public void close() {
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








