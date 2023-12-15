package gestionStarWars;

public class RepeatedCharacterException extends Exception {
    public RepeatedCharacterException(String s) {
        super("Pokemon repetido.");
    }
}
