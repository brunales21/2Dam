package ProcessBuilderEjemplos.sumaEjemplo;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjecutarSuma {
    public static void main(String[] args) throws IOException, InterruptedException {
        String ruta = "C:\\Users\\2DAM\\workspace\\2Dam\\prog-serv-procesos\\1trim\\ProgramacionMultiproceso\\out\\production\\ProgramacionMultiproceso";

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", ruta, "ProcessBuilderEjemplos.sumaEjemplo.Suma", "4", "b");
        Process p = pb.start();

        //BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader inErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        //Scanner sc = new Scanner(System.in);
        //out.write(sc.nextLine()+"\n");
        //out.write(sc.nextLine()+"\n");
        //out.close();

        if (p.waitFor() == 0) {
            System.out.println(in.readLine());
        } else {
            System.err.println(inErr.readLine());
        }
    }
}
