public class Plaza {
    private int n;
    private Car car;

    public Plaza(int n) {
        this.n = n;
    }

    public Plaza(int n, Car c) {
        this.n = n;
        this.car = c;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public boolean isLibre() {
        return car == null;
    }

    public int getN() {
        return n;
    }
}
