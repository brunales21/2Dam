package dudaSync;


public class SincronizacionHilos {
    public static void main(String[] args) {
        CuentaBancaria2 cuenta = new CuentaBancaria2();

        Runnable retirada1 = () -> {
            for (int i = 0; i < 5; i++) {
                cuenta.retirarDinero(200);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread persona1 = new Thread(retirada1, "Persona 1");
        Thread persona2 = new Thread(retirada1, "Persona 2");
        Thread persona3 = new Thread(retirada1, "Persona 3");

        persona1.start();
        persona2.start();
        persona3.start();
    }
}
