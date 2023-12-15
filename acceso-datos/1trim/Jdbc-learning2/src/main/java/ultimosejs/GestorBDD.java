package ultimosejs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GestorBDD {
    private String url;
    private String username;
    private String password;

    public GestorBDD(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }


    public void insertPokemonAndTipo(Pokemon pokemon, String tipo) {
        try (Connection conexion = DriverManager.getConnection(url, username, password)) {
            conexion.setAutoCommit(false);
            String insercionPokemon = "INSERT INTO pokemon (id_Num, name, HP, speed, attack, special_attack, defense, special_defense, evolve_id, generation) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
            String insercionTipo = "INSERT INTO types (types) " + "VALUES (?);";

            try (PreparedStatement sentenciaP = conexion.prepareStatement(insercionPokemon);
                 PreparedStatement sentenciaT = conexion.prepareStatement(insercionTipo)) {
                try {
                    //pokemon
                    sentenciaP.setInt(1, pokemon.getId());
                    sentenciaP.setString(2, pokemon.getName());
                    sentenciaP.setInt(3, pokemon.getLife());
                    sentenciaP.setInt(4, pokemon.getSpeed());
                    sentenciaP.setInt(5, pokemon.getAttack());
                    sentenciaP.setInt(6, pokemon.getSpecialAttack());
                    sentenciaP.setInt(7, pokemon.getDefense());
                    sentenciaP.setInt(8, pokemon.getSpecialDefense());
                    sentenciaP.setInt(9, pokemon.getEvolveId());
                    sentenciaP.setString(10, pokemon.getGeneration());
                    //tipo
                    sentenciaT.setString(1, tipo);
                    //confirmar transaccion
                    conexion.commit();
                } catch (SQLException ex) {
                    System.out.println("Error al procesar la transacción.");
                    System.out.println("Revirtiendo al estado anterior.");
                    // Volvemos al estado anterior.
                    conexion.rollback();
                }
            } finally {
                // dejamos el estado anterior.
                conexion.setAutoCommit(true);
            }
        } catch (SQLException ex) {
            System.out.println("ERROR: no se pudo acceder a la BdD.");
        }
    }

    public void insertTipo(String tipo) {

    }
}
