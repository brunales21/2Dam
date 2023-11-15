import java.io.Externalizable;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Empleado> getEmpleadosFromDepartamento(String nomDepartamento) {
        List<Empleado> empleados = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, username, password)) {
            try (Statement sentencia = conexion.createStatement()) {
                String query = "select e.*, nombre_departamento from empleados e inner join departamentos d on e.id_departamento = d.id_departamento where d.nombre_departamento = '"+nomDepartamento+"'";

                try (ResultSet resultado = sentencia.executeQuery(query)) {
                    while (resultado.next()) {
                        Empleado empleado = createEmpleadoFromResultSet(resultado);
                        empleados.add(empleado);
                    }
                }
            }
        } catch (SQLException e) {
            showSqlExcData(e);
        }
        return empleados;
    }

    public List<Empleado> getEmpleadosFromDepartamentos(String... nombresDep) {
        List<Empleado> empleados = new ArrayList<>();
        try (Connection conexion = DriverManager.getConnection(url, username, password);
             Statement sentencia = conexion.createStatement()) {
            for (String nombreDep: nombresDep) {
                String query = "select e.*, d.nombre_departamento, dir.* from empleados e inner join departamentos d on e.id_departamento = d.id_departamento inner join empleados dir on e.id_director = dir.id_empleado where d.nombre_departamento = '"+nombreDep+"'";
                try (ResultSet resultado = sentencia.executeQuery(query)) {
                    while (resultado.next()) {
                        Empleado empleado = createEmpleadoFromResultSet(resultado);
                        empleados.add(empleado);
                    }
                } catch (SQLException e) {
                    showSqlExcData(e);
                }
            }
        } catch (SQLException e) {
            showSqlExcData(e);
        }
        return empleados;
    }

    private Empleado createEmpleadoFromResultSet(ResultSet result) {
        Empleado empleado = null;
        try {
            if (result.next()) {
                int idEmpleado = result.getInt("id_empleado");
                String nombre = result.getString("nombre");
                String apellido = result.getString("apellido");
                String email = result.getString("email");
                String telefono = result.getString("telefono");
                Date fechaContratacion = result.getDate("fecha_contratacion");
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

            String query = "select e.*, d.nombre_departamento from empleados e inner join departamentos d on e.id_departamento = d.id_departamento where e.id_empleado = "+id;
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

    public void showSqlExcData(SQLException e) {
        System.out.println("Mensaje: " + e.getMessage());
        System.out.println("Estado SQL: " + e.getSQLState());
        System.out.println("Código de error: " + e.getErrorCode());
    }

    public void showEmpleados(List<Empleado> empleados) {
        empleados.forEach(e -> System.out.println(e+"\n"));
    }
}
