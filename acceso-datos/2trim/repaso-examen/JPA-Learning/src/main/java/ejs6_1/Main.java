package ejs6_1;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main1(String[] args) {

        insertObject(new Categoria("pepe"));
        insertObject(new Categoria("pedro"));
        insertObject(new Categoria("pibe"));
        insertObject(new Categoria("pibe"));
        insertObject(new Categoria(null));




        insertObject(new Proveedor("abac", "54543543", "colme", "Madrid"));
        insertObject(new Proveedor("cba", "876985343", "colme", "Madrid"));
        insertObject(new Proveedor("ttyy", "2354654645", "colme", "Madrid"));
        insertObject(new Proveedor("tete", "42352562", "colme", "Madrid"));
        insertObject(new Proveedor("tete", "423acb52562", "colme", "Madrid"));


        Pieza pieza1 = new Pieza("Pieza1", "Rojo", 10);
        Pieza pieza2 = new Pieza("Pieza2", "Verde", 15);
        Pieza pieza3 = new Pieza("Pieza3", "Azul", 20);
        Pieza pieza4 = new Pieza("Pieza4", "Blanco", 25);
        Pieza pieza5 = new Pieza("Pieza5", "Negro", 30);
        Pieza pieza6 = new Pieza("Pieza6", "Amarillo", 35);
        Pieza pieza7 = new Pieza("Pieza7", "Gris", 40);
        Pieza pieza8 = new Pieza("Pieza7", "Gris", -10);


        insertObject(pieza1);
        insertObject(pieza2);
        insertObject(pieza3);
        insertObject(pieza4);
        insertObject(pieza5);
        insertObject(pieza6);
        insertObject(pieza7);
        insertObject(pieza8);
    }

    public static void main(String[] args) {
        //updateProveedor(1, "Merlo", "Buenos aires");
        deleteProveedor(2);
    }

    public static void insertObject(Object object) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        try {
            entityManager.persist(object);
            entityManager.getTransaction().commit();
        } catch (IllegalArgumentException e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void updateProveedor(int id, String ciudad, String provincia) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();

        Proveedor proveedor1 = entityManager.find(Proveedor.class, id);
        proveedor1.setCiudad(ciudad);
        proveedor1.setProvincia(provincia);

        entityManager.persist(proveedor1);

        entityManager.getTransaction().commit();
    }

    public static void deleteProveedor(int id) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        Proveedor proveedor = entityManager.find(Proveedor.class, id);
        entityManager.remove(proveedor);
        entityManager.getTransaction().commit();
    }

}
