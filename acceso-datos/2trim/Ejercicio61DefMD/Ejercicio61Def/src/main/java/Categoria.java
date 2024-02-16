import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    private String nombre;

    public Categoria() {

    }

    public Categoria(int codigo, String nombre) throws ValueException {
        setCodigo(codigo);
        setNombre(nombre);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return codigo == categoria.codigo && Objects.equals(nombre, categoria.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre);
    }
}
