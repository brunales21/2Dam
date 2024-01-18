package test.scv.orm_autorlibro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import test.scv.entidades.Proveedor;
import test.scv.hibernateUtil.HibernateUtil;

public class Main2 {
    public static void main(String[] args) {
        if (eliminarProveedor(1)) {
            System.out.println("Borrado exitoso.");
        } else {
            System.out.println("El borrado no se pudo realizar.");
        }
    }

    private static Proveedor obtenerProveedorPorId(int id) throws ProveedorNoEncontradoException {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Proveedor proveedor = session.get(Proveedor.class, id);
            if (proveedor == null) {
                throw new ProveedorNoEncontradoException(id);
            }
            return proveedor;
        }
    }


    private static boolean eliminarProveedor(int id) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(obtenerProveedorPorId(id));
            transaction.commit();
        } catch (ProveedorNoEncontradoException e) {
            return false;
        }
        return true;
    }
}
