package ejsParte2;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
public class Empleado {
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private LocalDate fechaContratacion;
    private String idTrabajo;
    private double salario;
    private double comision;
    private String nombreDepartamento;
    private Empleado director;

    // Constructor
    public Empleado(int idEmpleado, String nombre, String apellido, String email, String telefono,
                    LocalDate fechaContratacion, String idTrabajo, double salario, double comision, String nombreDepartamento, Empleado director) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.idTrabajo = idTrabajo;
        this.salario = salario;
        this.comision = comision;
        this.nombreDepartamento = nombreDepartamento;
        this.director = director;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String email, String telefono,
                    LocalDate fechaContratacion, String idTrabajo, double salario, double comision) {
        this(idEmpleado, nombre, apellido, email, telefono, fechaContratacion, idTrabajo, salario, comision, "", null);
    }

    public Empleado(int idEmpleado, String nombre, String apellido, String email, String telefono,
                    LocalDate fechaContratacion, String idTrabajo, double salario, double comision, String nombreDepartamento) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaContratacion = fechaContratacion;
        this.idTrabajo = idTrabajo;
        this.salario = salario;
        this.comision = comision;
        this.nombreDepartamento = nombreDepartamento;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ejsParte1.Empleado{idEmpleado=").append(idEmpleado);
        sb.append(", nombre='").append(nombre).append('\'');
        sb.append(", apellido='").append(apellido).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", telefono='").append(telefono).append('\'');
        sb.append(", fechaContratacion=").append(fechaContratacion);
        sb.append(", idTrabajo='").append(idTrabajo).append('\'');
        sb.append(", salario=").append(salario);
        sb.append(", comision=").append(comision);
        sb.append(", nombreDepartamento='").append(nombreDepartamento).append('\'');

        if (director != null) {
            sb.append("\n--Datos director--\n");
            sb.append(director.toString());
            sb.append("\n--Fin DD--");
        }

        sb.append('}');
        return sb.toString();
    }
}
