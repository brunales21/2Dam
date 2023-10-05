import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class JugadorFutbol {
    private String nombre;
    private String pais;
    private int copasDelMundo;
    private float promedioGoles;
    private boolean tieneBDO;

    public JugadorFutbol(String nombre, String pais, int copasDelMundo, float promedioGoles, boolean tieneBDO) {
        this.nombre = nombre;
        this.pais = pais;
        this.copasDelMundo = copasDelMundo;
        this.promedioGoles = promedioGoles;
        this.tieneBDO = tieneBDO;
    }

    public void sendToCsv() {
        Path path = Paths.get("Pruebas/JugadoresFutbol.csv");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path.toString(), true))) {
            out.write(this+"\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void mostrar() {
        try {
            Class miClase = Class.forName("JugadorFutbol");
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                System.out.println(campo.getName()+" = "+campo.get(this));
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }




    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            Class miClase = Class.forName("JugadorFutbol");
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                sb.append(campo.get(this)).append(";");
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getCopasDelMundo() {
        return copasDelMundo;
    }

    public float getPromedioGoles() {
        return promedioGoles;
    }

    public boolean isTieneBDO() {
        return tieneBDO;
    }
}
