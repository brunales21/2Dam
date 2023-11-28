package ionewio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class JavaNIO {
    public static void eliminarDirectorio(String directoryName) {
        FileVisitor<Path> fileVisitor = new FileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Files.delete(file);
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                Files.delete(dir);
                return FileVisitResult.CONTINUE;
            }
        };
        Path path = Paths.get(directoryName);
        try {
            Files.walkFileTree(path, fileVisitor);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void rmr(Path path) {
        if (Files.isDirectory(path)) {
            try {
                for (Path path1: Files.newDirectoryStream(path)) {
                    rmr(path1);
                }
                Files.delete(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                Files.delete(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
