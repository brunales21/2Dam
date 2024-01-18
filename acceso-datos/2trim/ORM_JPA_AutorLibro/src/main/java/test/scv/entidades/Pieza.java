package test.scv.entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "PIEZA")
public class Pieza {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pieza_sequence")
    @SequenceGenerator(name = "pieza_sequence", sequenceName = "PIEZA_SEQ", allocationSize = 1)
    @Column(name = "codigo")
    private int codigo;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "color")
    private String color;

    @Column(name = "precio")
    private int precio;

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public void setPrecio(int precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("Precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public void setColor(String color) {
        if (color == null || color.trim().isEmpty()) {
            throw new IllegalArgumentException("Color no puede ser nulo o vacío");
        }
        this.color = color;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return "Pieza{" +
                "codigo=" + codigo +
                ", nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                '}';
    }
}
