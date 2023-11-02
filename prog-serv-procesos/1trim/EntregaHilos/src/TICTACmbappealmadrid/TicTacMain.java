package TICTACmbappealmadrid;

public class TicTacMain {
    public static void main(String[] args) {
        Tic c1 = new Tic(500);
        Thread t1 = new Thread(c1);

        Tac c2 = new Tac(500);
        Thread t2 = new Thread(c2);

        t1.start();

        esperarSegundos(0.1f);

        t2.start();

        //¿Se visualizan los textos TIC y TAC de forma ordenada?
        //De la forma en la que he hecho el ejercicio, siempre se respetará el orden
    }

    public static void esperarSegundos(float s) {
        try {
            Thread.sleep((long) (s*1000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
