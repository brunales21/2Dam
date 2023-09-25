package pbTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("java", "-cp", "C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\prog-serv-procesos\\1trim\\ProgramacionMultiproceso\\out\\production\\ProgramacionMultiproceso", "pbTest.Main2");
        Process p = pb.start();
        InputStream in = p.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());
        System.out.println(br.readLine());


    }
}
