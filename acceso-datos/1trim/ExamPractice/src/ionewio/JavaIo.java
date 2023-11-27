package ionewio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JavaIo {
    public void createTemplate(int cantCarp, int cantFich) {
        File father = new File("Carpeta0");
        father.mkdir();
        List<File> files = new ArrayList<>();
        for (int i = 0; i < cantCarp; i++) {
            files.add(new File(father.getPath()+System.getProperty("file.separator")+"Carpeta"+i));
        }

        files.forEach(f -> f.mkdir());

        for (File file: files) {
            for (int i = 0; i < cantFich; i++) {
                try {
                    new File(file.getPath()+System.getProperty("file.separator")+"fichero"+i).createNewFile();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
    public void rmr(String rutaDir) {
        File dir = new File(rutaDir);
        if (dir.isDirectory()) {
            for (File f : dir.listFiles()) {
                if (f.isDirectory()) {
                    rmr(f.getPath());
                }
                System.out.println(f.delete());
            }
            dir.delete();
        }
    }
}
