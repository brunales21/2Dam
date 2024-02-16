package ejs6_1;

import jakarta.persistence.*;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private int codigo;
    private String nombre;

    @Override
    public String toString() {
        return "ejs6_1.Categoria{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }


    public Categoria(String nombre) {
        setNombre(nombre);
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.isEmpty()) {
            this.nombre = nombre;
        } else {
            this.nombre = "default-name";
        }
    }
}
