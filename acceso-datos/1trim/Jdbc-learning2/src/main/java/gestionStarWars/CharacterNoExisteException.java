package gestionStarWars;

public class CharacterNoExisteException extends Exception {
    public CharacterNoExisteException() {
        super("Pokemon no existe.");
    }
}
