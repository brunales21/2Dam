package holamundoRunnable;

public class Main {
    public static void main(String[] args) {
        Clazz1 c1 = new Clazz1("bruno");
        Thread t1 = new Thread(c1);
        c1.setTid(t1.threadId());
        t1.start();

        Clazz1 c2 = new Clazz1("carlos");
        Thread t2 = new Thread(c2);
        c2.setTid(t2.threadId());
        t2.start();

        Clazz1 c3 = new Clazz1("pancha");
        Thread t3 = new Thread(c3);
        c3.setTid(t3.threadId());
        t3.start();

        Clazz1 c4 = new Clazz1("laura");
        Thread t4 = new Thread(c4);
        c4.setTid(t4.threadId());
        t4.start();

        Clazz1 c5 = new Clazz1("adriana");
        Thread t5 = new Thread(c5);
        c5.setTid(t5.threadId());
        t5.start();

        System.out.println(t1.threadId());
        System.out.println(t2.threadId());
        System.out.println(t3.threadId());
        System.out.println(t4.threadId());
        System.out.println(t5.threadId());


    }
}
