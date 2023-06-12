package ru.itmo.coursePaper.coursePaper_3;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        String ip = "127.0.0.1";
        int port = 2345;
        InetSocketAddress remote = new InetSocketAddress(ip, port);

        ClientApp clientApp = new ClientApp(remote);
        clientApp.start();

        /*
        InetSocketAddress local = new InetSocketAddress(ip, 1111);

        Socket socket = new Socket();
        // Socket socket = new Socket(ip, port); // соединение с удаленным сервером
        // Socket socket = new Socket(remote.getHostString(), remote.getPort());
        OutputStream output = null;
        InputStream input = null;
        try {
            // socket.bind(local);
            System.out.println(socket.isBound());

            socket.connect(remote, 10000); // соединение с удаленным сервером
            System.out.println(socket.isConnected());

            System.out.println(socket.getReceiveBufferSize());
            System.out.println(socket.getSendBufferSize());
            System.out.println(socket.getLocalSocketAddress());
            System.out.println(socket.getRemoteSocketAddress());

            output = socket.getOutputStream();
            input = socket.getInputStream();

            output.write(11);
            System.out.println(input.read());
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if (input != null) input.close();
                if (output != null) output.close();
                socket.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
        */

    }
}
