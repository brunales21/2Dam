import excepciones.MusicoException;

public class Musico {
    private int idMusico;
    private String nombre;
    private String apellido;

    public Musico(int idMusico, String nombre, String apellido) throws MusicoException {
        setIdMusico(idMusico);
        setNombre(nombre);
        setApellido(apellido);
    }

    public void setIdMusico(int idMusico) throws MusicoException {
        if (idMusico <= 0) {
            throw new MusicoException("El ID del músico debe ser positivo.");
        }
        this.idMusico = idMusico;
    }

    public void setNombre(String nombre) throws MusicoException {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new MusicoException("El nombre no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    public void setApellido(String apellido) throws MusicoException {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new MusicoException("El apellido no puede estar vacío.");
        }
        this.apellido = apellido;
    }

    public int getIdMusico() {
        return idMusico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "Musico{" +
                "idMusico=" + idMusico +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Musico musico = (Musico) o;
        return idMusico == musico.idMusico &&
                nombre.equals(musico.nombre) &&
                apellido.equals(musico.apellido);
    }
}
