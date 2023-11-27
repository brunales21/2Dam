package csvUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

public class ObjectToCSVConverter {
    public static String toStringCsv(Object object, String delimiter) {
        StringBuilder sb = new StringBuilder();
        try {
            Class miClase = Class.forName(object.getClass().getName());
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                campo.setAccessible(true);
                sb.append(campo.get(object)).append(delimiter);
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }

    /*
    public static Object getObjectFromCsv(Object object, String line) {
        Object instancia = null;
        try {
            Class miClase = Class.forName(object.getClass().getName());
            Field[] campos = miClase.getDeclaredFields();
            Constructor constructor = miClase.getConstructor(Arrays.stream(campos).toList().forEach(a -> a.getType()));


            instancia = constructor.newInstance(Arrays.stream(campos).forEach(a -> {
                try {
                    a.get(miClase);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
            }));


        } catch (ClassNotFoundException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return instancia;
    }

     */
}
