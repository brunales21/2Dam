package TicTacThread;

public class Clazz1 extends Thread {
    @Override
    public void run() {
        do {
            System.out.println("Tic..");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
