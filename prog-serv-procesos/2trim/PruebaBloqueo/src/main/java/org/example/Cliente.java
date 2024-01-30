package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 23);
        PrintWriter salida = new PrintWriter(socket.getOutputStream(), true);

        Scanner sc = new Scanner(System.in);
        salida.println(sc.nextLine());
        socket.close();
    }
}
