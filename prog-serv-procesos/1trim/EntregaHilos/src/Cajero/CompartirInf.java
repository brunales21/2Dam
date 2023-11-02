package Cajero;

public class CompartirInf {
	public static void main (String[] args) {
		Cuenta c = new Cuenta (40);
		SacarDinero h1 = new SacarDinero("Ana", 15, c);
		SacarDinero h2 = new SacarDinero ("Juan", 11, c);
		h1.start();
		h2.start();

	}
}
