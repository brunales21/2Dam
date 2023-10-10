package holamundoThread;

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new Clazz1());
        Thread t2 = new Thread(new Clazz1());
        Thread t3 = new Thread(new Clazz1());
        Thread t4 = new Thread(new Clazz1());
        Thread t5 = new Thread(new Clazz1());

        System.out.println(t.threadId());
        System.out.println(t2.threadId());
        System.out.println(t3.threadId());
        System.out.println(t4.threadId());
        System.out.println(t5.threadId());

        System.out.println();

        t.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();

    }
}
