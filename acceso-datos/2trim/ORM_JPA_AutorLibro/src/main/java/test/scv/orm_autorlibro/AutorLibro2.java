package test.scv.orm_autorlibro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import test.scv.entidades.Autor;

import java.time.LocalDate;

public class AutorLibro2 {
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
        autor.setNombre("Paul");
        autor.setApellido("Auster");
        autor.setFechaNacimiento(LocalDate.of(1947, 2, 3));
        autor.setActivo(true);

        entityManager.persist(autor);
        entityManager.getTransaction().commit();

        /* Cerramos la sesión */
        entityManager.close();
        entityManagerFactory.close();
    }
}
