package TICTACmbappealmadrid;

public class Tac implements Runnable {
    private int espera;

    public Tac(int espera) {
        this.espera = espera;
    }

    @Override
    public void run() {
        do {
            System.out.println("Tac..");
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
