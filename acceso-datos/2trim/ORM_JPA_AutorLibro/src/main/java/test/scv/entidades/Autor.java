package test.scv.entidades;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="AUTOR")
@NamedQuery(name = "Autor.buscarPorId", query = "select a from Autor a where a.id=:autId")
public class Autor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name="ID", nullable= false, unique=true, length=11)
    private Long id;
    @Column(name="NOMBRE" , length=20, nullable= true)
    private String nombre;
    @Column(name="APELLIDO" , length=20, nullable= true)
    private String apellido;
    @Column(name="FECHA_NAC", nullable= true)
    private LocalDate fechaNacimiento;
    @Column(name="ACTIVO" , nullable= false)
    private boolean activo;
    @OneToMany (mappedBy = "autor", cascade = CascadeType.ALL)
    @OrderBy ("titulo asc")
    private List<Libro> libros = new ArrayList<>() ;

    public Autor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del autor no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellidos) {
        if (apellidos == null || apellidos.trim().isEmpty()) {
            throw new IllegalArgumentException("El apellido del autor no puede ser nulo o vacío");
        }
        this.apellido = apellidos;
    }
    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fecha) {
        this.fechaNacimiento = fecha;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    public void addLibro(Libro libro) {
        this.libros.add(libro);
    }

    @Override
    public String toString() {
        return "Autor{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNacimiento=" + fechaNacimiento +
                ", activo=" + activo +
                ", libros=" + libros +
                '}';
    }
}
