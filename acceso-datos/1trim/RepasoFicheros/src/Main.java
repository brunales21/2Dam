import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path p = Paths.get("C:\\Users\\2DAM\\workspace\\2Dam\\acceso-datos\\1trim\\RepasoFicheros\\out\\production\\RepasoFicheros\\Main.class");
        System.out.println(Files.isRegularFile(p));
        System.out.println(p.relativize(Paths.get("C:\\Users\\2DAM\\workspace")));

        Path p2 = Paths.get("C:\\Users\\2DAM\\workspace\\2Dam\\acceso-datos\\1trim\\RepasoFicheros\\out\\production\\RepasoFicheros\\Main.class");
        System.out.println(Files.isRegularFile(p));
        System.out.println(p2.resolve(Paths.get("C:\\Users\\2DAM\\workspace")));
    }
}