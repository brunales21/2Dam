package procesoPython;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        String archivoPy = "C:\\Users\\2DAM\\PycharmProjects\\pythonProject\\main.py";
        ProcessBuilder pb = new ProcessBuilder("python", archivoPy);
        try {
            Process p = pb.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String linea;
            while ((linea = in.readLine()) != null) {
                System.out.println(linea);
            }
            System.out.println("Codigo de salida: "+p.waitFor());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
