import jakarta.persistence.*;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private String codigo;
    private String nombre;

    @Override
    public String toString() {
        return "Categoria{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty() && codigo.matches("[A-Za-z0-9]+")) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código de la categoría no puede ser nulo, vacío o contener caracteres especiales.");
        }
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre de la categoría no puede ser nulo o vacío.");
        }
    }
}
