package ejercicio0401;

import java.io.IOException;
import java.net.Socket;

public class Client {
    private int port;
    private String hostname;
    private Socket socket;

    public Client(String hostname, int port) {
        this.port = port;
        this.hostname = hostname;
    }

    public void connect() {
        try {
            socket = new Socket(hostname, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        process(socket);
    }

    private void process(Socket socket) {
        showData(socket);
    }

    private void showData(Socket socket) {
        System.out.println();
        System.out.println("Se inicia el proceso cliente.");
        System.out.println("Datos de la conexion establecida:");
        System.out.println("Mi direccion: "+socket.getLocalAddress());
        System.out.println("Mi puerto: "+socket.getLocalPort());
        System.out.println("Direccion del servidor: "+socket.getInetAddress());
        System.out.println("Puerto del servidor: "+socket.getPort());
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 2000);
        client.connect();
    }

}
