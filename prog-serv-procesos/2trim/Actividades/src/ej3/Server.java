package ej3;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private int numClients;

    public Server(int port, int numClients) {
        this.port = port;
        this.numClients = numClients;
    }

    private void start() {
        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (int i = 0; i < numClients; i++) {
            Socket socket = null;
            try {
                System.out.println("Esperando a cliente "+i+"..");
                socket = serverSocket.accept();
                System.out.println("cliente "+i+" conectado.");

                PrintStream out = new PrintStream(socket.getOutputStream());
                out.println("Eres el cliente"+i);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Server server = new Server(23, 3);
        server.start();
    }
}
