import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Proveedor {
    @Column(name="name")
    private String nombre;
    @Column(name="phone_number")
    private String telefono;
    @Column(name="province")
    private String provincia;
    @Column(name="city")
    private String ciudad;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private String codigo;

    @Override
    public String toString() {
        return "Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new IllegalArgumentException("El nombre del proveedor no puede ser nulo o vacío.");
        }
    }

    public void setTelefono(String telefono) {
        // Agrega comprobaciones adicionales según tus requisitos
        if (telefono != null && telefono.matches("[0-9]+")) {
            this.telefono = telefono;
        } else {
            throw new IllegalArgumentException("El número de teléfono debe contener solo dígitos.");
        }
    }

    public void setProvincia(String provincia) {
        // Agrega comprobaciones adicionales según tus requisitos
        if (provincia != null && !provincia.isEmpty()) {
            this.provincia = provincia;
        } else {
            throw new IllegalArgumentException("La provincia no puede ser nula o vacía.");
        }
    }

    public void setCiudad(String ciudad) {
        // Agrega comprobaciones adicionales según tus requisitos
        if (ciudad != null && !ciudad.isEmpty()) {
            this.ciudad = ciudad;
        } else {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía.");
        }
    }

    public void setCodigo(String codigo) {
        if (codigo != null && !codigo.isEmpty() && codigo.matches("[A-Za-z0-9]+")) {
            this.codigo = codigo;
        } else {
            throw new IllegalArgumentException("El código del proveedor no puede ser nulo, vacío o contener caracteres especiales.");
        }
    }
}
