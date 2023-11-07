import java.util.ArrayList;
import java.util.List;

public class Parking {
    private List<Plaza> plazas;
    private List<Car> colaCoches;
    private int currentCars;
    private static final int MAX_CAPACITY = 30;

    public Parking() {
        this.plazas = new ArrayList<>();
        this.colaCoches = new ArrayList<>();
        initPlazas();
    }

    public void initPlazas() {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            plazas.add(new Plaza(i));
        }
    }

    public boolean addCar(Car c) {
        if (!estaLleno()) {
            getNextPlazaLibre().setCar(c);
            return true;
        } else {
            colaCoches.add(c);
            return false;
        }
    }

    public synchronized void removeCar(Car c) {
        Plaza plaza = plazas.stream().filter(p -> p.getCar() == c).toList().get(0);
        plaza.setCar(null);
        if (!colaCoches.isEmpty()) {
            addCar(colaCoches.remove(0));
        }
    }

    public Car getCarByPlazaNum(int n) {
        return plazas.stream().filter(p->p.getN() == n).toList().get(0).getCar();
    }

    public Plaza getNextPlazaLibre() {
        return plazas.stream().filter(p -> p.isLibre()).toList().get(0);
    }

    public List<Plaza> getPlazas() {
        return plazas;
    }

    public int getCurrentCars() {
        return currentCars;
    }

    public void setCurrentCars(int currentCars) {
        this.currentCars = currentCars;
    }

    public boolean estaLleno() {
        for (Plaza plaza : plazas) {
            if (plaza.getCar() == null) {
                return false;
            }
        }
        return true;
    }

    public List<Plaza> getPlazasLibres() {
        return plazas.stream().filter(p -> p.isLibre()).toList();
    }
}
