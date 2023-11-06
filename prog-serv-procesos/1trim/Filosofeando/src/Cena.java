import java.util.List;

public class Cena {
    List<Filosofo> filosofos;
    List<Palillo> palillos;

    public Cena(List<Palillo> palillos) {
        this.palillos = palillos;
    }

    public Cena() {

    }

    public void init(int cant) {
        for (int i = 0; i < cant; i++) {
            new Filosofo(this.palillos).start();
        }
    }
}
