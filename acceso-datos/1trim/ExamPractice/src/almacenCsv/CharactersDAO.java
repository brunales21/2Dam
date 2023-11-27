package almacenCsv;

import java.util.List;

public interface CharactersDAO {
    // M�todo para crear un nuevo personaje
    void createCharacter(Character character) throws RepeatedCharacterException;

    // M�todo para leer un personaje por su nombre
    Character getCharacterByName(String name) throws CharacterNoExisteException;

    // M�todo para actualizar la informaci�n de un personaje
    void updateCharacter(Character character) throws CharacterNoExisteException;

    // M�todo para eliminar un personaje
    void deleteCharacter(String name) throws CharacterNoExisteException;

    // M�todo para obtener una lista de todos los personajes
    List<Character> getAllCharacters();
    void pushToCsv(List<Character> characters);
    boolean existsCharacter(Character character) ;
}
