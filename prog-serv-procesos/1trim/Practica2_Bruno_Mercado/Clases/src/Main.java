public class Main {
    public static void main(String[] args) {
        int numeroPlazas = 7;
        int numeroDeCoches = 10;
        Parking parking = new Parking(numeroPlazas);
        parking.init(numeroDeCoches);
    }
}