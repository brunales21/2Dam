package procesoPython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            // Especifica el comando para ejecutar el script Python
            String comandoPython = "python3 /ruta/a/tu_script.py"; // Asegúrate de especificar la ruta correcta

            // Crea un proceso para ejecutar el comando
            Process proceso = Runtime.getRuntime().exec(comandoPython);

            // Captura la salida del proceso (STDOUT)
            BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()));
            String linea;

            // Lee y muestra la salida del proceso línea por línea
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }

            // Espera a que el proceso termine
            proceso.waitFor();

            // Imprime el código de salida del proceso
            int codigoSalida = proceso.exitValue();
            System.out.println("El proceso Python ha finalizado con código de salida: " + codigoSalida);

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
