package ejsJavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NioEjs {
    public static void main(String[] args) {
        Path path1 = Paths.get("EjemplosNio");
        Path path2 = Paths.get("EjemplosNio/BrunoMercado.txt");
        Path path3 = Paths.get("EjemplosNio/BrunoMercado2DAM.txt");

        listarDirectorio("src").forEach(System.out::println);
        //System.out.println(generarArchivo(path1.toString(), "bruno", "mercado"));;
        //System.out.println(renameTo2Dam(path2));;
        //System.out.println(borrarArchivo(path3.toString()));;


    }

    public static List<Path> listarDirectorioActual() {
        List<Path> contenido = new ArrayList<>();
        try {
            Files.newDirectoryStream(Paths.get(".")).forEach(p -> contenido.add(p));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contenido;
    }
    public static List<Path> listarDirectorio(String path) {
        List<Path> contenido = new ArrayList<>();
        try {
            Files.newDirectoryStream(Paths.get(path)).forEach(p -> contenido.add(p));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return contenido;
    }

    public static boolean generarArchivo(String pathName, String nombre, String apellido) {
        String name = firstLetterToUpperCase(nombre);
        String surname = firstLetterToUpperCase(apellido);
        Path p = Paths.get(pathName, name+surname+".txt");
        try {
            Files.createFile(p);
            return true;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static boolean renameTo2Dam(Path originPath) {
        if (Files.isDirectory(originPath) || !Files.exists(originPath)) {
            return false;
        }
        String fileName = originPath.toString();
        String newFileName = fileName.substring(0, fileName.length()-4).concat("2DAM.txt");
        Path destinoPath = Path.of(newFileName);
        try {
            Files.move(originPath, destinoPath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static boolean borrarArchivo(String ruta) {
        Path p = Paths.get(ruta);
        if (Files.isDirectory(p)) {
            return false;
        }
        try {
            //setWriteOnlyPermission(p);
            Files.delete(p);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

        public static void setWriteOnlyPermission(Path filePath) {
            try {
                // Define los permisos de escritura exclusiva
                Set<PosixFilePermission> permissions = new HashSet<>();
                permissions.add(PosixFilePermission.OWNER_WRITE);

                // Configura los atributos del archivo
                FileAttribute<Set<PosixFilePermission>> fileAttributes =
                        PosixFilePermissions.asFileAttribute(permissions);

                // Aplica los atributos al archivo
                Files.createFile(filePath, fileAttributes);

                System.out.println("El archivo se ha configurado como de escritura exclusiva.");
            } catch (IOException e) {
                System.err.println("Error al configurar el archivo como de escritura exclusiva: " + e.getMessage());
            }
        }
    public static String firstLetterToUpperCase(String nombre) {
        return String.valueOf(nombre.charAt(0)).toUpperCase()+nombre.substring(1, nombre.length());
    }

}


