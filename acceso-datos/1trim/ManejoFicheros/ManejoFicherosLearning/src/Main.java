import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class

Main {
    public static void main(String[] args) {
        String srcPath = "src";
        BrunoFile bf = new BrunoFile(srcPath);
        System.out.println(bf.showInfo());
        //String rutaCarpetaABorrar = "C:\\Users\\2DAM\\workspace\\2Dam\\acceso-datos\\1trim\\ManejoFicheros\\ManejoFicherosLearning\\Directorio-prueba";
        //String rutaAbs = "\"C:\\\\Users\\\\2DAM\\\\workspace\\\\2Dam\\\\acceso-datos\\\\1trim\\\\ManejoFicheros\\\\ManejoFicherosLearning\\\\src";
        //Arrays.stream(listarDirectorio()).forEach(a-> System.out.println(a.toString()));
        //Arrays.stream(listarDirectorio("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\ManejoFicheros\\ManejoFicherosLearning"))
        //        .forEach(a -> System.out.println(a));
        //System.out.println(existeFichero("src", "Main.java"));
        //System.out.println(generarArchivo("src", "pepe", "papo"));
        //renombrarArchivo(rutaAbs+"\\PepePapo.txt");
        //System.out.println(borrarArchivo(rutaAbs+"\\PepePapoDAM2.txt"));
        //borrarDirectorio(rutaCarpetaABorrar);

    }

    public static File[] listarDirectorio() {
        return new File(".").listFiles();
    }

    public static File[] listarDirectorio(String directorio) {
        File dir = new File(directorio);
        if (dir.isDirectory()) {
            return dir.listFiles();
        }
        return null;
    }

    public static boolean existeFichero(String directorio, String fichero) {
        return new File(directorio+"/"+fichero).exists();
    }

    public static boolean existeDir(String rutaDir) {
        return new File(rutaDir).exists();
    }

    public static String firstLetterToUpperCase(String nombre) {
        return String.valueOf(nombre.charAt(0)).toUpperCase()+nombre.substring(1, nombre.length());
    }
    public static boolean generarArchivo(String ruta, String nombre, String apellido) {
        String n = firstLetterToUpperCase(nombre);
        String a = firstLetterToUpperCase(apellido);
        String nombreFichero = n+a+".txt";
        File f = new File(ruta+"/"+nombreFichero);

        if (!existeFichero(ruta, nombreFichero)) {
            try {
                return f.createNewFile();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
            return true;
        }
        System.err.println("Ya existe este fichero");
        return false;
    }

    public static boolean renombrarArchivo(String rutaAbs) {
        File f = new File(rutaAbs);
        String fileName = f.getName().substring(0, f.getName().length()-4).concat("DAM2.txt");
        return f.renameTo(new File(f.getParent()+"\\"+fileName));
    }

    public static boolean borrarArchivo(String absPath) {
        File f = new File(absPath);
        //f.setReadOnly();
        return f.delete();
    }

    public static void borrarDirectorio(String ruta) {
        File f = new File(ruta);
        if (Arrays.stream(f.listFiles()).allMatch(a -> !a.isDirectory())) {
            Arrays.stream(f.listFiles()).forEach(a -> a.delete());
            System.out.println("borrado correctamente");
        } else {
            System.out.println("no se borrará si contiene directorios");
        }
    }


}
