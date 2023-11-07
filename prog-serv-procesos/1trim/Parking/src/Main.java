public class Main {
    public static void main(String[] args) {
        Parking parking = new Parking();
        for (int i = 0; i < 10; i++) {
            new Car(parking).start();
        }
    }
}