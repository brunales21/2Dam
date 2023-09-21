package pipeExample;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipesExample {
    public static void main(String[] args) {
        try {
            // Crear una tubería de entrada y una tubería de salida
            PipedInputStream inputPipe = new PipedInputStream();
            PipedOutputStream outputPipe = new PipedOutputStream();

            // Conectar las tuberías
            inputPipe.connect(outputPipe);

            // Crear un hilo para escribir en la tubería
            Thread writerThread = new Thread(() -> {
                try {
                    String message = "Hola desde el hilo escritor!";
                    outputPipe.write(message.getBytes());
                    outputPipe.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Crear un hilo para leer desde la tubería
            Thread readerThread = new Thread(() -> {
                try {
                    StringBuilder messageBuilder = new StringBuilder();
                    int data;
                    while ((data = inputPipe.read()) != -1) {
                        messageBuilder.append((char) data);
                    }
                    inputPipe.close();
                    System.out.println("Mensaje recibido: " + messageBuilder.toString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            // Iniciar los hilos
            writerThread.start();
            readerThread.start();

            // Esperar a que ambos hilos terminen
            writerThread.join();
            readerThread.join();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
