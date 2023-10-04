package sumaEjemplo;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * La clase EjecutarSuma se utiliza para ejecutar el programa "Suma" desde otro programa Java
 * utilizando ProcessBuilder.
 */
public class EjecutarSuma {
    /**
     * El método principal para ejecutar el programa "Suma" desde otro programa Java.
     *
     * @param args Los argumentos de línea de comandos. Se esperan dos números enteros como argumentos.
     */
    public static void main(String[] args) {
        // Ruta al directorio donde se encuentra el archivo compilado de la clase "Suma".
        String ruta = "C:\\Users\\2DAM\\workspace\\2Dam\\prog-serv-procesos\\1trim\\PracticaTema1\\out\\production\\PracticaTema1";

        // Configura ProcessBuilder para ejecutar el programa "Suma" con los argumentos "66" y "33".
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "sumaEjemplo.Suma", "66", "33");

        // Casos de ejemplo para errores:
        // - Número incorrecto de argumentos:
        // ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "sumaEjemplo.Suma", "66");
        // - Tipo de dato incorrecto:
        // ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "sumaEjemplo.Suma", "66", "hola");

        Process p = null;
        try {
            p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // Captura los flujos de entrada, salida y error del proceso.
        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader inErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        //Scanner sc = new Scanner(System.in);
        //out.write(sc.nextLine()+"\n");
        //out.write(sc.nextLine()+"\n");
        //out.close();

        try {
            if (p.waitFor() == 0) {
                System.out.println(in.readLine());
            } else {
                System.err.println(inErr.readLine());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
