/**
 * @author Bruno Mercado
 *
 * Clase que representa una plaza en el estacionamiento.
 */
public class Plaza {
    private int n; // Número de la plaza
    private Car car; // Coche estacionado en la plaza

    /**
     * Constructor de la clase Plaza.
     *
     * @param n Número de la plaza.
     */
    public Plaza(int n) {
        this.n = n;
    }

    /**
     * Obtiene el coche estacionado en la plaza.
     *
     * @return El coche estacionado en la plaza, o null si la plaza está libre.
     */
    public Car getCar() {
        return car;
    }

    /**
     * Establece el coche estacionado en la plaza.
     *
     * @param car El coche que se va a estacionar en la plaza.
     */
    public void setCar(Car car) {
        this.car = car;
    }

    /**
     * Verifica si la plaza está libre.
     *
     * @return true si la plaza está libre, false si está ocupada.
     */
    public boolean isLibre() {
        return car == null;
    }

    /**
     * Obtiene el número de la plaza.
     *
     * @return El número de la plaza.
     */
    public int getN() {
        return n;
    }
}
