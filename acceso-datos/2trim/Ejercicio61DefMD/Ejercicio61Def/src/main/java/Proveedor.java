import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "PROVEEDOR")
public class Proveedor {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int codigo;
    @Column(name = "Name",length = 40,nullable = false)
    private String nombre;
    @Column (name = "City",length = 40,nullable = false)
    private String ciudad;
    @Column (name = "Province",length = 40,nullable = false)
    private String provincia;
    @Column (name = "Telefono",length = 40,nullable = false)
    private String telefono;

    public Proveedor() {

    }
    public Proveedor(String nombre, String ciudad, String provincia, String telefono) throws ValueException {
        setNombre(nombre);
        setCiudad(ciudad);
        setProvincia(provincia);
        setTelefono(telefono);
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
        if (!nombre.trim().isEmpty()) {
            StringBuffer name = new StringBuffer();
            name.append(nombre.substring(0, 1).toUpperCase());
            name.append(nombre.substring(1, nombre.length()).toLowerCase());
            this.nombre = String.valueOf(name);
        }else {
            throw new ValueException("Valor NOMBRE incorrecto");
        }
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) throws ValueException {
        if (!ciudad.trim().isEmpty()) {
            StringBuffer name = new StringBuffer();
            name.append(ciudad.substring(0, 1).toUpperCase());
            name.append(ciudad.substring(1, ciudad.length()).toLowerCase());
            this.ciudad = String.valueOf(name);
        }else {
            throw new ValueException("Valor NOMBRE incorrecto");
        }
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) throws ValueException {
        if (!provincia.trim().isEmpty()) {
            StringBuffer name = new StringBuffer();
            name.append(provincia.substring(0, 1).toUpperCase());
            name.append(provincia.substring(1, provincia.length()).toLowerCase());
            this.provincia = String.valueOf(name);
        }else {
            throw new ValueException("Valor NOMBRE incorrecto");
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) throws ValueException {
        String number = "0123456789";
        boolean isNumber=true;
        for (int i = 0; i < telefono.length(); i++) {
            String character = String.valueOf(telefono.charAt(i));
            if (!number.contains(character)){
              isNumber=false;
              break;
            }
        }
        if (isNumber&&telefono.length()==9){
            this.telefono=telefono;
        }else {
            throw new ValueException("Numero de telefono incorrecto, compruebelo");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return codigo == proveedor.codigo && Objects.equals(nombre, proveedor.nombre) && Objects.equals(ciudad, proveedor.ciudad) && Objects.equals(provincia, proveedor.provincia) && Objects.equals(telefono, proveedor.telefono);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo, nombre, ciudad, provincia, telefono);
    }
}




