package ejs6_2;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="localizacion")
public class LocalizacionEntity {
    private String direccion;
    private String ciudad;
    private String codigoPostal;

    public LocalizacionEntity(String direccion, String ciudad, String codigoPostal) {
        setDireccion(direccion);
        setCiudad(ciudad);
        setCodigoPostal(codigoPostal);
    }

    public LocalizacionEntity() {
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }
}
