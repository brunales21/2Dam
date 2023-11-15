import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import java.util.ArrayList;
import java.util.List;

public class Carrera {

    private List<Participante> participantes;

    public Carrera(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public void cargarDatos() {
        Document doc = Main.getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        Element elementoRaiz = doc.getDocumentElement();
        NodeList elementosDeRaiz = elementoRaiz.getChildNodes();
        for (int i = 0; i < elementosDeRaiz.getLength(); i++) {
            Node nodePart = elementosDeRaiz.item(i);
            if (nodePart.getNodeType() == Node.ELEMENT_NODE) {
                Participante p = new Participante(new ArrayList<>());
                Element elemParticipante = (Element) elementosDeRaiz.item(i);
                p.setCodigo(elemParticipante.getElementsByTagName("codigo").item(0).getTextContent());
                Element elemConductor = (Element) elemParticipante.getElementsByTagName("conductor").item(0);
                NodeList elemNames = elemConductor.getChildNodes();
                for (int j = 0; j < elemNames.getLength(); j++) {
                    if (elemNames.item(j).getNodeType() == Node.ELEMENT_NODE) {
                        p.getConductores().add(new Conductor(elemNames.item(j).getTextContent()));

                    }
                }
                Element vehiculoElem = (Element) elemParticipante.getElementsByTagName("vehiculo").item(0);
                p.setVehiculo(new Vehiculo(vehiculoElem.getElementsByTagName("nombre").item(0).getTextContent(), Integer.parseInt(vehiculoElem.getElementsByTagName("numero").item(0).getTextContent()), vehiculoElem.getElementsByTagName("tiempo").item(0).getTextContent()));
                participantes.add(p);
            }

        }
    }

    public void mostrarParticipantes() {
        participantes.forEach(System.out::println);
    }
}
