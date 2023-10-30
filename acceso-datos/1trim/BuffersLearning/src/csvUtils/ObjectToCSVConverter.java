package csvUtils;

import java.lang.reflect.Field;

public class ObjectToCSVConverter {
    public static String toStringCsv(Object object) {
        StringBuilder sb = new StringBuilder();
        try {
            Class miClase = Class.forName(object.getClass().getName());
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                campo.setAccessible(true);
                sb.append(campo.get(object)).append(";");
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }
}
