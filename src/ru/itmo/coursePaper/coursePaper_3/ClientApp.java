package src.ru.itmo.coursePaper.coursePaper_3;




import src.ru.itmo.coursePaper.coursePaper_3.common.ReadWrite;
import src.ru.itmo.coursePaper.coursePaper_3.executors.ReaderThread;
import src.ru.itmo.coursePaper.coursePaper_3.executors.WriterThread;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;


// 2.7. закрывает соединение с сервером


public class ClientApp {
    private InetSocketAddress remote;
    Socket socket;
    ReadWrite readWrite;


    // При создании клиента в конструктор передается экземпляр InetSocketAddress,
    // который хранит IP сервера и порт.
    public ClientApp(InetSocketAddress remote) {
        this.remote = remote;

    }

    public void start() {


        System.out.println(1);
        try {
            System.out.println(2);
            socket = new Socket(remote.getHostString(), remote.getPort());
            System.out.println("client " + 3 + " ; socket is ready");
            readWrite = new ReadWrite(socket);

            System.out.println("client " + 4 + " ; port == " + socket.getPort());

            WriterThread sender = new WriterThread(readWrite); //Создание объекта WriterThread. Поток отправки на сервер
            Thread threadWriter = new Thread(sender);
            threadWriter.start();
            System.out.println("client " + 5);

            ReaderThread receiver = new ReaderThread(readWrite);
            // Создание объекта ReaderThread. Потока получения сообщений с сервера
            Thread threadReader = new Thread(receiver);
            threadReader.start();


        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 2345;
        InetSocketAddress remote = new InetSocketAddress(ip, port);

        ClientApp clientApp = new ClientApp(remote);
        clientApp.start();
        System.out.println("client " + 7);
    }
}
