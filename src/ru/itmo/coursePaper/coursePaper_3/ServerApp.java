package src.ru.itmo.coursePaper.coursePaper_3;

import src.ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
import src.ru.itmo.coursePaper.coursePaper_3.executors.ThreadForConnection;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;



public class ServerApp {
    private int port;
    private CopyOnWriteArraySet<ReadWrite> connections;


    // При создании сервера в конструктор передается номер порта (int),
    // по которому клиенты смогут подключаться к серверу.
    public ServerApp(int port) {
        this.port = port;
        connections = new CopyOnWriteArraySet<>();
    }

    public void run() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен...");

            while (true) {

                Socket socket; // устанавливает соединение с клиентом
                ThreadForConnection thread = null;

                try {
                    socket = serverSocket.accept();
                    ReadWrite connection = new ReadWrite(socket);
                    connections.add(connection);
                    thread = new ThreadForConnection(connection, connections, this, socket);
                    thread.start();

                } catch (Exception e) {
                    thread.interrupt(); // Если клиент отваливается, поток завершит работу
                    System.out.println("Ошибка во время создания объекта");
                    System.out.println(e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка создания serverSocket, например, указанный порт занят");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ServerApp serverApp = new ServerApp(2345);
        serverApp.run();

    }
}
