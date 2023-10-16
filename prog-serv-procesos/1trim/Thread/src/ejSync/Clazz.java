package ejSync;

public class Clazz implements Runnable {
    int contador = 0;
    int veces;

    public Clazz(int veces) {
        this.veces = veces;
    }

    @Override
    public void run() {
        for (int i = 0; i < veces; i++) {
            synchronized (this) {
                contador++;
            }
        }
    }
}
