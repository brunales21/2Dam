public class JugadorFutbol {
    private String nombre;
    private String pais;
    private int copasDelMundo;
    private float promedioGoles;
    private boolean tieneBDO;

    // Constructor de la clase JugadorFutbol
    public JugadorFutbol(String nombre, String pais, int copasDelMundo, float promedioGoles, boolean tieneBDO) {
        this.nombre = nombre;
        this.pais = pais;
        this.copasDelMundo = copasDelMundo;
        this.promedioGoles = promedioGoles;
        this.tieneBDO = tieneBDO;
    }

    public static void main(String[] args) {
        JugadorFutbol messi = new JugadorFutbol("Lionel Messi", "Argentina", 1, 0.75f, true);
        JugadorFutbol maradona = new JugadorFutbol("Diego Maradona", "Argentina", 1, 0.5f, false);
        JugadorFutbol cristiano = new JugadorFutbol("Cristiano Ronaldo", "Portugal", 0, 0.85f, true);
        JugadorFutbol neymar = new JugadorFutbol("Neymar Jr.", "Brasil", 0, 0.6f, true);
        JugadorFutbol ronaldinho = new JugadorFutbol("Ronaldinho", "Brasil", 1, 0.4f, false);
        JugadorFutbol mbappe = new JugadorFutbol("Kylian Mbappé", "Francia", 1, 0.7f, true);
        JugadorFutbol suarez = new JugadorFutbol("Luis Suárez", "Uruguay", 0, 0.6f, true);
        JugadorFutbol vanDijk = new JugadorFutbol("Virgil van Dijk", "Países Bajos", 0, 0.1f, false);
    }

}
