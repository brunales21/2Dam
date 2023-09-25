package ProcessBuilderEjemplos;

import java.io.*;

public class Ejemplo3 {
    public static void main(String[] args) {
        String rutaClase = "C:\\Users\\2DAM\\workspace\\2Dam\\prog-serv-procesos\\1trim\\ProgramacionMultiproceso\\out\\production\\ProgramacionMultiproceso";
        String rutaCasa = "C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\prog-serv-procesos\\1trim\\ProgramacionMultiproceso\\out\\production\\ProgramacionMultiproceso";
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", rutaCasa, "ProcessBuilderEjemplos.LeerNombre", "Bruno");
        Process p;
        try {
            p = pb.start();

            InputStream in = p.getInputStream();
            InputStream errorInput = p.getErrorStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(errorInput));

            System.out.println(reader.readLine());
            int exitCode;
            System.out.println("exit code: "+(exitCode = p.waitFor()));
            if (exitCode == -1) {
                System.err.println(errorReader.readLine());
            }
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
