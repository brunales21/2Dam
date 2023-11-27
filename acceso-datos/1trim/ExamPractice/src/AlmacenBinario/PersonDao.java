package AlmacenBinario;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class PersonDao {
    private Path almacenBinario;

    public PersonDao(Path almacenBinario) {
        this.almacenBinario = almacenBinario;
    }

    public boolean writePersonas(List<Persona> personas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(almacenBinario.toString()))) {
            for (Persona persona : personas) {
                oos.writeObject(persona);
            }
        } catch (IOException e) {
            return false;
        }
    return true;
    }

    public List<Persona> readPersonas() {
        List<Persona> personas = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(almacenBinario.toString()))) {
            while (true) {
                try {
                    personas.add((Persona) ois.readObject());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            return null;
        }
        return personas;
    }
}
