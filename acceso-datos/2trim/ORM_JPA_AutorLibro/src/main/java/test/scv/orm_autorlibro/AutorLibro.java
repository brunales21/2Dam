package test.scv.orm_autorlibro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

import test.scv.entidades.Autor;

public class AutorLibro {
    public static void main (String [] args){
        Autor autor = new Autor() ;

        /* Obtenemos una sesión */
        /* El parámetro es el dato en persistence.xml en <persistence-unit name="default">
        * Podría haber más de uno con nombres diferentes. */
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        /* Iniciamos la transacción */
        entityManager.getTransaction().begin();

        /* Añadimos los datos y los guardamos */
        autor.setNombre("Miguel Ángel");
        autor.setApellido("Asturias");
        autor.setFechaNacimiento(LocalDate.of(1899, 10, 19));
        autor.setActivo(false);

        entityManager.persist(autor);
        entityManager.getTransaction().commit();

        /* Cerramos la sesión */
        entityManager.close();
        entityManagerFactory.close();
    }
}
