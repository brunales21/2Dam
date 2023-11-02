package TicTacThread;

public class Clazz2 extends Thread {
    @Override
    public void run() {
        do {
            System.out.println("Tac..");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
