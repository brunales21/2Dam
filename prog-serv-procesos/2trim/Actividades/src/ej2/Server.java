package ej2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private int number;

    public Server(int port) {
        this.port = port;
    }

    private void start() {
        Socket socket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando cliente..");
            socket = serverSocket.accept();
            System.out.println("Cliente conectado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        process(socket);
    }

    private void process(Socket socket) {
        Scanner in = null;
        PrintStream out = null;
        try {
            in = new Scanner(socket.getInputStream());
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            number = Integer.parseInt(in.nextLine());
        } catch (NumberFormatException e) {
            out.println("Solo acepto enteros.");
        }
        out.println(number*number);
    }

    public static void main(String[] args) {
        Server server = new Server(23);
        server.start();

    }
}
