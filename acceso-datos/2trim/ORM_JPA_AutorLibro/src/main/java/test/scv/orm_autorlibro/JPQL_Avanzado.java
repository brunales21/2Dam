package test.scv.orm_autorlibro;

import jakarta.persistence.*;
import test.scv.entidades.Autor;
import test.scv.entidades.Libro;

import java.util.List;

public class JPQL_Avanzado {
    public static void main(String[] args) {
//        consultasNavegarParametros();
//        consultasColecciones();
//        consultasConNombre();
//        consultasUpdate();
        consultasDelete();
    }

    public static void consultasNavegarParametros() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entityManager = emfactory.createEntityManager();

        //Typed Query
        TypedQuery<String> query = entityManager.createQuery("Select l.autor.nombre from Libro l " +
                "where l.titulo like ?1", String.class);
        query.setParameter(1, "The%");

        List<String> list = query.getResultList( );

        for( String n:list ){
            System.out.println("Autor :" + n);
        }

        /* Cerramos la sesión */
        entityManager.close();
        emfactory.close();
    }

    public static void consultasColecciones() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entityManager = emfactory.createEntityManager();

        //Typed Query
        TypedQuery<Integer> query = entityManager.createQuery("Select size(a.libros) from Autor a " +
                "where a.id = ?1", Integer.class);
        query.setParameter(1, 2);

        Integer nLibros = query.getSingleResult();

        System.out.println("Num libros:" + nLibros);


        System.out.println("\n\n---------------\n\n");

        TypedQuery<Autor> query2 = entityManager.createQuery("Select a from Autor a " +
                "where a.libros is empty ", Autor.class);

        List<Autor> list = query2.getResultList( );

        for( Autor a:list ){
            System.out.println("Autor :" + a.getNombre() +
                    " " + a.getApellido());
        }

        /* Cerramos la sesión */
        entityManager.close();
        emfactory.close();
    }

    public static void consultasConNombre() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entityManager = emfactory.createEntityManager();

        //Typed Query
        TypedQuery<Autor> query = entityManager.createNamedQuery("Autor.buscarPorId", Autor.class);
        query.setParameter("autId", 2);

        Autor autor = query.getSingleResult();

        System.out.println("Autor: " + autor.getNombre() +
                " " + autor.getApellido());

        /* Cerramos la sesión */
        entityManager.close();
        emfactory.close();
    }

    public static void consultasUpdate() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entityManager = emfactory.createEntityManager();

        /* Iniciamos la transacción */
        entityManager.getTransaction().begin();

        // Update
        Query query = entityManager.createQuery(
                "update Autor a set a.activo =:nuevoAct where a.id = :autId");
        query.setParameter("nuevoAct", true);
        query.setParameter("autId", 2);
        int resultado = query.executeUpdate();

        System.out.println("Filas afectadas: " + resultado);

        entityManager.getTransaction().commit();

        /* Cerramos la sesión */
        entityManager.close();
        emfactory.close();
    }

    public static void consultasDelete() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entityManager = emfactory.createEntityManager();

        /* Iniciamos la transacción */
        entityManager.getTransaction().begin();

        // Update
        Query query = entityManager.createQuery(
                "delete Libro l where l.id = :libId");
        query.setParameter("libId", 2);
        int resultado = query.executeUpdate();

        System.out.println("Filas afectadas: " + resultado);

        // lo deshago para no alterar la BdD
        entityManager.getTransaction().rollback();
        entityManager.getTransaction().commit();

        /* Cerramos la sesión */
        entityManager.close();
        emfactory.close();
    }
}
