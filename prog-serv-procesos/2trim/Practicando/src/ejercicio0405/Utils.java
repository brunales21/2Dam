package ejercicio0405;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Utils {
    public static String getDate() {
        // Obtén la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Define el formato que deseas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        // Formatea la fecha en el formato deseado
        String fechaFormateada = fechaActual.format(formato);

        return fechaFormateada;
    }

    public static String getTime() {
        // Obtén la hora actual
        LocalTime horaActual = LocalTime.now();

        // Define el formato que deseas
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Formatea la hora en el formato deseado
        String horaFormateada = horaActual.format(formato);

        return horaFormateada;
    }
}
