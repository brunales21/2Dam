package ProcessBuilderEjemplos;

import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) {
        String ruta = "C:\\Users\\2DAM\\workspace\\2Dam\\prog-serv-procesos\\1trim\\ProgramacionMultiproceso\\out\\production\\ProgramacionMultiproceso";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "ProcessBuilderEjemplos.LeerNombre", "Bruno");
        Process p;
        try {
            p = pb.start();
            InputStream in = p.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(in));

            System.out.println(bf.readLine());
            System.out.println("exit code: "+p.waitFor());
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
