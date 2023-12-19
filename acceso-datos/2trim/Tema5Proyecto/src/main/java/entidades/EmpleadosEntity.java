package entidades;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class EmpleadosEntity {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private Date fechaContratacion;
    private String idTrabajo;
    private BigDecimal salario;
    private BigDecimal comision;
    private Integer idDirector;
    private Integer idDepartamento;

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getIdTrabajo() {
        return idTrabajo;
    }

    public void setIdTrabajo(String idTrabajo) {
        this.idTrabajo = idTrabajo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public BigDecimal getComision() {
        return comision;
    }

    public void setComision(BigDecimal comision) {
        this.comision = comision;
    }

    public Integer getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(Integer idDirector) {
        this.idDirector = idDirector;
    }

    public Integer getIdDepartamento() {
        return idDepartamento;
    }

    public void setIdDepartamento(Integer idDepartamento) {
        this.idDepartamento = idDepartamento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmpleadosEntity that = (EmpleadosEntity) o;
        return idEmpleado == that.idEmpleado && Objects.equals(nombre, that.nombre) && Objects.equals(apellido, that.apellido) && Objects.equals(email, that.email) && Objects.equals(telefono, that.telefono) && Objects.equals(fechaContratacion, that.fechaContratacion) && Objects.equals(idTrabajo, that.idTrabajo) && Objects.equals(salario, that.salario) && Objects.equals(comision, that.comision) && Objects.equals(idDirector, that.idDirector) && Objects.equals(idDepartamento, that.idDepartamento);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idEmpleado, nombre, apellido, email, telefono, fechaContratacion, idTrabajo, salario, comision, idDirector, idDepartamento);
    }
}
