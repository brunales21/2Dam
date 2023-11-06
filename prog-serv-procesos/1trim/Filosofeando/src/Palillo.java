public class Palillo {
    private boolean disponible;
    private int id;

    public Palillo(boolean disponible) {
        this.disponible = disponible;
    }

    public Palillo() {
        this(true);
    }

    public boolean isDisponible() {
        return disponible;
    }

    public synchronized void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
