package ejSync;

public class Main {
    public static void main(String[] args) {
        Clazz c = new Clazz(10000000);

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
