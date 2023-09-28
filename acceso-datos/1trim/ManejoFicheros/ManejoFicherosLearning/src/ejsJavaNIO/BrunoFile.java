package ejsJavaNIO;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.Objects;

public class BrunoFile {
    private final Path path;

    public BrunoFile(String pathname) {
        this.path = Paths.get(pathname);
    }

    public String showInfo() {
        try {
            BasicFileAttributes attrs = Files.readAttributes(path, BasicFileAttributes.class);

            return "Nombre del archivo: " + path.getFileName() + "\n" +
                    "Ruta del archivo: " + path.toString() + "\n" +
                    "Ruta absoluta del archivo: " + path.toAbsolutePath() + "\n" +
                    "¿Se puede leer el archivo?: " + Files.isReadable(path) + "\n" +
                    "¿Se puede escribir en el archivo?: " + Files.isWritable(path) + "\n" +
                    "Tamaño total del archivo: " + attrs.size() + " bytes\n" +
                    "¿Es un directorio?: " + attrs.isDirectory() + "\n" +
                    "Archivos en el directorio: " + listFilesAsString() + "\n" +
                    "¿Es un archivo?: " + attrs.isRegularFile();
        } catch (IOException e) {
            e.printStackTrace();
            return "Error al obtener información del archivo.";
        }
    }

    private String listFilesAsString() throws IOException {
        try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path)) {
            StringBuilder filesList = new StringBuilder();
            for (Path entry : directoryStream) {
                if (Files.isDirectory(entry)) {
                    filesList.append("[").append(entry.getFileName()).append("] ");
                } else {
                    filesList.append(entry.getFileName()).append(" ");
                }
            }
            return filesList.toString();
        }
    }

    public static void main(String[] args) {
        BrunoFile brunoFile = new BrunoFile("C:/ruta/del/archivo_o_directorio");
        System.out.println(brunoFile.showInfo());
    }
}
