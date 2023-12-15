package ejsParte2;

import lombok.Getter;
import lombok.Setter;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class EmpleadoDAOSql {
    private String url;
    private String username;
    private String password;

    public EmpleadoDAOSql(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean insertEmpleado(Empleado empleado, int id_director, int id_departamento) {
        String insertQuery = "INSERT INTO empleados (id_empleado, nombre, apellido, email, telefono, fecha_contratacion, id_trabajo, salario, comision, id_director, id_departamento) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {

            preparedStatement.setInt(1, empleado.getIdEmpleado());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getApellido());
            preparedStatement.setString(4, empleado.getEmail());
            preparedStatement.setString(5, empleado.getTelefono());
            preparedStatement.setDate(6, Date.valueOf(empleado.getFechaContratacion()));
            preparedStatement.setString(7, empleado.getIdTrabajo());
            preparedStatement.setDouble(8, empleado.getSalario());
            preparedStatement.setDouble(9, empleado.getComision());
            preparedStatement.setInt(10, id_director);
            preparedStatement.setString(11, String.valueOf(id_departamento));

            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            showSqlExcData(e);
        }
        return true;
    }

    public boolean borrarEmpleadoById(int empleadoId) {
        String query = "DELETE FROM empleados WHERE id_empleado = ?";
        try (Connection connection = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, empleadoId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            showSqlExcData(e);
            return false;
        }
        return true;
    }

    public List<Empleado> getEmpleadosFromDepartamento(String nomDepartamento) {
        List<Empleado> empleados = new ArrayList<>();
        String query = "SELECT e.*, nombre_departamento FROM empleados e INNER JOIN departamentos d ON e.id_departamento = d.id_departamento WHERE d.nombre_departamento = ?";

        try (Connection conexion = DriverManager.getConnection(url, username, password);
             PreparedStatement preparedStatement = conexion.prepareStatement(query)) {

            preparedStatement.setString(1, nomDepartamento);

            try (ResultSet resultado = preparedStatement.executeQuery()) {
                while (resultado.next()) {
                    empleados.add(createEmpleadoFromResultSet(resultado));
                }
            }

        } catch (SQLException e) {
            showSqlExcData(e);
        }

        return empleados;
    }

    public Empleado createEmpleadoFromResultSet(ResultSet result) {
        Empleado empleado = null;
        try {
            if (result.next()) {
                int idEmpleado = result.getInt("id_empleado");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                String telefono = result.getString("telefono");
                LocalDate fechaContratacion = result.getDate("fecha_contratacion").toLocalDate();
                String idTrabajo = result.getString("id_trabajo");
                double salario = result.getDouble("salario");
                double comision = result.getDouble("comision");
                String nombreDepartamento = result.getString("nombre_departamento");

                int idDirector = result.getInt("id_director");
                Empleado director = (idDirector != 0) ? getEmpleadoById(idDirector) : null;

                empleado = new Empleado(idEmpleado, nombre, apellido, email, telefono, fechaContratacion,
                        idTrabajo, salario, comision, nombreDepartamento, director);
            }
        } catch (SQLException e) {
            showSqlExcData(e);
        }
        return empleado;
    }

    public Empleado getEmpleadoById(int id) {
        Empleado empleado = null;
        try (Connection conexion = DriverManager.getConnection(url, username, password);
             Statement sentencia = conexion.createStatement()) {

            String query = "select e.*, d.nombre_departamento from empleados e inner join departamentos d on e.id_departamento = d.id_departamento where e.id_empleado = " + id;
            try (ResultSet resultado = sentencia.executeQuery(query)) {
                empleado = createEmpleadoFromResultSet(resultado);
            } catch (SQLException e) {
                showSqlExcData(e);
            }
        } catch (SQLException e) {
            showSqlExcData(e);
        }
        return empleado;
    }

    public ResultSet cargarTablaEnRS(String tabla) {
        String query = "select * from "+tabla;
        try (Connection connection = getConnection();
        PreparedStatement ps = connection.prepareStatement(query)) {
            return ps.executeQuery();
        } catch (SQLException e) {
            //showSqlExcData(e);
            return null;
        }
    }
    public ResultSet cargarEnResultSetOrderBy(String orderByWhat) {
        String query = "select e.*, d.nombre_departamento, dir.* from empleados e inner join departamentos d on e.id_departamento = d.id_departamento inner join empleados dir on e.id_director = dir.id_empleado order by e.id_departamento = ?";
        ResultSet rs = null;
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, orderByWhat);
            rs = preparedStatement.executeQuery();

        } catch (SQLException e) {
            //showSqlExcData(e);
            return null;
        }
        return rs;
    }

    public int getMinMaxSalario(String id_trabajo, int i) {
        String s = i == 1? "max_salario":"min_salario";
        String query = "select ? from trabajos where id_trabajo = ?";
        try (Connection c = getConnection();
            PreparedStatement ps = c.prepareStatement(query)) {
            ps.setString(1, s);
            ps.setString(2, id_trabajo);
            return ps.executeQuery().getInt(1);
        } catch (SQLException e) {
            return -1;
        }
    }

    public int validateSalarios() {
        String query = "UPDATE empleados e SET e.salario = "
                + "CASE "
                + "WHEN e.salario < (SELECT t.min_salario FROM trabajos t WHERE t.id_trabajo = e.id_trabajo) THEN (SELECT t.min_salario FROM trabajos t WHERE t.id_trabajo = e.id_trabajo) "
                + "WHEN e.salario > (SELECT t.max_salario FROM trabajos t WHERE t.id_trabajo = e.id_trabajo) THEN (SELECT t.max_salario FROM trabajos t WHERE t.id_trabajo = e.id_trabajo) "
                + "ELSE e.salario "
                + "END";
        try (Connection connection = getConnection();
            PreparedStatement ps = connection.prepareStatement(query)) {
            return ps.executeUpdate();

        } catch (SQLException e) {
            showSqlExcData(e);
            return -1;
        }
    }

    public boolean borrarLocSinDepSQL() {
        String query = "delete l.* from localizaciones l where l.id_localizacion not in (select distinct d.id_departamento from departamentos d)";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            return ps.execute();

        } catch (SQLException e) {
            return false;
        }
    }

    public boolean borrarLocalizacionPorId(int idLocalizacion) {
        String query = "delete from localizaciones where id_localizacion = ?";
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, idLocalizacion);
            return ps.execute();
        } catch (SQLException e) {
            return false;
        }
    }


    public boolean borrarLocalizacionesSinDep(ResultSet l, ResultSet d) {
        try {
            List<Integer> idsLocalizacionesSinDep = new ArrayList<>();
            List<Integer> idsLocalizaciones = new ArrayList<>();
            List<Integer> idsLocEnDep = new ArrayList<>();

            l = cargarTablaEnRS("localizaciones");
            d = cargarTablaEnRS("departamentos");

            while (l.next()) {
                idsLocalizaciones.add(l.getInt("id_localizacion"));
            }
            while (d.next()) {
                idsLocEnDep.add(d.getInt("id_localizacion"));
            }

            // mete en la lista los id de loc que no estan en id de dep
            for (Integer i: idsLocEnDep) {
                if (!idsLocalizaciones.contains(i)) {
                    idsLocalizacionesSinDep.add(i);
                }
            }

            idsLocalizacionesSinDep.forEach(this::borrarLocalizacionPorId);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    public boolean updateSalarios() {
        String query1 = "update empleados set salario = salario*2 where salario % 2 = 0";
        String query2 = "update empleados set salario = salario/2 where salario % 2 = 1";

        try (Connection c = getConnection()) {
            PreparedStatement ps1 = c.prepareStatement(query1);
            PreparedStatement ps2 = c.prepareStatement(query2);
            ps1.executeUpdate();
            ps2.executeUpdate();
            if (validateSalarios()!=-1) {
                return true;
            }
        } catch (SQLException e) {
            showSqlExcData(e);
            return false;
        }
        return false;
    }

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            return null;
        }
    }

    public int getIdDepartamentoByName(String nomDep) {
        String query = "select id_departamento from departamentos where nombre_departamento = ?";
        try (Connection c = getConnection();
             PreparedStatement preparedStatement = c.prepareStatement(query)) {
            preparedStatement.setString(1, nomDep);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                } else {
                    return -1;
                }
            }
        } catch (SQLException e) {
            return -1;
        }
    }


    public String getIndexesFromRsByIdDep(ResultSet rs, int idDep) {
        List<Integer> indexes = new ArrayList<>();
        try {
            int index = 0;
            while (rs.next()) {
                Empleado e = createEmpleadoFromResultSet(rs);
                if (e != null && getIdDepartamentoByName(e.getNombreDepartamento()) == idDep) {
                    indexes.add(index);
                }
                index++;
            }
        } catch (SQLException e) {
            showSqlExcData(e);
            return null;
        }
        return "("+indexes.get(0)+", "+indexes.get(indexes.size()-1)+")";

    }

    public void showSqlExcData(SQLException e) {
        System.out.println("Mensaje: " + e.getMessage());
        System.out.println("Estado SQL: " + e.getSQLState());
        System.out.println("Código de error: " + e.getErrorCode());
    }
}
