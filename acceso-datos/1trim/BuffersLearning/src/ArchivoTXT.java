import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*;

public class ArchivoTXT {
    public static final String SIGNOS_PUNTUACION = ".,;:!?¿¡()[]{}\"'`-_/\\@#$%^&*+=<>";
    public static final String VOCALES = "aeiouüAEIOUáéíóúÁÉÍÓÚÜ";
    public static final String VOCALES2 = "aeiouAEIOU";

    private static Path path;
    public static void main(String[] args) {
        ArchivoTXT o = new ArchivoTXT();
        path = Paths.get("Pruebas/Lorem Ipsum.txt");
        //path = Paths.get("Pruebas/ejemplo.txt");

        o.cuentaVocalesPorPalabra();
        System.out.println(o.frecuenciaLetras());

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
                    String[] partes = linea.split("\\.");
                    // "\\." para dividir por el punto literal
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
        try (FileReader in = new FileReader(path.toString());
             FileWriter out = new FileWriter(pathname)) {

            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (VOCALES.indexOf(letra) == -1) {
                    out.write(letra);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getCause());
        }

    }

    public void codificarFiles(String pathname) {
        Path p = Paths.get(pathname);
        try (BufferedWriter out = Files.newBufferedWriter(p);
            BufferedReader in = Files.newBufferedReader(ArchivoTXT.path)) {

            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (VOCALES.indexOf(letra) == -1) {
                    out.write(letra);
                }
            }

        } catch (IOException e) {
            System.err.println(e.getCause());
        }
    }

    public void codificaBuffer(String pathname) {
        Path p = Paths.get(pathname);
        try (BufferedWriter out = new BufferedWriter(new FileWriter(p.toString()));
             BufferedReader in = new BufferedReader(new FileReader(path.toString()))) {
            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (VOCALES.indexOf(letra) == -1) {
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

    public int contarCaracteres() {
        int contador = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(path.toString()))) {
            while (in.read() != -1) {
                contador++;
            }
        } catch (IOException e) {
            System.err.println(e.getCause());
        }
        return contador;
    }

    public int contar(String pattern) {
        int contador = 0;
        try (BufferedReader in = new BufferedReader(new FileReader(path.toString()))) {
            char letra;
            int charCode;
            while ((charCode = in.read()) != -1) {
                letra = (char) charCode;
                if (contains(pattern, letra)) {
                    contador++;
                }
            }

        } catch (IOException e) {
            System.err.println(e.getCause());
        }
        return contador;
    }

    public int cuentaLineas() {
        try {
            List<String> lineas = Files.readAllLines(this.path, StandardCharsets.UTF_8);
            return (int)lineas.stream().filter(l -> l.endsWith(".")).count();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int cuentaPalabras() {
        int contador = 0;
        try (BufferedReader in = Files.newBufferedReader(path)) {
            String line;
            while ((line = in.readLine()) != null) {
                contador += line.split(" ").length;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return contador;
    }

    public int contarTipo(String text, String pattern) {
        int contador = 0;
        for (int i = 0; i < text.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
                if (text.charAt(i) == pattern.charAt(j)) {
                    contador++;
                    break;
                }
            }
        }
        return contador;
    }

    public boolean contains(String s, char c) {
        return s.indexOf(c) != -1;
    }

    public void cuentaVocalesPorPalabra() {
        Path vocalesPath = Paths.get("Pruebas/numVocales.txt");
        try (BufferedWriter out = Files.newBufferedWriter(vocalesPath)) {
            List<String> lines = Files.readAllLines(path);
            for (String line: lines) {
                String [] words = line.split(" ");
                for (String word: words) {
                    int cantVocales = contarTipo(word, VOCALES);
                    out.write(cantVocales+" ");
                }
                out.write("\n");
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public Map<Character, Integer> frecuenciaLetras() {
        Map<Character, Integer> map = new HashMap<>();
        Set<Character> letrasContadas = new HashSet<>();
        try (FileReader in = new FileReader(path.toString())) {
            int charCode;
            char c;
            while ((charCode = in.read()) != -1) {
                c = (char) charCode;
                if (Character.isLetter(c) && !letrasContadas.contains(c)) {
                    map.put(c, contar(Character.toString(c)));
                    letrasContadas.add(c);
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return map;
    }

}


