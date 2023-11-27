package AlmacenBinario;

import java.io.*;
import java.nio.file.Path;

public class PersonaSerializer implements Externalizable {

    private Persona persona;

    public PersonaSerializer(Path almacenBinario, Persona persona) {
        this.persona = persona;
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        // Implementa la lógica de escritura de campos en out
        out.writeUTF(persona.getNombre());
        out.writeInt(persona.getEdad());
        out.writeObject(persona.getDireccion());
    }

    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        // Implementa la lógica de lectura de campos desde in
        persona = new Persona();
        persona.setNombre(in.readUTF());
        persona.setEdad(in.readInt());
        persona.setDireccion((Direccion) in.readObject());
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

}
