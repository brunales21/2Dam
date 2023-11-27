package csvDao;

public class RepeatedCharacterException extends Exception {
    public RepeatedCharacterException() {
        super("Pokemon repetido.");
    }
}
