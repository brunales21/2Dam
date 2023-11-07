import java.util.Objects;
import java.util.Random;

public class Car extends Thread {
    private Parking parking;
    private Random rand;
    private final int offset = 30;
    private int id;
    private static final int MAX_TIME_PARKED = 8;
    private static final int MIN_TIME_PARKED = 6;
    private static final int MAX_TIME_OUT = 5;
    private static final int MIN_TIME_OUT = 3;
    public Car(Parking parking) {
        this.parking = parking;
        this.rand = new Random();
        this.id = (int) (threadId()-offset);

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
            if (!parking.existsCar(this)) {
                if (entrar()) {
                    System.out.println("coche "+id+" aparco en la plaza "+getPlaza().getN());
                    ThreadUtils.esperarSegundos(rand.nextInt(MIN_TIME_PARKED, MAX_TIME_PARKED));
                    salir();

                    System.out.println("coche "+id+" salio del parking.");
                    ThreadUtils.esperarSegundos(rand.nextInt(MIN_TIME_OUT, MAX_TIME_OUT));
                } else {
                    System.out.println("coche "+id+" quiere aparcar, parking lleno.");
                }
                System.out.println();

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
