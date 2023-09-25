package ProcessBuilderEjemplos;

import java.util.Arrays;

public class LeerNombre {
    public static void main(String[] args) {
        if (args.length == 1) {
            System.out.println("Hola, "+args[0]);
            System.exit(0);
        } else {
            System.exit(-1);
        }
    }
}
