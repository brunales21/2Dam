package ProcessBuilderEjemplos;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EjecutarSuma {
    public static void main(String[] args) throws IOException, InterruptedException {
        String rutaCasa = "C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\prog-serv-procesos\\1trim\\ProgramacionMultiproceso\\out\\production\\ProgramacionMultiproceso";
        Scanner sc = new Scanner(System.in);

        ProcessBuilder pb = new ProcessBuilder("java", "-cp", rutaCasa, "ProcessBuilderEjemplos.Suma");
        Process p = pb.start();

        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(p.getOutputStream()));
        BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
        BufferedReader inErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));

        out.write(sc.nextLine()+"\n");
        out.write(sc.nextLine()+"\n");
        out.close();

        if (p.waitFor() == 1) {
            System.out.println(in.readLine());
        } else {
            System.err.println(inErr.readLine());
        }
    }
}
