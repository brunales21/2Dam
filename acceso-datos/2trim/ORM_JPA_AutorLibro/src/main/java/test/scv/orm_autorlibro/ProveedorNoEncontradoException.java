package test.scv.orm_autorlibro;

public class ProveedorNoEncontradoException extends Exception {
    public ProveedorNoEncontradoException(int id) {
        super("Proveedor no encontrado con ID: " + id);
    }
}
