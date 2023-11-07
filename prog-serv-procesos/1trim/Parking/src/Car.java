import java.util.Objects;
import java.util.Random;

public class Car extends Thread {
    private Parking parking;
    private Random rand;
    private static final int MAX_TIME_PARKED = 10;
    private static final int MIN_TIME_PARKED = 3;

    public Car(Parking parking) {
        this.parking = parking;
        this.rand = new Random();

    }

    public boolean entrar() {
        return parking.addCar(this);
    }

    public void salir() {
        parking.removeCar(this);
    }

    @Override
    public void run() {
        while (true) {
            int r = rand.nextInt(MIN_TIME_PARKED, MAX_TIME_PARKED);
            if (!entrar()) {
                System.out.println("Coche "+threadId()+" esperando en la cola.");
            } else {
                System.out.println("Coche "+threadId()+" aparco en "+getPlaza().getN());
                ThreadUtils.esperarSegundos(r);
                salir();
                int r2 = rand.nextInt(2, 7);
                ThreadUtils.esperarSegundos(r2);
            }

        }
    }

    public Plaza getPlaza() {
        return parking.getPlazas().stream().filter(p -> p.getCar() == this).toList().get(0);
    }

    public Random getRand() {
        return rand;
    }

    public void setRand(Random rand) {
        this.rand = rand;
    }

}
