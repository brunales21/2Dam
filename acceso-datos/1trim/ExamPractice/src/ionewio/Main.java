package ionewio;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        JavaIo j = new JavaIo();
        j.createTemplate(10, 2);
        j.rmr("Carpeta0");

        JavaNIO nio = new JavaNIO();
        nio.rmr(Paths.get("Carpeta0"));

    }
}
