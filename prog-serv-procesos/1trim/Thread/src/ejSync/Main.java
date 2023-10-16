package ejSync;

public class Main {
    public static void main(String[] args) {
        Clazz c = new Clazz(100000);

        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(c.contador);
    }



}
