package test.scv.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "proveedor_sequence")
    @SequenceGenerator(name = "proveedor_sequence", sequenceName = "PROVEEDOR_SEQ", allocationSize = 1)
    private int codigo;

    @Column(name = "NOMBRE_PERSONA")
    private String nombre;

    @Column(name = "CIUDAD")
    private String ciudad;

    @Column(name = "PROVINCIA")
    private String provincia;

    @Column(name = "TELEFONO")
    private String telefono;


    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public void setCiudad(String ciudad) {
        if (ciudad == null || ciudad.trim().isEmpty()) {
            throw new IllegalArgumentException("Ciudad no puede ser nulo o vacío");
        }
        this.ciudad = ciudad;
    }

    public void setProvincia(String provincia) {
        if (provincia == null || provincia.trim().isEmpty()) {
            throw new IllegalArgumentException("Provincia no puede ser nulo o vacío");
        }
        this.provincia = provincia;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || !telefono.matches("\\d{9}")) {
            throw new IllegalArgumentException("Telefono no es válido");
        }
        this.telefono = telefono;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
