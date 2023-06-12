package ru.itmo.coursePaper.coursePaper_3.executors;

import ru.itmo.coursePaper.coursePaper_3.ServerApp;
import ru.itmo.coursePaper.coursePaper_3.Task;
import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadForConnection extends Thread {

    ReadWrite connection;
    CopyOnWriteArraySet<ReadWrite> connections;
    ServerApp serverApp;
    private Map<String, Task> tasksMap;

    public ThreadForConnection(ReadWrite connection, CopyOnWriteArraySet connections, ServerApp serverApp, Map<String, Task> tasksMap) {
        this.connection = connection;
        this.connections = connections;
        this.serverApp = serverApp;
        this.tasksMap = tasksMap;
    }


    private void write(CopyOnWriteArraySet<ReadWrite> connections, Message message) {
        try {
            System.out.println("ThreadForConnection.write str 30. send to All client  : " + message.getText());
            for (ReadWrite connection : connections) {
                System.out.println("write в цикле читаем connection.getSocket().getPort() == "+ connection.getSocket().getPort());
                connection.writeMessage(message);// отправка сообщения клиенту
            }

        } catch (IOException e) {
            System.out.println("Ошибка отправки сообщения");
        }
    }


    private Message readMessage(ReadWrite readWrite) {
        System.out.println(1 + " str 36");
        Message fromClient = null;
        try {
            fromClient = readWrite.readMessage(); // чтение сообщения от клиента
            System.out.println("private Message read; fromClient.getText() === " + fromClient.getText());
            if (fromClient == null) {
                connections.remove(connection);
                return null;
            }
            return fromClient;
        } catch (IOException e) {
            System.out.println("Ошибка во время чтения");
            connections.remove(connection);
            return null;
        }

    }


    private void sendResponse(CopyOnWriteArraySet<ReadWrite> connections, Message requestMessage) { // выполнение запрошенной задачи
        System.out.println(4 + " str 66");
        Message responseMessage;
        System.out.println("ThreadForConnection.sendResponse; thread name  == " + this.getName());
        if (requestMessage == null
//                || !tasksMap.containsKey(requestMessage.getText()) // раскомментируй если будешь брать текст из Task которые лежат в tasksMap
        ) {
            responseMessage = new Message("Задача не может быть выполнена");
            System.out.println(5 + " str 71");
        } else {
//            responseMessage = tasksMap.get(requestMessage.getText()).execute(serverApp); //раскомментируй если будешь брать текст из Task которые лежат в tasksMap
            responseMessage = requestMessage;

            System.out.println("answer to client from sendResponse === " + responseMessage.getText());
        }
        System.out.println(6 + " str 76");
        if (requestMessage != null)
            System.out.println("сообщение от клиента в sendResponse === " + requestMessage.getText());
        write(connections, responseMessage); // рассылаем запрос от одного клиента по всем активным соединениям
    }


    @Override
    public void run() {
        sendResponse(connections, readMessage(connection));
    }
}






















