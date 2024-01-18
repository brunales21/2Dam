package test.scv.orm_autorlibro;

import jakarta.persistence.AttributeConverter;

public class ConversorTitulo implements AttributeConverter<String, String> {

    @Override
    public String convertToDatabaseColumn(String tituloApp) {
        if(tituloApp == null) {
            return null;
        }

        return tituloApp.toUpperCase();
    }

    @Override
    public String convertToEntityAttribute(String tituloBD) {
        if(tituloBD == null) {
            return null;
        }

        return tituloBD.substring(0, 1).toUpperCase() +
                tituloBD.substring(1).toLowerCase();
    }
}
