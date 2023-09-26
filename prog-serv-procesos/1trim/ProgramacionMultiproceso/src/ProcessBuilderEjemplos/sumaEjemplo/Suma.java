package ProcessBuilderEjemplos.sumaEjemplo;

import java.awt.desktop.SystemSleepEvent;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Suma {
    public static void main(String[] args) {
        sumar();
    }

    public static void sumar() {
        Scanner sc = new Scanner(System.in);
        try {
            int a = Integer.parseInt(sc.nextLine());
            int b = Integer.parseInt(sc.nextLine());
            System.out.print(a+b);
            System.exit(1);
        } catch (NumberFormatException e) {
            System.err.println("Solo enteros.");
            System.exit(-1);
        }
    }
}
