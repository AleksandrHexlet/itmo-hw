package ru.itmo.coursePaper.coursePaper_3.executors;

import ru.itmo.coursePaper.coursePaper_3.ServerApp;
import ru.itmo.coursePaper.coursePaper_3.Task;
import ru.itmo.coursePaper.coursePaper_3.common.Message;
import ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;

public class ThreadForConnection extends Thread {

    ReadWrite connection;
    CopyOnWriteArraySet<ReadWrite> connections;
    ServerApp serverApp;
    Socket socket;


    public ThreadForConnection(ReadWrite connection, CopyOnWriteArraySet connections, ServerApp serverApp,  Socket socket) {
        this.connection = connection;
        this.connections = connections;
        this.serverApp = serverApp;

        this.socket = socket;
    }


    private void write(Message message) { // отправляем сообщения от сервера к клиенту
            for (ReadWrite currentConnection : connections) {
                try {
                 currentConnection.writeMessage(message);// отправка сообщения клиенту
                } catch (IOException e) {
                    connections.remove(currentConnection);
                    System.out.println("Ошибка отправки сообщения клиенту");
                }
            };


    }

    @Override
    public void run() {
        Object dataFromClient = null;
        while (true) {

            connection.readMessageInServerFromClient(connections);
        }

    }
}






















