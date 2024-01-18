package test.scv.orm_autorlibro;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import test.scv.entidades.Autor;

import java.util.List;

public class ConsultasCriteria {
    public static void main(String[] args) {
        consultaBasica();
    }

    public static void consultaBasica() {
        EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "default" );
        EntityManager entityManager = emfactory.createEntityManager();

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Autor> cq = cb.createQuery(Autor.class);
        Root<Autor> raiz = cq.from(Autor.class);

        cq.select(raiz);

        TypedQuery<Autor> query = entityManager.createQuery(cq);

        List<Autor> lista = query.getResultList();

        for( Autor a:lista ){
            System.out.println("Autor :" + a.getNombre() +
                    " " + a.getApellido());
        }

        /* Cerramos la sesión */
        entityManager.close();
        emfactory.close();
    }
}
