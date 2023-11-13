import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int offset = (int) new Thread().threadId()+1;
        List<Palillo> palillos = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            palillos.add(new Palillo());
        }
        Cena c = new Cena(palillos);
        c.init(5, offset);
    }
}