package impRunnable;

public class Main {
    public static void main(String[] args) {
        Clazz3 c3 = new Clazz3();
        Thread t3 = new Thread(c3);

        Clazz4 c4 = new Clazz4();
        Thread t4 = new Thread(c4);

        t3.start();
        t4.start();

    }
}
