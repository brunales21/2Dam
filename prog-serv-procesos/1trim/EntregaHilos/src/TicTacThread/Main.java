package TicTacThread;

import TICTACmbappealmadrid.TicTacMain;

public class Main {
    public static void main(String[] args) {
        new Thread(new Clazz1()).start();
        TicTacMain.esperarSegundos(0.2f);
        new Thread(new Clazz2()).start();

    }
}