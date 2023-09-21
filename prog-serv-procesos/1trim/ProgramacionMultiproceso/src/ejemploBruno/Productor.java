package ejemploBruno;

import java.io.*;

public class Productor {
    public static void main(String[] args) {
        File f = new File("pipe.txt");
        String mensaje = "Hola de parte del productor";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(f));
            out.write(mensaje);
            out.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


    }
}
