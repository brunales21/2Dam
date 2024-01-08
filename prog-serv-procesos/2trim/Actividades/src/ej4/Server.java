package ej4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private int numClients;
    private ServerSocket serverSocket;

    public Server(int port, int numClients) {
        this.port = port;
        this.numClients = numClients;
    }

    private void start() {
        try {
            serverSocket = new ServerSocket(port);
            for (int i = 0; i < numClients; i++) {
                System.out.println("Esperando cliente "+i+"..");
                Socket socket = serverSocket.accept();
                System.out.println("Cliente "+i+" conectado.");
                System.out.println("Puerto local: "+socket.getLocalPort());
                System.out.println("Puerto remoto: "+socket.getPort());

            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

    public static void main(String[] args) {
        Server server = new Server(23, 3);
        server.start();
    }
}
