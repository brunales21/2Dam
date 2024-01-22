package entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "paises", schema = "empleados", catalog = "")
public class PaisesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_pais")
    private String idPais;
    @Basic
    @Column(name = "nombre_pais")
    private String nombrePais;
    @Basic
    @Column(name = "id_region")
    private Integer idRegion;

    // Relación ManyToOne con RegionesEntity
    @ManyToOne
    @JoinColumn(name = "id_region", referencedColumnName = "id_region", insertable = false, updatable = false)
    private RegionesEntity region;

    // Relación OneToMany con LocalizacionesEntity
    @OneToMany(mappedBy = "pais")
    private List<LocalizacionesEntity> localizaciones;

    public String getIdPais() {
        return idPais;
    }

    public void setIdPais(String idPais) {
        this.idPais = idPais;
    }

    public String getNombrePais() {
        return nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }

    public Integer getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(Integer idRegion) {
        this.idRegion = idRegion;
    }

    public RegionesEntity getRegion() {
        return region;
    }

    public void setRegion(RegionesEntity region) {
        this.region = region;
    }

    public List<LocalizacionesEntity> getLocalizaciones() {
        return localizaciones;
    }

    public void setLocalizaciones(List<LocalizacionesEntity> localizaciones) {
        this.localizaciones = localizaciones;
    }

    @Override
    public String toString() {
        return "PaisesEntity{" +
                "idPais='" + idPais + '\'' +
                ", nombrePais='" + nombrePais + '\'' +
                ", idRegion=" + idRegion +
                ", region=" + region +
                ", localizaciones=" + localizaciones +
                '}';
    }

}
