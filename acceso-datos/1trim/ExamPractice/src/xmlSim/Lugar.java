package xmlSim;

import java.util.List;

public class Lugar {
    private String poblacion;
    private String provincia;
    private List<Cantidad> cantidades;

    public Lugar(String poblacion, String provincia, List<Cantidad> cantidades) {
        this.poblacion = poblacion;
        this.provincia = provincia;
        this.cantidades = cantidades;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public List<Cantidad> getCantidades() {
        return cantidades;
    }

    public void setCantidades(List<Cantidad> cantidades) {
        this.cantidades = cantidades;
    }

    @Override
    public String toString() {
        String tos = "Lugar: poblacion: " + poblacion + " || provincia: " + provincia + " || cantidades: ";
        StringBuilder cants = new StringBuilder();
        for (int i = 0; i < cantidades.size(); i++) {
            if (i == cantidades.size() - 1) {
                cants.append(cantidades.get(i));
            } else {
                cants.append(cantidades.get(i) + " || ");
            }
        }
        return tos.concat(cants.toString());
    }
}
