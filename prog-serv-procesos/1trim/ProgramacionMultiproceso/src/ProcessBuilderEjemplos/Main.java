package ProcessBuilderEjemplos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        ls();

    }

    public static void ls() {
        String s = "";
        try {
            ProcessBuilder pb = new ProcessBuilder("CMD","/C","deir");
            Process p = pb.start();
            InputStream in2 = p.getErrorStream();
            InputStream in = p.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            BufferedReader errorReader = new BufferedReader(new InputStreamReader(in2));

            while ((s = reader.readLine()) != null) {
                System.out.println(s);
            }
            System.out.println(errorReader.readLine());
            System.out.println("exit code: "+p.waitFor());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
