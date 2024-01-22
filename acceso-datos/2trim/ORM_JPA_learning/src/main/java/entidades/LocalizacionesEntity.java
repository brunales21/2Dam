package entidades;

import jakarta.persistence.*;

@Entity
@Table(name = "localizaciones", schema = "empleados", catalog = "")
public class LocalizacionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_localizacion")
    private int idLocalizacion;
    @Basic
    @Column(name = "direccion")
    private String direccion;
    @Basic
    @Column(name = "codigo_postal")
    private String codigoPostal;
    @Basic
    @Column(name = "ciudad")
    private String ciudad;
    @Basic
    @Column(name = "provincia")
    private String provincia;
    @Basic
    @Column(name = "id_pais")
    private String idPais;

    // Relación ManyToOne con PaisesEntity
    @ManyToOne
    @JoinColumn(name = "id_pais", referencedColumnName = "id_pais", insertable = false, updatable = false)
    private PaisesEntity pais;

    public int getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(int idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }

    public void setCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public PaisesEntity getPais() {
        return pais;
    }

    public void setPais(PaisesEntity pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {
        return "LocalizacionesEntity{" +
                "idLocalizacion=" + idLocalizacion +
                ", direccion='" + direccion + '\'' +
                ", codigoPostal='" + codigoPostal + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", idPais='" + idPais + '\'' +
                ", pais=" + pais +
                '}';
    }
}
