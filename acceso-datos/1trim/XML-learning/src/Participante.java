import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import java.util.List;

public class Participante {
    private String codigo;
    private List<Conductor> conductores;
    private Vehiculo vehiculo;

    public Participante(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public void cargarDatos() {
        Document doc = Main.getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        Element elementoRaiz = doc.getDocumentElement();
        NodeList elementosParticipante = elementoRaiz.getChildNodes();
        for (int i = 0; i < elementosParticipante.getLength(); i++) {
            Element elemParticipante = (Element) elementosParticipante.item(i);
            setCodigo(elemParticipante.getElementsByTagName("codigo").item(0).getNodeValue());
            NodeList nombresConductores = elemParticipante.getElementsByTagName("conductor").item(0).getChildNodes();
            for (int j = 0; j < nombresConductores.getLength(); j++) {
                conductores.add(new Conductor(nombresConductores.item(i).getNodeValue()));
            }

            Element vehiculoElem = (Element) elemParticipante.getElementsByTagName("vehiculo").item(0);
            setVehiculo(new Vehiculo(vehiculoElem.getElementsByTagName("nombre").item(0).getNodeValue(), Integer.parseInt(vehiculoElem.getElementsByTagName("numero").item(0).getNodeValue()), vehiculoElem.getElementsByTagName("tiempo").item(0).getNodeValue()));

        }

    }


    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public List<Conductor> getConductores() {
        return conductores;
    }

    public void setConductores(List<Conductor> conductores) {
        this.conductores = conductores;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    @Override
    public String toString() {

        if (conductores.size() == 1) {
            return "Participante:\n" +
                    "codigo: "+ codigo + "\n" +
                    "conductor: " + conductores + "\n" +
                    "vehiculo: " + vehiculo;
        } else {
            return "Participante:\n" +
                    "codigo: "+ codigo + "\n" +
                    "conductores: " + conductores + "\n" +
                    "vehiculo: " + vehiculo;
        }

    }
}
