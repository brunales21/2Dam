package Cajero;

public class SacarDinero extends Thread {
	private Cuenta c;
	String nom;
	private int cant;
	
	public SacarDinero(String n, int cant, Cuenta c) {
		super(n);
		this.c=c;
		this.cant = cant;
	}
	
	public void run() {
		for (int x=1; x<=4;x++) {
			c.retirarDinero(cant, getName());
		}
	}

}
