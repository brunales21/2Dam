package test.scv.orm_autorlibro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import test.scv.entidades.Autor;

import java.time.LocalDate;

public class AutorLibroUpdate {
    public static void main (String [] args){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        /* Cargamos el autor a modificar */
        Autor autor = entityManager.find(Autor.class, 2);

        autor.setActivo(false);

        entityManager.getTransaction().commit();

        entityManager.close();
        entityManagerFactory.close();
    }
}
