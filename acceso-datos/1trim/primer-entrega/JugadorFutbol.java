import java.io.*;
import java.lang.reflect.Field;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

public class JugadorFutbol implements Externalizable {
    private String nombre;
    private String pais;
    private int copasDelMundo;
    private float promedioGoles;
    private boolean tieneBDO;
    private Date debutPais;

    public JugadorFutbol(String nombre, String pais, int copasDelMundo, float promedioGoles, boolean tieneBDO, Date debutPais) {
        this.nombre = nombre;
        this.pais = pais;
        this.copasDelMundo = copasDelMundo;
        this.promedioGoles = promedioGoles;
        this.tieneBDO = tieneBDO;
        this.debutPais = debutPais;
    }

    public JugadorFutbol(String nombre, String pais, int copasDelMundo, float promedioGoles, boolean tieneBDO) {
        this(nombre, pais, copasDelMundo, promedioGoles, tieneBDO, new Date());
    }

    public JugadorFutbol() {
        this("", "", 0, 0.0F, false, new Date());
    }



    public void writeToCsv() {
        Path path = Paths.get("Pruebas/JugadoresFutbol.csv");
        try (BufferedWriter out = new BufferedWriter(new FileWriter(path.toString(), true))) {
            out.write(toStringCsv()+"\n");
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public void writeToBinaryFile(String ruta) {
        Path path = Paths.get(ruta);
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream(path.toString(), true))) {
            os.writeObject(this);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void writeExternal(ObjectOutput out) {
        try {
            out.writeObject(this);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        this.nombre = in.readUTF();
        this.pais = in.readUTF();
        this.copasDelMundo = in.readInt();
        this.promedioGoles = in.readFloat();
        this.tieneBDO = in.readBoolean();
        this.debutPais = (Date)in.readObject();
    }


    public String toStringCsv() {
        StringBuilder sb = new StringBuilder();
        try {
            Class miClase = Class.forName("JugadorFutbol");
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                sb.append(campo.get(this)).append(";");
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            System.err.println(e.getMessage());
        }
        return sb.deleteCharAt(sb.length()-1).toString();
    }



    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        try {
            Class miClase = Class.forName("JugadorFutbol");
            Field[] campos = miClase.getDeclaredFields();
            for (Field campo: campos) {
                sb.append(campo.getName()+" = "+campo.get(this)).append("\n");
            }
        } catch (ClassNotFoundException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        return sb.toString();
    }

    public String getNombre() {
        return nombre;
    }

    public String getPais() {
        return pais;
    }

    public int getCopasDelMundo() {
        return copasDelMundo;
    }

    public float getPromedioGoles() {
        return promedioGoles;
    }

    public boolean isTieneBDO() {
        return tieneBDO;
    }
}
