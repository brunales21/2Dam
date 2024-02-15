package entidades;

public class RegionesEntidad {
    private int idRegion;
    private String nombreRegion;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RegionesEntidad that = (RegionesEntidad) o;

        if (idRegion != that.idRegion) return false;
        if (nombreRegion != null ? !nombreRegion.equals(that.nombreRegion) : that.nombreRegion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idRegion;
        result = 31 * result + (nombreRegion != null ? nombreRegion.hashCode() : 0);
        return result;
    }
}
