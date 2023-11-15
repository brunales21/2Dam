import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.net.Inet4Address;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera c = new Carrera(new ArrayList<>());
        c.cargarDatos();
        c.mostrarParticipantes();
    }

    public static Document getNormalizedDoc(String fileName) {
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(fileName));
            document.getDocumentElement().normalize();
            return document;

        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    public static void getConductorNombre() {
        Document document = getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        Element raiz = document.getDocumentElement();
        NodeList nd = raiz.getChildNodes();
        for (int i = 0; i < nd.getLength(); i++) {
            Node node = nd.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                System.out.println("Elemento hijo "+i+" "+element.getTextContent());
            }
        }
    }

    public static void getVehiculoData() {
        Document document = getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        Element root = document.getDocumentElement();
        NodeList list = root.getChildNodes();
        for (int i = 0; i < list.getLength(); i++) {
            Element element = (Element) document.getElementsByTagName("vehiculo");
            for (int j = 0; j < element.getChildNodes().getLength(); j++) {
                System.out.println(element.getChildNodes().item(i));



            }

        }
    }

    public static void vehiculoContent() {
        Document document = getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        NodeList elements = document.getElementsByTagName("vehiculo");
        for (int i = 0; i < elements.getLength(); i++) {
            Element element = (Element) elements.item(i);
            System.out.println("Nombre: "+ getNodo("nombre", element));
            System.out.println("\tNúmero: "+ getNodo("numero", element));
            System.out.println("\tTiempo: "+ getNodo("tiempo", element));        }
    }

    public static String getNodo(String etiqueta, Element elem) {
        NodeList nodeList = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        return nodeList.item(0).getNodeValue();
    }

    public static void getNodeNames() {
        Document document = getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        Element elementoRaiz = document.getDocumentElement();
        NodeList nodeList = elementoRaiz.getChildNodes();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node node = nodeList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) nodeList.item(i);
                NodeList nodeList1 = element.getChildNodes();
                System.out.println(nodeList.item(i).getNodeName());
                for (int j = 0; j <nodeList1.getLength() ; j++) {
                    System.out.println(nodeList1.item(j).getNodeName());
                }
            }


        }
    }

    public static void printPilotoCoche() {
        Document document = getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\1trim\\XML-learning\\Recursos\\carrera.xml");
        Element elementoRaiz = document.getDocumentElement();
        NodeList listElementos = elementoRaiz.getChildNodes();
        for (int i = 0; i < listElementos.getLength(); i++) {
            Node node = listElementos.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element participante = (Element) listElementos.item(i);
                Element conductor = (Element) participante.getElementsByTagName("conductor").item(0);
                String nombreCond = conductor.getElementsByTagName("nombre").item(0).getTextContent();
                int numeroAsig = i;
                Element vehiculo = (Element) participante.getElementsByTagName("vehiculo").item(0);
                int n = Integer.parseInt(vehiculo.getElementsByTagName("numero").item(0).getTextContent());
                System.out.println(n + "-"  + i + "-"+ nombreCond);
            }
        }

    }
}
