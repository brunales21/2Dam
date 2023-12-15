package gestionStarWars;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GestorBDDsw implements CharactersDAO {
    private String url;
    private String username;
    private String password;

    public GestorBDDsw(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void createCharacter(Character character) throws RepeatedCharacterException {
        String query = "INSERT INTO `people` (`name`, `gender`, `birth_year`, `height`, `mass`, `hair_color`, `skin_color`, `eye_color`, `homeworld_id`, `species_id`, `created`, `edited`) " +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP)";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Verificar si el personaje ya existe
            if (existsCharacter(character)) {
                throw new RepeatedCharacterException("El personaje ya existe: " + character.getName());
            }

            // Establecer los parámetros en la consulta
            setCharacterParameters(preparedStatement, character);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    @Override
    public void updateCharacter(Character character) throws CharacterNoExisteException {
        if (!existsCharacter(character)) {
            throw new CharacterNoExisteException();
        }

        String query = "UPDATE `people` SET `gender` = ?, `birth_year` = ?, `height` = ?, `mass` = ?, " +
                "`hair_color` = ?, `skin_color` = ?, `eye_color` = ?, `homeworld_id` = ?, `species_id` = ?, `edited` = CURRENT_TIMESTAMP " +
                "WHERE `name` = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            // Establecer los parámetros en la consulta
            setCharacterParameters(preparedStatement, character);

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new CharacterNoExisteException();
        }
    }

    @Override
    public void deleteCharacter(String name) throws CharacterNoExisteException {
        String query = "DELETE FROM `people` WHERE `name` = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);

            // Verificar si el personaje existe antes de intentar eliminarlo
            if (!existsCharacter(getCharacterByName(name))) {
                throw new CharacterNoExisteException();
            }

            // Ejecutar la consulta
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new CharacterNoExisteException();
        }
    }

    @Override
    public List<Character> getAllCharacters() {
        List<Character> characters = new ArrayList<>();
        String query = "SELECT * FROM `people`";

        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                characters.add(createCharacterFromResultSet(resultSet));
            }

        } catch (SQLException e) {
            return null;
        }

        return characters;
    }

    @Override
    public Character getCharacterByName(String name) throws CharacterNoExisteException {
        String query = "SELECT * FROM `people` WHERE `name` = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, name);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return createCharacterFromResultSet(resultSet);
                } else {
                    throw new CharacterNoExisteException();
                }
            }

        } catch (SQLException e) {
            throw new CharacterNoExisteException();
        }
    }

    @Override
    public boolean existsCharacter(Character character) {
        String query = "SELECT COUNT(*) FROM `people` WHERE `name` = ?";

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, character.getName());

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1) > 0;
                }
            }

        } catch (SQLException e) {
            return false;
        }
        return false;
    }

    // Método auxiliar para establecer los parámetros del personaje en una consulta preparada
    private void setCharacterParameters(PreparedStatement preparedStatement, Character character) throws SQLException {
        preparedStatement.setString(1, character.getGender());
        preparedStatement.setString(2, character.getBirthYear());
        preparedStatement.setInt(3, character.getHeight());
        preparedStatement.setDouble(4, character.getMass());
        preparedStatement.setString(5, character.getHairColor());
        preparedStatement.setString(6, character.getSkinColor());
        preparedStatement.setString(7, character.getEyeColor());
        preparedStatement.setInt(8, 0); // Supongo que homeworld_id y species_id son enteros y por defecto se establecen en 0
        preparedStatement.setInt(9, 0);
        preparedStatement.setString(10, character.getName());
    }

    // Método auxiliar para obtener la conexión a la base de datos
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Método auxiliar para crear un objeto Character a partir de un ResultSet
    private Character createCharacterFromResultSet(ResultSet resultSet) throws SQLException {
        return new Character(
                resultSet.getString("name"),
                resultSet.getString("gender"),
                resultSet.getString("birth_year"),
                resultSet.getInt("height"),
                resultSet.getDouble("mass"),
                resultSet.getString("hair_color"),
                resultSet.getString("skin_color"),
                resultSet.getString("eye_color"),
                resultSet.getString("homeworld_id"),
                resultSet.getString("species_id")
        );
    }
}
