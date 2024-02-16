package ejs6_2;

import jakarta.persistence.AttributeConverter;

import javax.print.attribute.Attribute;

public class ConversorLocalizacion implements AttributeConverter<LocalizacionEntity, String> {
    @Override
    public String convertToDatabaseColumn(LocalizacionEntity localizacionEntity) {
        return localizacionEntity.getDireccion() + " " + localizacionEntity.getCiudad() + " " + localizacionEntity.getCiudad();
    }

    @Override
    public LocalizacionEntity convertToEntityAttribute(String s) {
        String [] localizacionParts = s.split(" ");
        return new LocalizacionEntity(localizacionParts[0], localizacionParts[1], localizacionParts[2]);
    }
}
