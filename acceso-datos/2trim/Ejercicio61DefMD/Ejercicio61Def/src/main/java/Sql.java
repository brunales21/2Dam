import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Sql {
    public static void main(String[] args) {

        crearCategoria(null);
        crearCategoria("Cristales");
        crearCategoria("Filtros");

        crearPieza("Bujia",20.50,"Negro");
        crearPieza("F.Aceite",9.95,"Azul");
        crearPieza("Michelin",80.40,"Negro");
        crearPieza("Frenos",13.95,"Gris");
        crearPieza("Inyector",25.67,"Negro");
        crearPieza("Bobina",35.32,"Negro");
        crearPieza("F.Aire",17.95,"Beige");
        crearPieza("",-2,null);


        crearProveedor("Volswagen","Sevilla","Sevilla","43435324");
        crearProveedor("BMW","Barcelona","Barcelona","43435324");
        crearProveedor("Audi","Lugo","Lugo","43435324");
        crearProveedor("","","","");

        actualizarProveerdor("moNcloa","LituaNIA");

        crearProveedor("Seat","monCLoa","MurciAA","123456789");
        eliminarProveedor("1");

    }

    public static void crearCategoria(String nombre){

        Categoria categoria = new Categoria();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        try {
            categoria.setNombre(nombre);
            entityManager.persist(categoria);
            entityManager.getTransaction().commit();

        } catch (ValueException e) {
            entityManager.getTransaction().rollback();

        }

        entityManager.close();
        entityManagerFactory.close();

    }

    public static void crearPieza(String nombre,double precio,String color){

        Pieza pieza = new Pieza();
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        try {
            pieza.setNombre(nombre);
            pieza.setPrecio(precio);
            pieza.setColor(color);
            entityManager.persist(pieza);
            entityManager.getTransaction().commit();

        } catch (ValueException e) {
            entityManager.getTransaction().rollback();

        }

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void crearProveedor(String nombre,String ciudad,String provincia,String telefono){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Proveedor proveedor = entityManager.find(Proveedor.class,1);

        entityManager.getTransaction().begin();
        try {
            proveedor.setNombre(nombre);
            proveedor.setCiudad(ciudad);
            proveedor.setProvincia(provincia);
            proveedor.setTelefono(telefono);
            entityManager.persist(proveedor);
            entityManager.getTransaction().commit();

        } catch (ValueException e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();
    }

    public static void actualizarProveerdor(String ciudad,String provincia){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Proveedor proveedor = entityManager.find(Proveedor.class,1);

        entityManager.getTransaction().begin();
        try {
            proveedor.setCiudad(ciudad);
            proveedor.setProvincia(provincia);
            entityManager.persist(proveedor);
            entityManager.getTransaction().commit();

        } catch (ValueException e) {
            entityManager.getTransaction().rollback();
        }

        entityManager.close();
        entityManagerFactory.close();

    }

    public static void eliminarProveedor(String codigo){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("default");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        Proveedor proveedor = entityManager.find(Proveedor.class,codigo);
        entityManager.getTransaction().begin();
        entityManager.remove(proveedor);
        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();

    }
}
