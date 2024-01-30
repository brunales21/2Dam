package ejercicio0405;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Server {
    private String hostname;
    private int port;
    private ServerSocket serverSocket;
    private Map<Socket, Client> socketClientMap;

    public Server(String hostname, int port) {
        this.hostname = hostname;
        this.port = port;
        this.socketClientMap = new HashMap<>();
    }

    public void start() {
        do {
            Socket socket = null;
            try {
                serverSocket = new ServerSocket(port);
                socket = serverSocket.accept();
                Client client = new Client(hostname, port);
                socketClientMap.put(socket, client);

                Thread clientThread = new Thread(client);
                clientThread.start();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } while (true);
    }

    private void process(Socket socket) {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream());
            Scanner in = new Scanner(socket.getInputStream())) {
            String opt;
            do {
                out.println("Ingresa 'F' para obtener la fecha actual o 'H' para la hora actual en la terminal.");
                opt = in.nextLine();
                if (opt.equals("EXIT")) {
                    break;
                }
                switch (opt) {
                    case "F":
                        out.println(getDate());
                        break;
                    case "H":
                        out.println(getTime());
                        break;
                    default:
                        out.println("ERROR");
                }
            } while (!opt.equals("0"));
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    private String getDate() {
        // Obtén la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Define el formato que deseas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Formatea la fecha en el formato deseado
        String fechaFormateada = fechaActual.format(formato);

        return fechaFormateada;
    }

    private String getTime() {
        // Obtén la hora actual
        LocalTime horaActual = LocalTime.now();

        // Define el formato que deseas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatea la hora en el formato deseado
        String horaFormateada = horaActual.format(formato);

        return horaFormateada;
    }

    public static void main(String[] args) {
        Server server = new Server("localhost", 80);
        server.start();
    }


}
