import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<JugadorFutbol> jugadores = new ArrayList<>();
        String rutaFichero = "Pruebas/JugadoresFutbol.csv";
        EquipoFutbol equipo = new EquipoFutbol(jugadores);
        JugadorFutbol bruno = new JugadorFutbol("Bruno Mercado", "Argentina", 1, 1.0f, true);

        JugadorFutbol messi = new JugadorFutbol("Lionel Messi", "Argentina", 1, 0.75f, true);
        JugadorFutbol maradona = new JugadorFutbol("Diego Maradona", "Argentina", 1, 0.5f, false);
        JugadorFutbol cristiano = new JugadorFutbol("Cristiano Ronaldo", "Portugal", 0, 0.85f, true);
        JugadorFutbol neymar = new JugadorFutbol("Neymar Jr.", "Brasil", 0, 0.6f, true);
        JugadorFutbol ronaldinho = new JugadorFutbol("Ronaldinho", "Brasil", 1, 0.4f, false);
        JugadorFutbol mbappe = new JugadorFutbol("Kylian Mbappé", "Francia", 1, 0.7f, true);

        jugadores.add(bruno);
        jugadores.add(messi);
        jugadores.add(maradona);
        jugadores.add(ronaldinho);
        jugadores.add(cristiano);
        jugadores.add(neymar);
        jugadores.add(mbappe);

        equipo.writeJugadoresToCsv(rutaFichero);
        equipo.readCsv();

        jugadores.forEach(a -> System.out.println(a));

/*


        JugadorFutbol j1 = new JugadorFutbol();
        JugadorFutbol j2 = new JugadorFutbol();
        JugadorFutbol j3 = new JugadorFutbol();
        JugadorFutbol j4 = new JugadorFutbol();
        JugadorFutbol j5 = new JugadorFutbol();
        JugadorFutbol j6 = new JugadorFutbol();
        JugadorFutbol j7 = new JugadorFutbol();


        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);
        jugadores.add(j5);
        jugadores.add(j6);
        jugadores.add(j7);





        //EquipoFutbol.writeObjectsToBinaryFile(rutaFichero, equipo.getJugadores());

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(rutaFichero))) {
            jugadores.forEach(j -> j.writeExternal(out));
        } catch (IOException e) {
            System.err.println(e.getCause());
        }

 /*
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(rutaFichero))) {
            jugadores.forEach(j -> {
                try {
                    j.readExternal(in);
                } catch (IOException | ClassNotFoundException e) {
                    System.err.println(e.getCause());
                }
            });
        } catch (IOException e) {
            System.err.println(e.getCause());
        }

        System.out.println(jugadores);

  */

        //equipo.sendJugadoresToCsv();
        //bruno.sendToCsv();

        //equipo.readCsv();
        //equipo.getJugadores().forEach(System.out::println);









    }
}
