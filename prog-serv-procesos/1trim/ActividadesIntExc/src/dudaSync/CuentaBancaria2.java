package dudaSync;

public class CuentaBancaria2 {
    private int saldo = 1000;

    public synchronized void retirarDinero(int cantidad) {
        if (saldo >= cantidad) {
            System.out.println(Thread.currentThread().getName() + " está retirando " + cantidad + " euros.");
            saldo -= cantidad;
            System.out.println("Saldo restante: " + saldo + " euros.");
        } else {
            System.out.println(Thread.currentThread().getName() + " no puede retirar " + cantidad + " euros. Saldo insuficiente.");
        }
    }

    public synchronized int consultarSaldo() {
        return saldo;
    }
}

