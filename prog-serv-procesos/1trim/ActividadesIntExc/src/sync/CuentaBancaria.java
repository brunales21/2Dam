package sync;

public class CuentaBancaria {
    private long saldo;

    public CuentaBancaria(long saldo) {
        this.saldo = saldo;
    }

    public void consultarSaldo() {
        System.out.println("Saldo disponible: " + saldo);
    }

    public void retirarDinero(int cant) {
        synchronized (this) {
            if (saldo - cant < 0) {
                System.err.println("saldo negativo");
                return;
            }
            saldo -= cant;
        }

    }
}
