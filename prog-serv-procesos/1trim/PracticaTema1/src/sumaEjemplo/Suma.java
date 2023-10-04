package sumaEjemplo;

import java.util.Scanner;

/**
 * Esta clase realiza la suma de dos números enteros.
 */
public class Suma {
    /**
     * Método principal para ejecutar la suma desde la línea de comandos.
     *
     * @param args Los argumentos de línea de comandos, deben ser dos números enteros.
     */
    public static void main(String[] args) {
        if (args.length == 2) {
            //Scanner sc = new Scanner(System.in);
            try {
                int a = Integer.parseInt(args[0]);
                int b = Integer.parseInt(args[1]);
                //int a = Integer.parseInt(sc.nextLine());
                //int b = Integer.parseInt(sc.nextLine());
                int suma = a+b;
                System.out.print("La suma es: " + suma);
                System.exit(0);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                System.err.println("Uso incorrecto. Debe proporcionar dos numeros enteros como argumentos.");
                System.exit(1);
            }
        } else {
            System.err.println("Se esperaban 2 argumentos pero se encontraron "+args.length);
            System.exit(1);
        }

    }
}
