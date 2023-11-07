import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class Relevos {
    private List<Runner> runners;
    private Random rand;


    public Relevos(List<Runner> runners) {
        this.runners = runners;
    }

    public void init() {
        runners.stream().filter(r -> r.getPrevRunner() == null).toList().get(0).correr();
    }
}
