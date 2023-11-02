package TICTACmbappealmadrid;

public class Tic implements Runnable {
    private int espera;

    public Tic(int espera) {
        this.espera = espera;
    }
    @Override
    public void run() {
        do {
            System.out.println("Tic..");
            try {
                Thread.sleep(espera);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
