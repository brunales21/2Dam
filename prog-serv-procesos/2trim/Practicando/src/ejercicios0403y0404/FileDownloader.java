package ejercicios0403y0404;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileDownloader implements Runnable {

    private String urlName;
    private String target;

    public FileDownloader(String urlName, String target) {
        this.urlName = urlName;
        this.target = target;
    }

    @Override
    public void run() {
        URLConnection urlConnection = null;
        try {
            urlConnection = new URL(urlName).openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (InputStream in = urlConnection.getInputStream()) {
            Path destino = Path.of(target);
            Files.copy(in, destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    // con pool de hilos

    public static void download1(Path sourcePath, Path targetPath, int maxThreads) {
        List<String> urls = getUrls(sourcePath.toString());
        ExecutorService executor = Executors.newFixedThreadPool(maxThreads);
        for (String urlName: urls) {
            executor.submit(new FileDownloader(urlName, targetPath + getNewName(urlName)));
        }
        executor.shutdown();
    }

    // sin pool de hilos
    public static void download2(Path sourcePath, Path targetPath) {
        List<String> urls = getUrls(sourcePath.toString());
        for (String urlName: urls) {
            new Thread(new FileDownloader(urlName, targetPath + getNewName(urlName))).start();
        }
    }

    private static List<String> getUrls(String source) {
        List<String> urls = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(source))) {
            String url;
            while ((url = in.readLine()) != null) {
                urls.add(url);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return urls;
    }

    private static String getNewName(String urlName) {
        String [] urlParts = urlName.split("/");
        return "/"+urlParts[urlParts.length-1];
    }

    public static void main(String[] args) {
        download1(Path.of("carpeta1/urls.txt"), Path.of("carpeta-descargas/"), 4);
        //download2(Path.of("carpeta1/urls.txt"), Path.of("carpeta-descargas/"));

    }
}
