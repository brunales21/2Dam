import java.util.Arrays;
import java.util.Objects;

public class BrunoFile extends java.io.File {
    public BrunoFile(String pathname) {
        super(pathname);
    }

    public String showInfo() {
        return "Nombre del archivo: " + this.getName() + "\n" +
                "Ruta del archivo: " + this.getPath() + "\n" +
                "Ruta absoluta del archivo: " + this.getAbsolutePath() + "\n" +
                "¿Se puede leer el archivo?: " + this.canRead() + "\n" +
                "¿Se puede escribir en el archivo?: " + this.canWrite() + "\n" +
                "Espacio total del archivo: " + this.getTotalSpace() + " bytes\n" +
                "¿Es un directorio?: " + this.isDirectory() + "\n" +
                "Archivos en el directorio: " + Arrays.stream(Objects.requireNonNull(this.listFiles())).toList() + "\n" +
                "¿Es un archivo?: " + this.isFile();
    }

}
