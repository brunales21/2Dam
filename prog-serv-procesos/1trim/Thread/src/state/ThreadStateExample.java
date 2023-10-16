package state;

public class ThreadStateExample {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(2000); // Simular algo de trabajo
                System.out.println("ejecutando hilo");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        System.out.println("Estado inicial del hilo: " + thread.getState());
        Thread.sleep(1000);

        thread.start();
        System.out.println("Estado del hilo: " + thread.getState());
        Thread.sleep(500);


        while (thread.isAlive()) {
            System.out.println("Estado actual del hilo: " + thread.getState());
        }

        System.out.println("Estado final del hilo: " + thread.getState());
    }
}
