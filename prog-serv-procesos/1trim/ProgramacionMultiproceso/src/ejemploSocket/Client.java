package ejemploSocket;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

public class Client {
    private Socket socket = new Socket();
    private String host;
    private int serverPort;

    public static void main(String[] args) throws IOException {
        Client client = new Client("localhost", 8080);
        client.connect();
        client.write();

    }

    public Client(String serverName, int serverPort) {
        this.host = serverName;
        this.serverPort = serverPort;
    }

    public void connect() throws IOException {
        this.socket = new Socket(host, serverPort);
    }

    public void write() throws IOException {
        PrintStream out = new PrintStream(socket.getOutputStream());
        out.println("Hola. Soy cliente, encantado.");
    }
}
