import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Pieza {
    private String nombre;
    private String color;
    private int precio;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private String codigo;

    @Override
    public String toString() {
        return "Pieza{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre de la pieza no puede ser nulo o vacío.");
        }
    }

    public void setColor(String color) {
        // Agrega comprobaciones adicionales según tus requisitos
        if (color != null && !color.isEmpty()) {
            this.color = color;
        } else {
            throw new IllegalArgumentException("El color no puede ser nulo o vacío.");
        }
    }

    public void setPrecio(int precio) {
        if (precio >= 0) {
            this.precio = precio;
        } else {
            throw new IllegalArgumentException("El precio de la pieza no puede ser negativo.");
        }
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty() && codigo.matches("[A-Za-z0-9]+")) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código de la pieza no puede ser nulo, vacío o contener caracteres especiales.");
        }
    }
}
