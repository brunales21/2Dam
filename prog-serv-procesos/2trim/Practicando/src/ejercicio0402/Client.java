package ejercicio0402;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

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
        process();
    }

    private void process() {
        showData();
        task();
    }



    private void task() {
        Scanner in = new Scanner(System.in);
        PrintStream out = null;
        try {
            out = new PrintStream(socket.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int a;
        do {
            System.out.println("Introduce un número (0 para terminar): ");
            a = in.nextInt();
            out.println(a);
            if (a == 0) {
                break;
            }
            int b = receiveData();
            System.out.println("El doble de "+a+" es "+b);
        } while (true);

    }

    private int receiveData() {
        Scanner in = null;
        try {
            in = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return in.nextInt();


    }

    private void showData() {
        System.out.println();
        System.out.println("Se inicia el proceso cliente.");
        System.out.println("Datos de la conexion establecida:");
        System.out.println("Mi direccion: "+socket.getLocalAddress()+" Mi puerto: "+socket.getLocalPort());
        System.out.println("Direccion del servidor: "+socket.getInetAddress()+" Puerto del servidor: "+socket.getPort());
    }

    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Conexion finalizada.");
    }

    public static void main(String[] args) {
        Client client = new Client("localhost", 2000);
        client.connect();
        client.close();
    }

}
