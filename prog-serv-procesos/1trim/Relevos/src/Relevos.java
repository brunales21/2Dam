import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Relevos {
    private List<Runner> runners;
    private Random rand;


    public Relevos() {
        this.runners = new ArrayList<>();
    }

    public void init(int n) {
        for (int i = 0; i < n; i++) {
            runners.add(new Runner());
        }
        setOrder();
    }

    public void start() {
        runners.get(0).start();
    }

    public void setOrder() {
        for (int i = 0; i < runners.size(); i++) {
            if (i == 0) {
                runners.get(i).setNxtRunner(runners.get(i+1));
            } else if (i == runners.size()-1) {
                runners.get(i).setPrevRunner(runners.get(i-1));
            } else {
                runners.get(i).setPrevRunner(runners.get(i-1));
                runners.get(i).setNxtRunner(runners.get(i+1));
            }
        }
    }
}
