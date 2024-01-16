package ej4;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private Socket socket;
    private String hostname;
    private int port;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    private void connect() {
        try {
            socket = new Socket(hostname, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("IP maquina remota: "+socket.getInetAddress());
        System.out.println("Puerto local: "+socket.getLocalPort());
        System.out.println("Puerto remoto: "+socket.getPort());
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 23);
        client.connect();
    }
}