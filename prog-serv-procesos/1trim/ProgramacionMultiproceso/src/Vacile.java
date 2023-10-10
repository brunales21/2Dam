
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Vacile {
    public static void main(String[] args) {
        for (int i = 0; i < 5000; i++) {
            ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome");
            try {
                pb.start();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
