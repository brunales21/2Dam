package ejemplo;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Main {
    public static void main(String[] args) {
        f("https://img.freepik.com/foto-gratis/paisaje-forestal_71767-127.jpg", "carpeta1/ej2.txt");

    }

    private static void f(String urlName, String target) {
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
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
                System.out.println(bytesRead);
                System.out.println(buffer.length);
            }


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
