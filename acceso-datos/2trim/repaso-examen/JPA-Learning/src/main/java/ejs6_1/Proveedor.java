package ejs6_1;

import jakarta.persistence.*;

@Entity
@Table(name="ejs6_1.Proveedor")
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
    private int codigo;

    @Override
    public String toString() {
        return "ejs6_1.Proveedor{" +
                "nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", provincia='" + provincia + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public Proveedor() {
    }

    public Proveedor(String nombre, String telefono, String provincia, String ciudad) {
        setNombre(nombre);
        setTelefono(telefono);
        setProvincia(provincia);
        setCiudad(ciudad);
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
            this.telefono = "0";
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

}
