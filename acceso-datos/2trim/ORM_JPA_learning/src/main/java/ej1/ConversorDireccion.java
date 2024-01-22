package ej1;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class ConversorDireccion implements AttributeConverter<Direccion, String> {

    @Override
    public String convertToDatabaseColumn(Direccion direccion) {
        if (direccion == null) {
            return null;
        }
        // Concatenar dirección, ciudad y código postal en un solo string
        return direccion.getDireccion() + ", " + direccion.getCiudad() + ", " + direccion.getCodigoPostal();
    }

    @Override
    public Direccion convertToEntityAttribute(String direccionCompleta) {
        if (direccionCompleta == null) {
            return null;
        }
        // Separar la cadena en dirección, ciudad y código postal
        String[] partes = direccionCompleta.split(", ");
        if (partes.length == 3) {
            Direccion direccion = new Direccion();
            direccion.setDireccion(partes[0]);
            direccion.setCiudad(partes[1]);
            direccion.setCodigoPostal(partes[2]);
            return direccion;
        }
        // Manejo de error si la cadena no tiene el formato esperado
        return null;
    }
}
