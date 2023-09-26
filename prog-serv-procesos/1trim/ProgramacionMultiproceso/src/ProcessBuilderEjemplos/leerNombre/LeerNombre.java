package ProcessBuilderEjemplos.leerNombre;

import java.util.Arrays;

public class LeerNombre {
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println("Hola, "+args[0]);
            System.exit(0);
        } else {
            System.err.println("Only one parameter needed.");
            System.exit(-1);
        }
    }

    public void saludar(String nombre) {
        System.out.println("Hola, "+nombre);

    }
}
