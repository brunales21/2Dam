package ultimosejs;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://192.168.56.101:3306/pokemon_db";
        String username = "admin00";
        String password = "alumno";
        GestorBDD g = new GestorBDD(url, username, password);
        g.insertPokemonAndTipo(new Pokemon(6969, "ns", 4, 4, 4, 4, 4, 4, 4, 4, "newGen"), "tipons");
    }
}
