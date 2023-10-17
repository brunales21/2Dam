package ejSync2;

import ejSync.Clazz;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Clazz2 c = new Clazz2(10, 100000);
        Thread t1 = new Thread(c);
        Thread t2 = new Thread(c);

        t1.start();
        t2.start();

        while (true) {
            if (!t1.isAlive() && !t2.isAlive()) {
                System.out.println(c.contador);
                break;
            }
        }


    }
}
