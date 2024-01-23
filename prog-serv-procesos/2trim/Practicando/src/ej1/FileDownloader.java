package ej1;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class FileDownloader implements Runnable {
    private String urlName;
    private String target;

    public FileDownloader(String urlName, String target) {
        this.urlName = urlName;
        this.target = target;
    }

    @Override
    public void run() {
        URL url;
        URLConnection connection;
        try {
            url = new URL(urlName);
            connection = url.openConnection();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (InputStream in = new BufferedInputStream(connection.getInputStream())) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[1024];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
