package impRunnable;

public class Clazz3 implements Runnable {

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1300);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("TIC");
        } while (true);
    }
}
