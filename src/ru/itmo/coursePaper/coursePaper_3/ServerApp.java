package ru.itmo.coursePaper.coursePaper_3;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
import ru.itmo.coursePaper.coursePaper_3.executors.ThreadForConnection;

public class ServerApp {
    private int port;
    private Map<String, Task> tasksMap;
    private CopyOnWriteArraySet<ReadWrite> connections;



    // При создании сервера в конструктор передается номер порта (int),
    // по которому клиенты смогут подключаться к серверу.
    public ServerApp(int port) {
        this.port = port;
        tasksMap = new HashMap<>();
        connections = new CopyOnWriteArraySet<>();
    }

    public void run(){
        try (ServerSocket serverSocket = new ServerSocket(port)){
            System.out.println("Сервер запущен...");

            while (true) {

                Socket socket; // устанавливает соединение с клиентом
                System.out.println(1);

                try {
                    socket = serverSocket.accept();
                    ReadWrite connection = new ReadWrite(socket);
                    connections.add(connection);
                    ThreadForConnection thread = new ThreadForConnection(connection, connections, this,getTasksMap());
                    thread.start();

                    System.out.println(2 + " str 34");
//                    sendResponse(connection, readMessage(connection));
                    System.out.println(3+ " str 36");

                } catch (Exception e){
                    System.out.println("Ошибка во время создания объекта");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания serverSocket, например, указанный порт занят");
            e.printStackTrace();
        }
    }
//
//    private void sendResponse(ReadWrite readWrite, Message requestMessage) { // выполнение запрошенной задачи
//        System.out.println(4+ " str 51" );
//        Message responseMessage;
//
//        if (requestMessage == null || !tasksMap.containsKey(requestMessage.getText())) {
//            responseMessage = new Message("Задача не может быть выполнена");
//            System.out.println(5+ " str 56");
//        } else {
//            responseMessage = tasksMap.get(requestMessage.getText()).execute(this);
//            System.out.println("answer to client from sendResponse === " + responseMessage.getText());
//        }
//        System.out.println(6 + " str 61" );
//        if(requestMessage != null)System.out.println("сообщение от клиента в sendResponse === " + requestMessage.getText());
//        write(readWrite, responseMessage);
//    }
//
//    private void write(ReadWrite readWrite, Message message) {
//        try {
//            System.out.println("ServerApp.write str 68. send message to All client from method write : " + message.getText());
//            readWrite.writeMessage(message); // отправка сообщения клиенту
//        } catch (IOException e) {
//            System.out.println("Ошибка отправки сообщения");
//        }
//    }
//
//
//    private Message readMessage(ReadWrite readWrite){
//        System.out.println(7 + " str 77");
//        Message fromClient = null;
//        try {
//            fromClient = readWrite.readMessage(); // чтение сообщения от клиента
//            System.out.println("private Message read; fromClient.getText() === " +  fromClient.getText() );
//            return fromClient;
//        } catch (IOException e) {
//            System.out.println("Ошибка во время чтения");
//        }
//        System.out.println(8+ " str 86");
//        return fromClient;
//    }

    public void addTask(Task task) {
        tasksMap.put(task.getName(), task);
    }

    public Map<String, Task> getTasksMap(){
        return Collections.unmodifiableMap(tasksMap);
    }


    public static void main(String[] args) {
        Task help = new Task("/help", "список доступных запросов и их описание", serverApp -> {
            StringBuilder builder = new StringBuilder();
            for (Task task: serverApp.getTasksMap().values()) {
                builder.append(task.getName())
                        .append(" - ")
                        .append(task.getDescription())
                        .append("\n");
            }
            return new Message(builder.toString());
        });

        Task requests = new Task("/requests", "количество успешно обработанных запросов", serverApp -> {
            long numberOfRequests = serverApp.getTasksMap().values().stream()
                    .mapToLong(Task::getExecuted).sum();
            return new Message(String.valueOf(numberOfRequests));
        });

        Task popular = new Task("/popular", "название самого популярного запроса", serverApp -> {
            String taskName = serverApp.getTasksMap().values().stream()
                    .filter(task -> task.getExecuted() > 0)
                    .max(Comparator.comparing(Task::getExecuted))
                    .flatMap(task -> task.getName().describeConstable())
                    .orElse("нет выполненных запросов");
            System.out.println("serverApp./popular.taskName ===" + taskName );
            return new Message(taskName);
        });

        ServerApp serverApp = new ServerApp(1234);

        serverApp.addTask(help);
        serverApp.addTask(requests);
        serverApp.addTask(popular);

        serverApp.run();
        /*
        ServerSocket serverSocket = null; // позволит установить соединение
        // с клиентскими программами
        OutputStream output = null; // позволит отправлять данные
        InputStream input = null; // позволит получать данные


        try {
            serverSocket = new ServerSocket(2222); // привязка серверной программы к указанному порту.
            // ServerSocket слушает указанный порт...
            System.out.println("Сервер запущен");

            while (true) {
                Socket socket = serverSocket.accept(); // ...и устанавливает соединение при появлении клиента
                System.out.println("Новое подключение");

                System.out.println(socket.getLocalSocketAddress());
                System.out.println(socket.getRemoteSocketAddress());

                output = socket.getOutputStream(); // для отправки данных по socket соединению
                input = socket.getInputStream(); // для получения данных по socket соединению

                // ObjectInputStream objectInput = new ObjectInputStream(input); // десериализация
                // ObjectOutputStream objectOutput = new ObjectOutputStream(output); // сериализация

                // ожидание, когда в inputStream появятся данные
                System.out.println(input.read()); // чтение данных из inputStream
                output.write(2); // отправка данных в outputStream
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                if (serverSocket != null) serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        */
    }
}
