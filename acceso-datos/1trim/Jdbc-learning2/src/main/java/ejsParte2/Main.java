package ejsParte2;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://127.0.0.1:3306/empleados";
        String username = "root";
        String password = "";
        EmpleadoDAOSql daoSql = new EmpleadoDAOSql(url, username, password);
        //System.out.println(daoSql.getIndexesFromRsByIdDep(daoSql.cargarEnResultSetOrderBy("id_departamento"), 60));

        //daoSql.insertEmpleado(new Empleado(699, "Saralama", "Chuer", "mjjc@scott.com", "912226765", LocalDate.of(2000, 10, 17), "SA_MAN", 1111.11, 0.0), 100, 60);

        //System.out.println(daoSql.updateSalarios());

    }
}
