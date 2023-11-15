import java.util.EnumMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/empleados";
        String username = "root";
        String password = "";

        EmpleadoDAOSql daoSql = new EmpleadoDAOSql(url, username, password);
        /*
        // ej1

        List<Empleado> empleadosVentas = daoSql.getEmpleadosFromDepartamento("Ventas");
        daoSql.showEmpleados(empleadosVentas);

         */
/*
        //ej2
        List<Empleado> empleadosEjecutivosMarketing = daoSql.getEmpleadosFromDepartamentos("Ejecutivo", "Marketing");
        daoSql.showEmpleados(empleadosEjecutivosMarketing);

 */

        //ej3
        List<Empleado> empEjecutivos = daoSql.getEmpleadosFromDepartamento("Ejecutivo");
        List<Empleado> empAdministracion = daoSql.getEmpleadosFromDepartamento("Administracion");

        daoSql.showEmpleados(empEjecutivos);
        daoSql.showEmpleados(empAdministracion);



    }
}
