package StarWars;

import java.util.List;

public interface CharactersDAO {
    // Método para crear un nuevo personaje
    void createCharacter(Character character);

    // Método para leer un personaje por su nombre
    Character getCharacterByName(String name);

    // Método para actualizar la información de un personaje
    void updateCharacter(Character character);

    // Método para eliminar un personaje
    void deleteCharacter(String name);

    // Método para obtener una lista de todos los personajes
    List<Character> getAllCharacters();
}
