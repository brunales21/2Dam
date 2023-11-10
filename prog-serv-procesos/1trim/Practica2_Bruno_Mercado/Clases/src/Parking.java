import java.util.ArrayList;
import java.util.List;

/**
 * @author Bruno Mercado
 *
 * Clase que representa un estacionamiento.
 */
public class Parking {
    private List<Plaza> plazas; // Lista de plazas en el estacionamiento
    private List<Car> colaCoches; // Cola de coches esperando para entrar
    private final int MAX_CAPACITY; // Capacidad máxima del estacionamiento

    /**
     * Constructor de la clase Parking.
     *
     * @param maxCap La capacidad máxima del estacionamiento.
     */
    public Parking(int maxCap) {
        this.MAX_CAPACITY = maxCap;
        this.plazas = new ArrayList<>();
        this.colaCoches = new ArrayList<>();
        initPlazas(); // Inicializa las plazas en el estacionamiento
    }

    /**
     * Metodo para "abrir" el parking.
     * Sus parametros son la cantidad de coches que van a entrar y salir.
     *
     *
     * @param maxCap La capacidad máxima del estacionamiento.
     */
    public void init(int cantCoches) {
        int offsetId = (int) new Thread().threadId();
        for (int i = 0; i < cantCoches; i++) {
            new Car(this, offsetId).start();
        }
    }

    /**
     * Inicializa las plazas en el estacionamiento.
     */
    public void initPlazas() {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            plazas.add(new Plaza(i));
        }
    }

    /**
     * Método para agregar un coche al estacionamiento de manera sincronizada.
     *
     * @param c El coche que se intenta agregar.
     * @return true si el coche se agregó con éxito, false si el estacionamiento está lleno.
     */
    public synchronized boolean addCar(Car c) {
        if (hayHueco()) {
            getNextPlazaLibre().setCar(c);
            return true;
        } else {
            try {
                colaCoches.add(c);
                wait();
            } catch (InterruptedException e) {
                // Maneja la interrupción de manera adecuada, por ejemplo, registrándola
                throw new RuntimeException(e);
            }
            return false;
        }
    }

    /**
     * Método para remover un coche del estacionamiento de manera sincronizada.
     *
     * @param c El coche que se va a remover.
     */
    public synchronized void removeCar(Car c) {
        Plaza plaza = getPlazaByCar(c);
        plaza.setCar(null);
        // Si hay cola de coches, que avise al primero que puede entrar al parking.
        if (!colaCoches.isEmpty()) {
            colaCoches.remove(0);
            notify();
        }
    }

    /**
     * Obtiene un coche por el número de plaza.
     *
     * @param n El número de la plaza.
     * @return El coche estacionado en la plaza.
     */
    public Car getCarByPlazaNum(int n) {
        return plazas.stream().filter(p -> p.getN() == n).toList().get(0).getCar();
    }

    /**
     * Obtiene la plaza ocupada por un coche.
     *
     * @param c El coche para el que se busca la plaza.
     * @return La plaza ocupada por el coche.
     */
    public Plaza getPlazaByCar(Car c) {
        return plazas.stream().filter(p -> p.getCar() == c).toList().get(0);
    }

    /**
     * Obtiene la próxima plaza libre en el estacionamiento.
     *
     * @return La próxima plaza libre en el estacionamiento.
     */
    public Plaza getNextPlazaLibre() {
        return plazas.stream().filter(p -> p.isLibre()).toList().get(0);
    }

    /**
     * Obtiene la lista de plazas en el estacionamiento.
     *
     * @return La lista de plazas en el estacionamiento.
     */
    public List<Plaza> getPlazas() {
        return plazas;
    }

    /**
     * Verifica si hay al menos una plaza libre en el estacionamiento.
     *
     * @return true si hay al menos una plaza libre, false si todas están ocupadas.
     */
    public boolean hayHueco() {
        for (Plaza plaza : plazas) {
            if (plaza.getCar() == null) {
                return true;
            }
        }
        return false;
    }

    /**
     * Obtiene la lista de plazas libres en el estacionamiento.
     *
     * @return La lista de plazas libres en el estacionamiento.
     */
    public List<Plaza> getPlazasLibres() {
        return plazas.stream().filter(p -> p.isLibre()).toList();
    }

    /**
     * Verifica si un coche existe en el estacionamiento.
     *
     * @param c El coche que se busca en el estacionamiento.
     * @return true si el coche está en el estacionamiento, false si no.
     */
    public boolean existsCar(Car c) {
        return plazas.stream().anyMatch(p -> p.getCar() == c);
    }
}
