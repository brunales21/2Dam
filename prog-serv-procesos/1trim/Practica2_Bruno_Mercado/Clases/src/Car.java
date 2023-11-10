import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Bruno Mercado
 * Clase que representa un coche en el sistema de estacionamiento.
 */
public class Car extends Thread {
    private Parking parking; // Referencia al estacionamiento al que pertenece el coche
    private Random rand; // Objeto para generación de números aleatorios
    private int id; // Identificador único del coche
    private static final int MAX_TIME_PARKED = 8; // Tiempo máximo que un coche puede permanecer estacionado
    private static final int MIN_TIME_PARKED = 6; // Tiempo mínimo que un coche puede permanecer estacionado
    private static final int MAX_TIME_OUT = 5; // Tiempo máximo que un coche puede estar fuera del estacionamiento
    private static final int MIN_TIME_OUT = 3; // Tiempo mínimo que un coche puede estar fuera del estacionamiento

    /**
     * Constructor de la clase Car.
     *
     * @param parking El estacionamiento al que pertenece el coche.
     */
    public Car(Parking parking, int offsetId) {
        this.parking = parking;
        this.rand = new Random();
        this.id = (int) (threadId() - offsetId); // Calcula el ID del coche
    }

    /**
     * Intenta entrar al estacionamiento.
     *
     * @return true si el coche entra con éxito, false si el estacionamiento está lleno.
     */
    public boolean entrar() {
        return parking.addCar(this);
    }

    /**
     * Sale del estacionamiento.
     */
    public void salir() {
        parking.removeCar(this);
    }

    /**
     * Método que se ejecuta cuando inicia el hilo del coche.
     */
    @Override
    public void run() {
        while (true) {
            // Verifica si el coche no está actualmente en el estacionamiento
            if (!parking.existsCar(this)) {
                // Intenta entrar al estacionamiento
                if (entrar()) {
                    System.out.println("coche " + id + " aparcó en la plaza " + getPlaza().getN());
                    ThreadUtils.esperarSegundos(rand.nextInt(MIN_TIME_PARKED, MAX_TIME_PARKED));

                    // Sale del estacionamiento después de un tiempo aleatorio
                    salir();
                    System.out.println("coche " + id + " salió del parking.");

                    // Espera un tiempo aleatorio antes de intentar entrar nuevamente
                    ThreadUtils.esperarSegundos(rand.nextInt(MIN_TIME_OUT, MAX_TIME_OUT));
                } else {
                    System.out.println("coche " + id + " quiere aparcar, parking lleno.");
                }
            }
        }
    }

    /**
     * Obtiene la plaza actual del coche.
     *
     * @return La plaza actual del coche.
     */
    public Plaza getPlaza() {
        return parking.getPlazas().stream().filter(p -> p.getCar() == this).toList().get(0);
    }
}
