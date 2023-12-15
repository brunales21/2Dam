import java.sql.SQLException;

public class Principal {
    public static void main(String[] args) {
        Musico musico;
        Obra obra;
        Concierto concierto;

        try(GestorConciertos gestor = new GestorConciertos()) {
            musico = gestor.buscarMusicoPorId(2);
            System.out.println("\n\n---------------- Ejercicio 1 ----------------");
            System.out.println(musico);

            obra = gestor.buscarObraPorId(14);
            System.out.println("\n\n---------------- Ejercicio 2 ----------------");
            System.out.println(obra);

            concierto = gestor.cargarConciertoCompleto(7);
            System.out.println("\n\n---------------- Ejercicio 3 ----------------");
            System.out.println(concierto);

            boolean sobrescribe = GestorXML.crearDocumentoXML(concierto);
            System.out.println("\n\n---------------- Ejercicio 4 ----------------");
            System.out.println("archivo creado " + (sobrescribe?"sobrescribiendo el anterior":"sin sobrescribir otro"));

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
