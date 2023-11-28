package xmlSim;

public class Cantidad {
    private String n;

    public Cantidad(String n) {
        this.n = n;
    }

    public Cantidad() {
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return String.valueOf(n);
    }
}
