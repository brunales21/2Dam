package entidades;

public class CategoriasProfEntidad {
    private String idCatProf;
    private Integer minSalario;
    private Integer maxSalario;

    public String getIdCatProf() {
        return idCatProf;
    }

    public void setIdCatProf(String idCatProf) {
        this.idCatProf = idCatProf;
    }

    public Integer getMinSalario() {
        return minSalario;
    }

    public void setMinSalario(Integer minSalario) {
        this.minSalario = minSalario;
    }

    public Integer getMaxSalario() {
        return maxSalario;
    }

    public void setMaxSalario(Integer maxSalario) {
        this.maxSalario = maxSalario;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CategoriasProfEntidad that = (CategoriasProfEntidad) o;

        if (idCatProf != null ? !idCatProf.equals(that.idCatProf) : that.idCatProf != null) return false;
        if (minSalario != null ? !minSalario.equals(that.minSalario) : that.minSalario != null) return false;
        if (maxSalario != null ? !maxSalario.equals(that.maxSalario) : that.maxSalario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idCatProf != null ? idCatProf.hashCode() : 0;
        result = 31 * result + (minSalario != null ? minSalario.hashCode() : 0);
        result = 31 * result + (maxSalario != null ? maxSalario.hashCode() : 0);
        return result;
    }
}
