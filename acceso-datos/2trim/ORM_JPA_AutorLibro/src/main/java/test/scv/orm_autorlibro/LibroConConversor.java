package test.scv.orm_autorlibro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import test.scv.entidades.Autor;
import test.scv.entidades.Libro;

import java.time.LocalDate;

public class LibroConConversor {
    public static void main(String[] args) {
        Libro libro = new Libro() ;
        Autor autor;

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        Long id = (Long) entityManager.createNativeQuery("select ID from AUTOR where APELLIDO= 'Asturias';")
                .getSingleResult();
        autor = entityManager.find(Autor.class, id);

        libro.setAutor(autor);
        libro.setTitulo("El señor presidente");
        libro.setValoracion(Libro.Rating.EXCELENTE);

        autor.addLibro(libro);

        entityManager.persist(libro);
        entityManager.getTransaction().commit();

        entityManager.refresh(libro);
        System.out.println(libro);

        /* Cerramos la sesión */
        entityManager.close();
        entityManagerFactory.close();
    }
}
