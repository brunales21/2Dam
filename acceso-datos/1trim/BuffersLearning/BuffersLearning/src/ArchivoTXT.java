import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArchivoTXT {
    private static Path path;
    public static void main(String[] args) {
        //ArchivoTXT a = new ArchivoTXT("Pruebas/Lorem ipsum.txt");
        ArchivoTXT o = new ArchivoTXT();
        path = Paths.get("Pruebas/LoremSinVocales.txt");

    }


    public ArchivoTXT() {

    }

    public ArchivoTXT(String s) throws IllegalArgumentException {
        setPath(s);
    }

    public void setPath(String pathName) {
        this.path = Paths.get(pathName);
        if (Files.exists(path) || Files.isDirectory(path)) {
            throw new IllegalArgumentException("La ruta no es un fichero o ya existe.");
        }
        try {
            Files.createFile(this.path);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void aVerso() {
        try {
            List<String> lineas = Files.readAllLines(this.path);

            try (BufferedWriter out = Files.newBufferedWriter(this.path)) {
                for (String linea : lineas) {
                    String[] partes = linea.split("\\."); // "\\." para dividir por el punto literal
                    for (String parte : partes) {
                        out.write(parte.concat(".\n"));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void codifica(String pathname) {
        String vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ";
        try (FileReader in = new FileReader(path.toString());
             FileWriter out = new FileWriter(pathname)) {

            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (vocales.indexOf(letra) == -1) {
                    out.write(letra);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getCause());
        }

    }

    public void codificarFiles(String pathname) {
        String vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ";
        Path p = Paths.get(pathname);
        try (BufferedWriter out = Files.newBufferedWriter(p);
        BufferedReader in = Files.newBufferedReader(ArchivoTXT.path)) {

            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (vocales.indexOf(letra) == -1) {
                    out.write(letra);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }

    public void codificaBuffer(String pathname) {
        String vocales = "aeiouAEIOUáéíóúÁÉÍÓÚ";
        Path p = Paths.get(pathname);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(p.toString()));
             BufferedReader in = new BufferedReader(new FileReader(path.toString()))) {
            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (vocales.indexOf(letra) == -1) {
                    out.write(letra);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }

    public boolean mover(String pathname) {
        Path destinoPath = Paths.get(pathname);
        Path parentPath = null;
        try {
            parentPath = Paths.get(path.getParent().toString());
            Files.move(path, destinoPath, StandardCopyOption.REPLACE_EXISTING);
            Files.delete(parentPath);
            return true;
        }
        catch (DirectoryNotEmptyException e) {
            return true;
        } catch (IOException e) {
            return false;
        }
    }

}
