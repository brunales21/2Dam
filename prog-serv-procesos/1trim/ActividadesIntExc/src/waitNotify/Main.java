package waitNotify;

public class Main {
    public static void main(String[] args) {
        Person p = new Person("bruno", 20);
        Thread t1 = new Thread(p::m1);
        Thread t2 = new Thread(p::m2);
        t1.start();
        t2.start();
    }


}
