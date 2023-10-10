package extendsThread;

public class Clazz1 extends Thread {
    @Override
    public void run() {
        do {
            System.out.println("tic");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        } while (true);
    }
}
