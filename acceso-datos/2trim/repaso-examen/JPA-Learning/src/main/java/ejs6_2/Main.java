package ejs6_2;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default2");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        LocalizacionEntity localizacionEntity = new LocalizacionEntity("calle37", "Madrid", "28270");
        entityManager.persist(localizacionEntity);
        entityManager.getTransaction().commit();

    }
}
