package entities;

public class PaisesEntity {
    private String idPais;
    private String nombrePais;
    private Integer idRegion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PaisesEntity that = (PaisesEntity) o;

        if (idPais != null ? !idPais.equals(that.idPais) : that.idPais != null) return false;
        if (nombrePais != null ? !nombrePais.equals(that.nombrePais) : that.nombrePais != null) return false;
        if (idRegion != null ? !idRegion.equals(that.idRegion) : that.idRegion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idPais != null ? idPais.hashCode() : 0;
        result = 31 * result + (nombrePais != null ? nombrePais.hashCode() : 0);
        result = 31 * result + (idRegion != null ? idRegion.hashCode() : 0);
        return result;
    }
}
