package sync;

public class Persona extends Thread {
    private String nombre;
    private CuentaBancaria cuentaBancaria;

    public Persona(String nombre, CuentaBancaria cuentaBancaria) {
        this.nombre = nombre;
        this.cuentaBancaria = cuentaBancaria;
    }

    @Override
    public void run() {
        int cant = 200;
        cuentaBancaria.retirarDinero(cant);
        System.out.println(nombre+" retiro "+cant+"€");
    }
}
