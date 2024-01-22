package ej1;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DescargaDeFicheros {
    public void download(String source, String target, int max) {

        List<String> urls = getUrls(source);
        for (String urlName: urls) {
            URL url = null;
            URLConnection conexion = null;
            try {
                url = new URL(urlName);
                conexion = url.openConnection();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            try (InputStream in = new BufferedInputStream(conexion.getInputStream());
                FileOutputStream out = new FileOutputStream(target)) {
                byte [] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private List<String> getUrls(String source) {
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
