package ejercicio0405;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ClientHandler extends Thread {
    private Socket socket;

    public ClientHandler(Socket serverSocket) {
        this.socket = serverSocket;
    }

    public void run() {
        try (PrintStream out = new PrintStream(socket.getOutputStream());
             Scanner in = new Scanner(socket.getInputStream())) {
            boolean end = false;
            do {
                out.println("Ingresa F para consultar la fecha actual o H para la hora actual: ");
                String option = in.nextLine();
                if (option.equals("EXIT")) {
                    break;
                }
                switch (option) {
                    case "F":
                        out.println("Fecha: "+Utils.getDate());
                        break;
                    case "H":
                        out.println("Hora: "+Utils.getTime());
                        break;
                    case "0":
                        end = true;
                        break;
                    default:
                        out.println("ERROR");
                }
            } while (!end);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
