package ej2;

import entidades.*;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Creacion del EntityManagerFactory
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("empleados");

        // Creacion del EntityManager
        EntityManager em = emf.createEntityManager();

        try {
            // Introduzco varios objetos de cada tabla
            introducirDatos(em);

            // Muestro los detalles, incluidos los objetos asociados
            mostrarDetalles(em);

        } finally {
            em.close();
            emf.close();
        }
    }

    private static void introducirDatos(EntityManager em) {
        // Introduzco datos de las regiones, países y localizaciones.

        // Ejemplo:
        em.getTransaction().begin();

        RegionesEntity region1 = new RegionesEntity();
        region1.setNombreRegion("América");
        em.persist(region1);

        PaisesEntity pais1 = new PaisesEntity();
        pais1.setNombrePais("Estados Unidos");
        pais1.setRegion(region1);
        em.persist(pais1);

        LocalizacionesEntity localizacion1 = new LocalizacionesEntity();
        localizacion1.setDireccion("123 Main St");
        localizacion1.setCodigoPostal("12345");
        localizacion1.setCiudad("New York");
        localizacion1.setProvincia("NY");
        localizacion1.setPais(pais1);
        em.persist(localizacion1);

        em.getTransaction().commit();
    }

    private static void mostrarDetalles(EntityManager em) {
        // Detalles de las regiones, países y localizaciones.

        // Ejemplo:
        List<RegionesEntity> regiones = em.createQuery("SELECT r FROM RegionesEntity r", RegionesEntity.class)
                .getResultList();

        for (RegionesEntity region : regiones) {
            System.out.println("Detalles de Región: " + region);
            List<PaisesEntity> paises = region.getPaises();
            for (PaisesEntity pais : paises) {
                System.out.println("  Detalles de País: " + pais);
                List<LocalizacionesEntity> localizaciones = pais.getLocalizaciones();
                for (LocalizacionesEntity localizacion : localizaciones) {
                    System.out.println("    Detalles de Localización: " + localizacion);
                }
            }
        }
    }
}
