package Cajero;

public class Cuenta {

	private int saldo;

	Cuenta(int s) {
		saldo = s;
	}

	int getSaldo() {
		return saldo;
	}
	void consultarSaldo() {
		System.out.println("Saldo actual: "+getSaldo());
	}

	synchronized void addDinero(int cant) {
		saldo+=cant;
	}
	synchronized void retirarDinero(int cantidad) {
		saldo = saldo - cantidad;
	}

	synchronized void retirarDinero(int cant, String nom) {
		if (getSaldo() >= cant) {
			System.out.println(nom + " : va a retirar saldo (el actual es: " + getSaldo() + " )");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}

			retirarDinero(cant);
			System.out.println("\t" + nom + " retira => " + cant + " Saldo Actual ( " + getSaldo() + " )");
		} else {
			System.out.println(nom + " No puede retirar la cantidad " + cant + " porque el saldo es: " + getSaldo() + " ");
		}
		if (getSaldo() < 0) {
			System.out.println("SALDO NEGATIVO: " + getSaldo());
		}

	}

}
