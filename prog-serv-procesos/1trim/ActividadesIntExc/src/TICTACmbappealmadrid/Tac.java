package TICTACmbappealmadrid;

public class Tac implements Runnable {

    @Override
    public void run() {
        int espera = 1000;
        do {
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Tac..");
        } while (true);
    }
}
