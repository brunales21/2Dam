package ej2;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
    }

    private void send() {
        Scanner scanner = new Scanner(System.in);
        PrintStream out = null;
        try {
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Introduzca un entero, se le devolvera el mismo elevado al cuadrado");
        out.println(scanner.nextLine());
    }

    private void rcv() {
        Scanner in = null;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Respuesta: "+in.nextLine());
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 23);
        client.connect();
        client.send();
        client.rcv();
    }
}
