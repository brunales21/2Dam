import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "PIEZA")
public class Pieza {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;
    private double precio;
    private String color;

    public Pieza() {

    }
    public Pieza(int codigo, String nombre, double precio, String color) throws ValueException {
        setCodigo(codigo);
        setNombre(nombre);
        setPrecio(precio);
        setColor(color);
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) throws ValueException {
        if (String.valueOf(codigo).length()==3){
            this.codigo=codigo;
        }else {
            throw new ValueException("El CODIGO debe contener 3 digitos");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) throws ValueException {
        if (nombre!=null&& !nombre.trim().isEmpty()) {
            StringBuffer name = new StringBuffer();
            name.append(nombre.substring(0, 1).toUpperCase());
            name.append(nombre.substring(1, nombre.length()).toLowerCase());
            this.nombre = String.valueOf(name);
        }else {
            throw new ValueException("Valor NOMBRE incorrecto");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) throws ValueException {
        if (precio<0 || precio>20000){
            throw new ValueException("Valor PRECIO incorrecto,compruebelo");
        }else {
            this.precio=precio;
        }
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) throws ValueException {
        if (color!=null&& !color.trim().isEmpty()) {
            StringBuffer name = new StringBuffer();
            name.append(color.substring(0, 1).toUpperCase());
            name.append(color.substring(1, color.length()).toLowerCase());
            this.color = String.valueOf(name);
        }else {
            throw new ValueException("Valor NOMBRE incorrecto");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pieza pieza = (Pieza) o;
        return codigo == pieza.codigo && Double.compare(precio, pieza.precio) == 0
                && Objects.equals(nombre, pieza.nombre) && Objects.equals(color, pieza.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, precio, color);
    }
}
