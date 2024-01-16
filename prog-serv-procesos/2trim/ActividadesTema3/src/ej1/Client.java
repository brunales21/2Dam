package ej1;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String hostname;
    private int port;
    private Socket socket;
    private String message;

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
        PrintStream out = null;
        try {
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        out.println(message);
    }

    private void receive() {
        Scanner in = null;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        message = in.nextLine();
    }

    private void messageTransformer(StringTransformer stringTransformer) {
        message = stringTransformer.transform(message);
    }

    public String getMessage() {
        return message;
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 23);
        client.connect();
        client.receive();
        client.messageTransformer(m -> m.toLowerCase());
        client.send();
    }
}