package ProcessBuilderEjemplos.redirect;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainRedirect {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("CMD","/C","dir");
        Process p = null;
        File file = new File("salida.txt");
        File fileErr = new File("error.txt");

        pb.redirectOutput(file);
        pb.redirectError(fileErr);

        try {
            p = pb.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
