import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        getConductorNombre();
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
        Document document = getNormalizedDoc("C:\\Users\\bemim\\Workspace\\DAM\\2Dam\\acceso-datos\\recursos\\carrera.xml");
        Element elRaiz = document.getDocumentElement();
        NodeList participantes = document.getElementsByTagName("participante");
        for (int i = 0; i < participantes.getLength(); i++) {
            Element participante = (Element) participantes.item(i);
            System.out.println(getNodo("nombre", participante));


        }


    }

    public static String getNodo(String etiqueta, Element elem) {
        NodeList nodeList = elem.getElementsByTagName(etiqueta).item(0).getChildNodes();
        return nodeList.item(0)
    }
}
