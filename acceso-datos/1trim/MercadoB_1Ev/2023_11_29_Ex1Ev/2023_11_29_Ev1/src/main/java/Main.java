import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try (GestorConciertos gc = new GestorConciertos()) {
            //System.out.println(gc.buscarMusicoPorId(10));
            //System.out.println(gc.buscarObraPorId(40));

            System.out.println("mi concierto: "+gc.cargarConciertoCompleto(1));
        } catch (Exception e) {

        }
    }


}
