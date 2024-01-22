package entidades;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "regiones", schema = "empleados", catalog = "")
public class RegionesEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id_region")
    private int idRegion;
    @Basic
    @Column(name = "nombre_region")
    private String nombreRegion;

    // Relación OneToMany con PaisesEntity
    @OneToMany(mappedBy = "region")
    private List<PaisesEntity> paises;

    public int getIdRegion() {
        return idRegion;
    }

    public void setIdRegion(int idRegion) {
        this.idRegion = idRegion;
    }

    public String getNombreRegion() {
        return nombreRegion;
    }

    public void setNombreRegion(String nombreRegion) {
        this.nombreRegion = nombreRegion;
    }

    public List<PaisesEntity> getPaises() {
        return paises;
    }

    public void setPaises(List<PaisesEntity> paises) {
        this.paises = paises;
    }

    // Otros métodos y equals/hashCode...
}
