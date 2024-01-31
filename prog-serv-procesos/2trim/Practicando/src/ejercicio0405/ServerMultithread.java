package ejercicio0405;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class ServerMultithread {
    private String hostname;
    private int port;
    private ServerSocket serverSocket;
    private Map<Socket, Client> socketClientMap;

    public ServerMultithread(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            do {
                System.out.println("Esperando cliente..");
                Socket socket = serverSocket.accept();
                System.out.println("Cliente conectado.");
                socketClientMap.put(socket, new Client(hostname, port));

                ClientHandler clientHandler = new ClientHandler(socket);
                clientHandler.start();

            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        ServerMultithread server = new ServerMultithread("localhost", 80);
        server.start();
    }
}
