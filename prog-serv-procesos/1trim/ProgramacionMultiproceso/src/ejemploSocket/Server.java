package ejemploSocket;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private ServerSocket serverSocket;
    private int port;

    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        server.start();
    }

    public Server(int port) throws IOException {
        this.port = port;
    }

    public void start() throws IOException {
        this.serverSocket = new ServerSocket(8080);
        System.out.println("Esperando cliente..");
        Socket socket = serverSocket.accept();
        System.out.println("Conectado");

        process(socket);
    }

    public void process(Socket socket) throws IOException {
        Scanner in = new Scanner(socket.getInputStream());
        System.out.println(in.nextLine());
    }
}
