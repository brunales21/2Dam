package ejSync2;

public class Clazz2 implements Runnable {
    int contador;
    int veces;
    boolean dir = true;

    public Clazz2(int contador, int veces) {
        this.contador = contador;
        this.veces = veces;
    }
    private void inc() {
        contador++;
    }

    private void dec() {
        contador--;
    }

    @Override
    public void run() {
        // +1-1
        synchronized (this) {
            for (int i = 0; i < veces; i++) {
                if (dir) {
                    inc();
                } else {
                    dec();
                }
                dir = !dir;
                System.out.println(contador);
            }
        }

        /*
        // +veces-veces
        synchronized (this) {
            if (dir) {
                for (int i = 0; i < veces; i++) {
                    inc();
                }
            } else {
                for (int i = 0; i < veces; i++) {
                    dec();
                }
            }
        }

         */
    }
}
