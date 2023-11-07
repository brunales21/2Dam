package waitNotify;

public class Person extends Thread {
    String name;
    int edad;

    public Person(String name, int edad) {
        this.name = name;
        this.edad = edad;
    }
    public synchronized void m1() {
        System.out.println("esto se va a pausar");
        try {
            wait();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("por fin reanudo");

    }

    public synchronized void m2() {
        System.out.println("vengo a salvarte");
        notify();
    }


}
