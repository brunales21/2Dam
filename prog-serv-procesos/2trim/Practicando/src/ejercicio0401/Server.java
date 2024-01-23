package ejercicio0401;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;
    private ServerSocket serverSocket;

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
        System.out.println("Se inicia el proceso servidor.");
        System.out.println("Datos de la conexion establecida:");
        System.out.println("Mi direccion: "+socket.getLocalAddress());
        System.out.println("Mi puerto: "+socket.getLocalPort());
        System.out.println("Direccion del cliente: "+socket.getInetAddress());
        System.out.println("Puerto del cliente: "+socket.getPort());
    }

    public static void main(String[] args) {
        Server server = new Server(2000);
        server.start();
    }
}
