package ej1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private String message;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        Socket socket;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando cliente.");
            socket = serverSocket.accept();
            System.out.println("Cliente conectado.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        process(socket);
    }

    public void process(Socket socket) {
        sendMessage(socket);
        receiveMessage(socket);
    }
    public void sendMessage(Socket socket) {
        PrintStream out = null;
        try {
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println(message);
    }

    public void receiveMessage(Socket socket) {
        Scanner in = null;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        message = in.nextLine();
    }

    public void showMessage() {
        System.out.println(message);
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static void main(String[] args) {
        Server server = new Server(23);
        server.setMessage("HOLA, SOY BRUNO, FUTURO MULTIMILLONARIO");
        server.start();
        server.showMessage();
    }
}