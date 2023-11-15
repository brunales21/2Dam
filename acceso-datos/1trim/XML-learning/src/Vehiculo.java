public class Vehiculo {
    private String nombre;
    private int numero;
    private String tiempo;

    public Vehiculo(String nombre, int numero, String tiempo) {
        this.nombre = nombre;
        this.numero = numero;
        this.tiempo = tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getTiempo() {
        return tiempo;
    }

    public void setTiempo(String tiempo) {
        this.tiempo = tiempo;
    }

    @Override
    public String toString() {
        return  "\n\tnombre: " + nombre + "\n"+
                "\tnumero: " + numero + "\n"+
                "\ttiempo: " + tiempo ;
    }
}
