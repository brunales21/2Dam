package ejs6_1;

import jakarta.persistence.*;

@Entity
@Table(name="ejs6_1.Pieza")
public class Pieza {
    private String nombre;
    private String color;
    private int precio;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name="id")
    private int codigo;

    @Override
    public String toString() {
        return "ejs6_1.Pieza{" +
                "nombre='" + nombre + '\'' +
                ", color='" + color + '\'' +
                ", precio=" + precio +
                ", codigo='" + codigo + '\'' +
                '}';
    }

    public Pieza(String nombre, String color, int precio) {
        setNombre(nombre);
        setColor(color);
        setPrecio(precio);
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
            this.precio = 1;
        }
    }

}
