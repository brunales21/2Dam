import excepciones.ConciertoException;
import excepciones.MusicoException;
import excepciones.ObraException;

import java.sql.*;
import java.time.LocalDateTime;

public class GestorConciertos implements AutoCloseable {
    private Connection conexion;

    public GestorConciertos() {
        // Estableciendo la conexión con la base de datos
        String url = "jdbc:mysql://192.168.56.101:3306/Conciertos";
        String usuario = "admin00";
        String password = "alumno";
        try {
            this.conexion = DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {

        }
    }

    public Musico buscarMusicoPorId(int idMusico) {
        String query = "select id_Musico, nombre, apellido from Musico where id_Musico = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, idMusico);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getMusicoByResultset(resultSet);
        } catch (SQLException e) {
            return null;
        }
    }

    public Obra buscarObraPorId(int idObra){
        String query = "select id_Obra, nombre, anio from Obra where id_Obra = ?";
        try (PreparedStatement preparedStatement = conexion.prepareStatement(query)) {
            preparedStatement.setInt(1, idObra);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return getObraByResultset(resultSet);
        } catch (SQLException e) {
            showSqlExcData(e);
            return null;
        }
    }

    public void showSqlExcData(SQLException e) {
        System.out.println("Mensaje: " + e.getMessage());
        System.out.println("Estado SQL: " + e.getSQLState());
        System.out.println("Código de error: " + e.getErrorCode());
    }

    public Obra getObraByResultset(ResultSet resultSet) {
        try {
            return new Obra(resultSet.getInt("id_Obra"), resultSet.getString("nombre"), Short.parseShort(resultSet.getString("anio")));
        } catch (ObraException | SQLException e) {
            return null;
        }
    }

    public Musico getMusicoByResultset(ResultSet resultSet) {
        try {
            return new Musico(resultSet.getInt("id_Musico"), resultSet.getString("nombre"), resultSet.getString("apellido"));
        } catch (SQLException | MusicoException e) {
            return null;
        }
    }

    public Concierto getConciertoByResultset(ResultSet resultSet) {
        try {
            return new Concierto(resultSet.getInt("id_Concierto"), resultSet.getTimestamp("fecha").toLocalDateTime(), resultSet.getString("sala"));
        } catch (SQLException | ConciertoException e) {
            showSqlExcData((SQLException) e);
            return null;
        }
    }

    public Concierto cargarConciertoCompleto(int idConcierto) {
        String query = "select id_Concierto, fecha, sala from Concierto where id_Concierto = ?";
        String query1 = "select id_Musico from Participa where id_Concierto = ?";
        String query2 = "select id_Obra from Interpreta where id_Concierto = ?";

        try (PreparedStatement preparedStatement = conexion.prepareStatement(query);
             PreparedStatement preparedStatement1 = conexion.prepareStatement(query1);
             PreparedStatement preparedStatement2 = conexion.prepareStatement(query2)) {

            preparedStatement.setInt(1, idConcierto);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Concierto concierto = getConciertoByResultset(resultSet);

            preparedStatement1.setInt(1, idConcierto);
            ResultSet resultSet1 = preparedStatement1.executeQuery();
            while (resultSet1.next()) {
                Musico m = buscarMusicoPorId(resultSet1.getInt("id_Musico"));
                concierto.getMusicos().add(m);
            }

            preparedStatement2.setInt(1, idConcierto);
            ResultSet resultSet2 = preparedStatement2.executeQuery();
            while (resultSet2.next()) {
                Obra o = buscarObraPorId(resultSet2.getInt("id_Obra"));
                concierto.getObras().add(o);
            }
            return concierto;
        } catch (SQLException e) {
            showSqlExcData(e);
            return null;
        }
    }

    @Override
    public void close() throws Exception {
        conexion.close();
    }
}
