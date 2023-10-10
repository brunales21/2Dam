
public class RatonSimple implements Runnable {
	
	private String nombre;
	private int tiempoAlimentacion;
	private int alimentoConsumido;
	
	

	public RatonSimple(String nombre, int tiempoAlimentacion) {
		super();
		this.nombre = nombre;
		this.tiempoAlimentacion = tiempoAlimentacion;
	}
	
	public synchronized void comer() {
		
		try {
			System.out.println("El rat�n "+ nombre +" ha comenzado a colocarse");
			Thread.sleep(tiempoAlimentacion*1000);
			alimentoConsumido++;
			System.out.println("El rat�n "+nombre+" ha terminado de colocarse");
			System.out.println("Alimento consumido:"+alimentoConsumido);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		this.comer();
	}
	
/*
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RatonSimple fievel=new RatonSimple("Fievel",4);
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start();
		new Thread(fievel).start();
	}
	
	//main para varios Threads


 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		RatonSimple fievel=new RatonSimple("Fievel",4);
		for (int i=0;i<50;i++){
			new Thread(fievel).start();
		}
	}

}
