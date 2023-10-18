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
        jugadores.forEach(JugadorFutbol::writeToCsv);
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

    public static List<JugadorFutbol> readObjectsFromBinary(String ruta) {
        List<JugadorFutbol> jugadores = new ArrayList<>();
        Path path = Paths.get(ruta);
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(path.toString()))) {
            JugadorFutbol obj;
            while ((obj = (JugadorFutbol) in.readObject()) != null) {
                jugadores.add(obj);
            }
        } catch (IOException e) {
            System.err.println(e.getCause());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return jugadores;
    }

    public static void writeObjects(String ruta, List<JugadorFutbol> jugadores) {
        Path path = Paths.get(ruta);
        jugadores.forEach(a -> a.writeToBinaryFile(path.toString()));
    }

    public void addJugador(JugadorFutbol j) {
        jugadores.add(j);
    }

    public List<JugadorFutbol> getJugadores() {
        return jugadores;
    }
}
