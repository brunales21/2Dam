package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.ServerError;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Servidor {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(23);
        System.out.println("esperando..");
        Socket socket = serverSocket.accept();
        System.out.println("cliente conectado.");
        Scanner in = new Scanner(socket.getInputStream());
        while (true) {
            try {
                System.out.println("mensaje: "+in.nextLine());
            } catch (NoSuchElementException ignore) {
                System.out.println("esperando mensaje..");
                Thread.sleep(500);
            }
        }

    }
}
