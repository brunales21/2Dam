package ejemploBruno;

import java.io.*;

public class Consumidor {
    public static void main(String[] args) {
        File f = new File("pipe.txt");
        try {
            BufferedReader in = new BufferedReader(new FileReader(f));
            System.out.println(in.readLine());
            in.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }
}
