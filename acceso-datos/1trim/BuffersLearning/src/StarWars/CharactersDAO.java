package StarWars;

import java.util.List;

public interface CharactersDAO {
    // Método para crear un nuevo personaje
    void createCharacter(Character character) throws RepeatedCharacterException;

    // Método para leer un personaje por su nombre
    Character getCharacterByName(String name) throws CharacterNoExisteException;

    // Método para actualizar la información de un personaje
    void updateCharacter(Character character) throws CharacterNoExisteException;

    // Método para eliminar un personaje
    void deleteCharacter(String name) throws CharacterNoExisteException;

    // Método para obtener una lista de todos los personajes
    List<Character> getAllCharacters();
    void pushToCsv(List<Character> characters);
    boolean existsCharacter(Character character) ;
}
