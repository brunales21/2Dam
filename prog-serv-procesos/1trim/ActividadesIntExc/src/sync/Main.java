package sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cb = new CuentaBancaria(500);
        Persona p = new Persona("Bruno", cb);
        Persona p2 = new Persona("juanpa", cb);
        Persona p3 = new Persona("leo", cb);

        cb.consultarSaldo();

        p.start();
        Thread.sleep(1000);
        cb.consultarSaldo();

        p2.start();
        Thread.sleep(1000);
        cb.consultarSaldo();

        p3.start();
        Thread.sleep(1000);
        cb.consultarSaldo();





    }
}
