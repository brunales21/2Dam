package ejercicio0405;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {
    private String hostname;
    private int port;
    private Socket socket;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
    }

    public void connect() {
        try {
            socket = new Socket(hostname, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void process() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());
             Scanner in = new Scanner(socket.getInputStream());
             Scanner inTeclado = new Scanner(System.in)) {

            do {
                System.out.println(in.nextLine());
                out.println(inTeclado.nextLine());
            } while (socket.isConnected());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void run() {
        process();
    }

    public static void main(String[] args) {
        Client c = new Client("localhost", 80);
        c.connect();
    }
}
