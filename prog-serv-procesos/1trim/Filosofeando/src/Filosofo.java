import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Filosofo extends Thread {

    private int id;
    private List<Palillo> palillos;
    private Palillo palilloIzq;
    private Palillo palilloDer;
    private boolean quiereComer;
    private Random rand;
    private static final int MIN_TIME_COMIDA = 3;
    private static final int MAX_TIME_COMIDA = 5;
    private static final int MAX_TIME_PENSANDO = 10;
    private int offset = 20;


    public Filosofo(List<Palillo> palillos) {
        this.rand = new Random();
        this.id = (int) (threadId()-offset);
        this.palillos = palillos;
        this.palilloIzq = palillos.get(id);
        this.palilloDer = palillos.get(id+1);

        this.palilloIzq.setId(id);
        this.palilloDer.setId(id+1);

        this.quiereComer = false;
    }

    public Filosofo() {

    }

    public void pensar() {
        int tiempoPensando = this.rand.nextInt(MAX_TIME_PENSANDO);
        if (!quiereComer) {
            System.out.println("Filosofo "+id+" pensando..");
        }
        quiereComer = true;
    }

    public void comer() {
        System.out.println("Filosofo "+id+" quiere comer.");
        if (quiereComer && palillosLibres()) {
            int tiempoComida = this.rand.nextInt(MIN_TIME_COMIDA, MAX_TIME_COMIDA);
            usarPalillos(true);
            System.out.println("Filosofo "+id+" comiendo. Usando palillos "+(palilloIzq.getId())+" y "+(palilloDer.getId())+" durante "+tiempoComida+" s.");
        } else {
            System.out.println("Filosofo "+id+" no puede comer (Palillo "+getPalilloOcupado()+" ocupado)");
        }
        usarPalillos(false);
        quiereComer = false;
    }

    public String getPalilloOcupado() {
        return !palilloIzq.isDisponible()? "izquierda ("+palilloIzq.getId()+")": "derecha ("+palilloDer.getId()+")";
    }

    public static void esperarSegundos(int s) {
        try {
            Thread.sleep(s*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean palillosLibres() {
        return palilloDer.isDisponible() && palilloIzq.isDisponible();
    }

    public void usarPalillos(boolean b) {
        palilloDer.setDisponible(!b);
        palilloIzq.setDisponible(!b);
    }
    @Override
    public void run() {
        while (true) {
            pensar();
            esperarSegundos(2);
            comer();
        }
    }
}
