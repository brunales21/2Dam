package entidades;

import java.util.Objects;

public class DepartamentosEntity {
    private int idDepartamento;
    private String nombreDepartamento;
    private Integer idDirector;
    private Integer idLocalizacion;

    public int getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(int idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    public String getNombreDepartamento() {
        return nombreDepartamento;
    }

    public void setNombreDepartamento(String nombreDepartamento) {
        this.nombreDepartamento = nombreDepartamento;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Integer getIdLocalizacion() {
        return idLocalizacion;
    }

    public void setIdLocalizacion(Integer idLocalizacion) {
        this.idLocalizacion = idLocalizacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DepartamentosEntity that = (DepartamentosEntity) o;
        return idDepartamento == that.idDepartamento && Objects.equals(nombreDepartamento, that.nombreDepartamento) && Objects.equals(idDirector, that.idDirector) && Objects.equals(idLocalizacion, that.idLocalizacion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDepartamento, nombreDepartamento, idDirector, idLocalizacion);
    }
}
