import excepciones.ObraException;

public class Obra {
    private int idObra; // `id_Obra`
    private String nombre; // `nombre`
    private Short anio; // `anio` (SmallInt en SQL, Short en Java)

    public Obra(int idObra, String nombre, Short anio) throws ObraException {
        setIdObra(idObra);
        setNombre(nombre);
        setAnio(anio);
    }

    // Setter para idObra
    public void setIdObra(int idObra) throws ObraException {
        // La id no debería ser negativa
        if (idObra < 0) {
            throw new ObraException("El ID de la obra no puede ser negativo.");
        }
        this.idObra = idObra;
    }

    // Setter para nombre
    public void setNombre(String nombre) throws ObraException {
        // El nombre no puede ser nulo ni vacío
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new ObraException("El nombre de la obra no puede estar vacío.");
        }
        this.nombre = nombre;
    }

    // Setter para anio
    public void setAnio(Short anio) throws ObraException {
        // Año opcional, pero si se proporciona, debe ser razonable (ej: mayor que 0)
        if (anio != null && anio <= 0) {
            throw new ObraException("El año de la obra debe ser positivo.");
        }
        this.anio = anio;
    }

    public int getIdObra() {
        return idObra;
    }

    public String getNombre() {
        return nombre;
    }

    public Short getAnio() {
        return anio;
    }

    @Override
    public String toString() {
        return "Obra{" +
                "idObra=" + idObra +
                ", nombre='" + nombre + '\'' +
                ", anio=" + anio +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Obra)) return false;
        Obra obra = (Obra) o;
        return idObra == obra.idObra &&
                nombre.equals(obra.nombre) &&
                (anio == null ? obra.anio == null : anio.equals(obra.anio));
    }
}
