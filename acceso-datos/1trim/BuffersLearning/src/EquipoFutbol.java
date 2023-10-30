import csvUtils.ObjectToCSVConverter;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class EquipoFutbol {
    private List<JugadorFutbol> jugadores;

    public EquipoFutbol(List<JugadorFutbol> jugadores) {
        this.jugadores = jugadores;
    }

    public void writeJugadoresToCsv() {
        jugadores = new ArrayList<>();
        Path path = Paths.get("Pruebas/JugadoresFutbol.csv");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path.toString(), true))) {
            for (JugadorFutbol jugadorFutbol: jugadores) {
                out.write(ObjectToCSVConverter.toStringCsv(jugadorFutbol));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void readCsv() {
        jugadores = new ArrayList<>();
        Path path = Paths.get("Pruebas/JugadoresFutbol.csv");
        try (BufferedReader in = new BufferedReader(new FileReader(path.toString()))) {
            String line;
            while ((line = in.readLine()) != null) {
                String [] fields = line.split(";");
                jugadores.add(new JugadorFutbol(fields[0], fields[1], Integer.parseInt(fields[2]), Float.parseFloat(fields[3]), Boolean.parseBoolean(fields[4])));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public static List<JugadorFutbol> readObjectsFromBinaryFile(String ruta) {
        List<JugadorFutbol> jugadores = new ArrayList<>();
        Path path = Paths.get(ruta);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toString()))) {
            JugadorFutbol obj;
            while ((obj = (JugadorFutbol) in.readObject()) != null) {
                jugadores.add(obj);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }

    public static void writeObjectsToBinaryFile(String ruta, List<JugadorFutbol> jugadores) {
        Path path = Paths.get(ruta);
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(path.toString(), true))) {
            for (JugadorFutbol jf: jugadores) {
                out.writeObject(jf);
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void addJugador(JugadorFutbol j) {
        jugadores.add(j);
    }

    public List<JugadorFutbol> getJugadores() {
        return jugadores;
    }
}
