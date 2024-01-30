package org.example;

import java.io.*;
import java.net.Socket;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 23);
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);


        for (int i = 0; i < 10; i++) {

            salida.println("holaaaaaaaa");
            Thread.sleep(2000);
            salida.println("chaooooooooooo");
        }
        socket.close();
    }
}
