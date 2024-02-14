import entidades.DepartamentosEntidad;
import entidades.EmpleadosEntidad;
import entidades.LocalizacionesEntidad;
import entidades.RegionesEntidad;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.math.BigDecimal;
import java.sql.Array;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main1(String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session session = sf.openSession();
        try {
            session.beginTransaction();
            LocalizacionesEntidad l = new LocalizacionesEntidad();
            l.setCiudad("Madrid");
            l.setDireccion("Colmenarejo");
            session.persist(l);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main2(String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session session = sf.openSession();
        try {
            session.beginTransaction();

            DepartamentosEntidad d = new DepartamentosEntidad();
            d.setNombreDepartamento("Departamento los tontos");
            d.setIdLocalizacion(0);
            d.setIdDirector(100);
            d.setIdDepartamento(99);

            session.persist(d);
            session.getTransaction().commit();
        } catch (Exception ex) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    public static void main3(String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session s = sf.openSession();

        s.beginTransaction();

        EmpleadosEntidad e = new EmpleadosEntidad();
        EmpleadosEntidad e2 = new EmpleadosEntidad();
        EmpleadosEntidad e3 = new EmpleadosEntidad();
        EmpleadosEntidad e4 = new EmpleadosEntidad();
        EmpleadosEntidad e5 = new EmpleadosEntidad();

        e.setNombre("pepe");
        e.setIdEmpleado(1000);
        e2.setNombre("pedro");
        e2.setIdEmpleado(1001);
        e3.setNombre("papanatas");
        e3.setIdEmpleado(1002);
        e4.setNombre("Eugenio");
        e4.setIdEmpleado(1003);
        e5.setNombre("miguel");
        e5.setIdEmpleado(1004);

        e.setIdDepartamento(99);
        e2.setIdDepartamento(99);
        e3.setIdDepartamento(99);
        e4.setIdDepartamento(99);
        e5.setIdDepartamento(99);

        persistAll(s, Arrays.asList(e, e2, e3, e4, e5));

        s.getTransaction().commit();
    }

    public static void persistAll(Session s, List<Object> list) {
        list.forEach(s::persist);
    }

    public static void main4(String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session s = sf.openSession();

        try {
            s.getTransaction().begin();
            EmpleadosEntidad e = new EmpleadosEntidad();
            e.setNombre("empleado fantasma");
            s.persist(e);
            s.getTransaction().commit();
        } catch (Exception e) {
            if (s.getTransaction() != null) {
                s.getTransaction().rollback();
                System.out.println("no se comiteo una mierda");
            }

        } finally {
            s.close();
        }
    }

    public static void main5(String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session s = sf.openSession();
        try {
            int idAModificar = 301;
            EmpleadosEntidad e = s.get(EmpleadosEntidad.class, idAModificar);
            s.getTransaction().begin();
            e.setComision(new BigDecimal(0.1));
            e.setComision(e.getComision().multiply(new BigDecimal(1.05)));
            s.persist(e);
            s.getTransaction().commit();
        } catch (Exception e) {
            if (s.getTransaction() == null) {
                s.getTransaction().rollback();
                System.out.println("ROLEO BACH");
            }
        } finally {
            s.close();
        }
    }

    public static void main(String[] args) {
        SessionFactory sf = SessionFactoryUtil.getSessionFactory();
        Session session = sf.openSession();

        try {
            DepartamentosEntidad d = session.get(DepartamentosEntidad.class, 20);
            session.getTransaction().begin();
            if (session.get(LocalizacionesEntidad.class, 4000) != null) {
                d.setIdLocalizacion(4000);
                session.persist(d);
                session.getTransaction().commit();
            }
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }
}


