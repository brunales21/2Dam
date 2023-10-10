package impRunnable;

public class Clazz4 implements Runnable {

    @Override
    public void run() {
        do {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("TAC");
        } while (true);
    }
}
