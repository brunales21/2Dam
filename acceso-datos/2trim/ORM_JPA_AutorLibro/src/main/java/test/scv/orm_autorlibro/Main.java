package test.scv.orm_autorlibro;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import test.scv.entidades.Categoria;
import test.scv.entidades.Pieza;
import test.scv.entidades.Proveedor;
import test.scv.hibernateUtil.HibernateUtil;

public class Main {
    public static void main(String[] args) {
        try {
            // Crear instancias de Categorias
            Categoria categoria1 = new Categoria();
            categoria1.setNombre("Electrónica");

            Categoria categoria2 = new Categoria();
            categoria2.setNombre("Ropa");

            Categoria categoria3 = new Categoria();
            categoria3.setNombre("Hogar");

            // Crear instancias de Proveedores
            Proveedor proveedor1 = new Proveedor();
            proveedor1.setNombre("Proveedor1");
            proveedor1.setCiudad("Ciudad1");
            proveedor1.setProvincia("Provincia1");
            proveedor1.setTelefono("123456789");

            Proveedor proveedor2 = new Proveedor();
            proveedor2.setNombre("Proveedor2");
            proveedor2.setCiudad("Ciudad2");
            proveedor2.setProvincia("Provincia2");
            proveedor2.setTelefono("987654321");

            Proveedor proveedor3 = new Proveedor();
            proveedor3.setNombre("Proveedor3");
            proveedor3.setCiudad("Ciudad3");
            proveedor3.setProvincia("Provincia3");
            proveedor3.setTelefono("111223344");

            Proveedor proveedor4 = new Proveedor();
            proveedor4.setNombre("Proveedor4");
            proveedor4.setCiudad("Ciudad4");
            proveedor4.setProvincia("Provincia4");
            proveedor4.setTelefono("555666777");

            // Crear instancias de Piezas
            Pieza pieza1 = new Pieza();
            pieza1.setNombre("Placa Base");
            pieza1.setColor("Rojo");
            pieza1.setPrecio(50);

            Pieza pieza2 = new Pieza();
            pieza2.setNombre("Tarjeta de Video");
            pieza2.setColor("Verde");
            pieza2.setPrecio(200);

            Pieza pieza3 = new Pieza();
            pieza3.setNombre("Memoria RAM");
            pieza3.setColor("Azul");
            pieza3.setPrecio(80);

            Pieza pieza4 = new Pieza();
            pieza4.setNombre("Disco Duro");
            pieza4.setColor("Negro");
            pieza4.setPrecio(-10);  // Esto generará una excepción

            Pieza pieza5 = new Pieza();
            pieza5.setNombre("Teclado");
            pieza5.setColor(null);  // Esto generará una excepción

            Pieza pieza6 = new Pieza();
            pieza6.setNombre("Mouse");
            pieza6.setColor("Blanco");
            pieza6.setPrecio(30);

            Pieza pieza7 = new Pieza();
            pieza7.setNombre("");  // Esto generará una excepción
            pieza7.setColor("Gris");
            pieza7.setPrecio(15);

            // Intentar guardar las entidades
            guardarCategoria(categoria1);
            guardarCategoria(categoria2);
            guardarCategoria(categoria3);

            guardarProveedor(proveedor1);
            guardarProveedor(proveedor2);
            guardarProveedor(proveedor3);
            guardarProveedor(proveedor4);

            guardarPieza(pieza1);
            guardarPieza(pieza2);
            guardarPieza(pieza3);
            guardarPieza(pieza4);
            guardarPieza(pieza5);
            guardarPieza(pieza6);
            guardarPieza(pieza7);

        } catch (IllegalArgumentException e) {
            // Manejar la excepción aquí (imprimir un mensaje, registrarla, etc.)
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static void guardarProveedor(Proveedor proveedor) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(proveedor);
            transaction.commit();
        }
    }

    private static void guardarCategoria(Categoria categoria) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(categoria);
            transaction.commit();
        }
    }

    private static void guardarPieza(Pieza pieza) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(pieza);
            transaction.commit();
        }
    }
}
