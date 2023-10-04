package ProcessBuilderEjemplos.sumaEjemplo;

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
        try {
            int a = Integer.parseInt(args[0]);
            int b = Integer.parseInt(args[1]);
            System.out.print("La suma es: " + a+b);
            System.exit(0);
        } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
            System.err.println("Uso incorrecto. Debe proporcionar dos números enteros como argumentos.");
            System.exit(1);
        }
    }
}
