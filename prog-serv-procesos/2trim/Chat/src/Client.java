import java.io.IOException;
import java.net.Socket;

public class Client {
    private String hostname;
    private int port;
    protected Socket socket;

    public Client(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;

    }
    public Client() {

    }
    public void connect() {
        try {
            socket = new Socket(hostname, port);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
