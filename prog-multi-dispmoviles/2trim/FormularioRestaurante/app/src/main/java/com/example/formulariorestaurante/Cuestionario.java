package com.example.formulariorestaurante;

public class Cuestionario {
    private int id;
    private String acercaDe;
    private String fecha;
    private int valoracion = 0;
    private String telefono;
    private String nombre;
    private String situacion;

    public Cuestionario(int id, String acercaDe, String fecha, int valoracion, String telefono, String nombre, String situacion) {
        setId(id);
        setAcercaDe(acercaDe);
        setFecha(fecha);
        setValoracion(valoracion);
        setTelefono(telefono);
        setNombre(nombre);
        setSituacion(situacion);
    }

    public Cuestionario() {
        // Constructor vacío, puedes establecer valores predeterminados aquí si es necesario
        setAcercaDe("DefaultAcercaDe");
        setFecha("DefaultFecha");
        setValoracion(0);  // Valoración predeterminada, puedes ajustarla según tus necesidades
        setTelefono("DefaultTelefono");
        setNombre("DefaultNombre");
        setSituacion("DefaultSituacion");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAcercaDe() {
        return acercaDe;
    }

    public void setAcercaDe(String acercaDe) {
        this.acercaDe = (acercaDe != null && !acercaDe.isEmpty()) ? acercaDe : "DefaultAcercaDe";
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = (fecha != null && !fecha.isEmpty()) ? fecha : "DefaultFecha";
    }

    public int getValoracion() {
        return valoracion;
    }

    public void setValoracion(int valoracion) {
        this.valoracion = valoracion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = (telefono != null && !telefono.isEmpty()) ? telefono : "DefaultTelefono";
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = (nombre != null && !nombre.isEmpty()) ? nombre : "DefaultNombre";
    }

    public String getSituacion() {
        return situacion;
    }

    public void setSituacion(String situacion) {
        this.situacion = (situacion != null && !situacion.isEmpty()) ? situacion : "DefaultSituacion";
    }
}
