package EjemploBrunoCuentaBanco;

import TICTACmbappealmadrid.TicTacMain;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        CuentaBancaria cb = new CuentaBancaria(500);
        Persona p = new Persona("Bruno", cb);
        Persona p2 = new Persona("Jaimito", cb);
        Persona p3 = new Persona("Pepito", cb);

        cb.consultarSaldo();

        //quitan dinero de una cuenta compartida

        p.start();
        TicTacMain.esperarSegundos(1);
        cb.consultarSaldo();

        p2.start();
        TicTacMain.esperarSegundos(1);
        cb.consultarSaldo();

        p3.start();
        TicTacMain.esperarSegundos(1);
        cb.consultarSaldo();





    }
}
