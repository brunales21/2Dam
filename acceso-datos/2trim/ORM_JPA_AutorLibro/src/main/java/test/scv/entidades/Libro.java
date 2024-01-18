package test.scv.entidades;

import jakarta.persistence.*;
import test.scv.orm_autorlibro.ConversorTitulo;

import java.io.Serializable;

@Entity
@Table(name="LIBRO")
/*@Table(name="LIBRO",
        uniqueConstraints={ @UniqueConstraint(columnNames={ "ID"})})*/
public class Libro implements Serializable {
    private static final long serialVersionUID = 1L;

    public enum Rating {MUY_MALO, MALO, ACEPTABLE, BUENO, EXCELENTE};

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "TITULO")
    @Convert(converter = ConversorTitulo.class)
    private String titulo;

    @Column(name = "RATING", columnDefinition="varchar(9) default 'ACEPTABLE'")
    @Enumerated(EnumType.STRING)
    private Rating valoracion = Rating.ACEPTABLE;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTOR_ID")
    private Autor autor;

    public Libro() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("El título del libro no puede ser nulo o vacío");
        }
        this.titulo = titulo;
    }
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Rating getValoracion() {
        return valoracion;
    }

    public void setValoracion(Rating valoracion) {
        this.valoracion = valoracion;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", valoracion=" + valoracion +
                ", autor=" + autor +
                '}';
    }


}
