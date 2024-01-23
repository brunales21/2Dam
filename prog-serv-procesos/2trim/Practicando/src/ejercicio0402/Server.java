package ejercicio0402;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    private int port;
    private ServerSocket serverSocket;
    private int n;

    public Server(int port) {
        this.port = port;
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Esperando a cliente..");
            Socket socket = serverSocket.accept();
            System.out.println("Cliente conectado.");

            process(socket);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void process(Socket socket) {
        showData(socket);
        task(socket);
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("El cliente ha cerrado la conexión.");

    }

    private void task(Socket socket) {
        try (Scanner in = new Scanner(socket.getInputStream());
             PrintStream out = new PrintStream(socket.getOutputStream())) {
            do {
                if ((n = in.nextInt()) == 0) {
                    System.out.println("break");
                    break;
                }
                System.out.println("Recibimos "+n+", doblamos y enviamos.");
                out.println(n*2);
            } while (true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private void showData(Socket socket) {
        System.out.println();
        System.out.println("Se inicia el proceso servidor.");
        System.out.println("Datos de la conexion establecida:");
        System.out.println("Mi direccion: "+socket.getLocalAddress()+" Mi puerto: "+socket.getLocalPort());
        System.out.println("Direccion del cliente: "+socket.getInetAddress()+" Puerto del cliente: "+socket.getPort());
    }

    public static void main(String[] args) {
        Server server = new Server(2000);
        server.start();
    }
}
