package ProcessBuilderEjemplos.sumaEjemplo;

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
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try {
            int a = Integer.parseInt(args[0]);
            //int a = Integer.parseInt(sc.nextLine());

            int b = Integer.parseInt(args[1]);
            //int b = Integer.parseInt(sc.nextLine());

            System.out.print("La suma es: " + (a+b));
            System.exit(0);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Uso incorrecto. Debe proporcionar dos números enteros como argumentos.");
            System.exit(1);
        }
    }
}
