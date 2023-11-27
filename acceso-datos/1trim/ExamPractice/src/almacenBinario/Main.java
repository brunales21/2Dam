package almacenBinario;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonDao pdao = new PersonDao(Paths.get("almacenes/almacenBinario"));
        pdao.writePersonas(getPersonas());
        pdao.readPersonas().forEach(p1 -> System.out.println(p1));


    }

    public static List<Persona> getPersonas() {
        Persona p = new Persona("Bruno", 20, new Direccion("calle1", "ny"));

        Persona persona1 = new Persona("Juan", 25, new Direccion("Calle A", "Ciudad A"));
        Persona persona2 = new Persona("María", 30, new Direccion("Calle B", "Ciudad B"));
        Persona persona3 = new Persona("Pedro", 28, new Direccion("Calle C", "Ciudad C"));
        Persona persona4 = new Persona("Ana", 22, new Direccion("Calle D", "Ciudad D"));
        Persona persona5 = new Persona("Carlos", 35, new Direccion("Calle E", "Ciudad E"));

        // Crear lista de Personas
        List<Persona> listaPersonas = new ArrayList<>();
        listaPersonas.add(p);
        listaPersonas.add(persona1);
        listaPersonas.add(persona2);
        listaPersonas.add(persona3);
        listaPersonas.add(persona4);
        listaPersonas.add(persona5);
        return listaPersonas;
    }
}
