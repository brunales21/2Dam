import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class SystemPropertiesExample {

    public static void main(String[] args) {
        // Obtener el separador de archivos del sistema
        String fileSeparator = System.getProperty("file.separator");
        System.out.println("File Separator: " + fileSeparator);

        // Obtener el directorio de inicio del usuario
        String userHome = System.getProperty("user.home");
        System.out.println("User Home Directory: " + userHome);

        // Obtener el directorio actual de trabajo
        String userDir = System.getProperty("user.dir");
        System.out.println("User Working Directory: " + userDir);

        // Obtener el separador de líneas del sistema
        String lineSeparator = System.getProperty("line.separator");
        System.out.println("Line Separator: " + lineSeparator);

        // Ejemplo de construcción de una ruta de archivo independiente del sistema
        String filePath = userHome + fileSeparator + "miArchivo.txt";
        System.out.println("File Path: " + filePath);

        System.out.println(Paths.get(".").toAbsolutePath());
        System.out.println(new File(".").getAbsolutePath());



    }
}
