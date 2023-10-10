package extendsThread;

public class Main {
    public static void main(String[] args) {
        new Thread(new Clazz1()).start();
        new Thread(new Clazz2()).start();

    }
}