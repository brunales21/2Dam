import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        Categoria categoria = new Categoria();
        entityManager.getTransaction().begin();

        categoria.setNombre("Barco");
        entityManager.persist(categoria);
        entityManager.getTransaction().commit();
    }
}
