package ejsJavaNIO;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NioEjs {
    public static void main(String[] args) {
        Path path1 = Paths.get("ficherosEjemplos");
        Path path2 = Paths.get("ficherosEjemplos/BrunoMercado.txt");

        //listarDirectorio("src/BrunoFile.java").forEach(a -> System.out.println(a));
        //generarArchivo(path1.toString(), "bruno", "mercado");
        //renameTo2Dam(path2);

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
        Path destinoFile = Path.of(newFileName);
        try {
            Files.move(originPath, destinoFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }



    public static String firstLetterToUpperCase(String nombre) {
        return String.valueOf(nombre.charAt(0)).toUpperCase()+nombre.substring(1, nombre.length());
    }

}


