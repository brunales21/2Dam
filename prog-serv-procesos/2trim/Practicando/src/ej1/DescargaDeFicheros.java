package ej1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DescargaDeFicheros {
    public static void main(String[] args) {
        download(Path.of("carpeta1/urls.txt"), Path.of("carpeta-descargas/"), 0);
    }
    public static void download(Path sourcePath, Path targetPath, int max) {
        if (Files.exists(sourcePath) && Files.exists(targetPath)) {
            List<String> urls = getUrls(sourcePath.toString());
            for (String urlName: urls) {
                new Thread(new FileDownloader(urlName, targetPath.toString())).start();
            }
        } else {
            System.err.println("no existe alguno de los ficheros");
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
}
