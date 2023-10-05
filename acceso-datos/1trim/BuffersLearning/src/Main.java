import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<JugadorFutbol> jugadores = new ArrayList<>();
        EquipoFutbol equipo = new EquipoFutbol(jugadores);
        /*

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


        equipo.sendJugadoresToCsv();
        //bruno.sendToCsv();

        */

        equipo.readCsv();
        equipo.getJugadores().forEach(System.out::println);








    }
}
