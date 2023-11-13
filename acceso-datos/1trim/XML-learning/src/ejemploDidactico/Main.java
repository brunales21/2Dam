package ejemploDidactico;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Document doc  = getNormalizedDoc("Recursos/ejemplo.xml");
        Element raiz = doc.getDocumentElement();
        for (int i = 0; i < raiz.getChildNodes().getLength(); i++) {
            if (raiz.getChildNodes().item(i).getNodeType() == Node.ELEMENT_NODE) {
                System.out.println(raiz.getChildNodes().item(i).getNodeName());

            }
        }

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
}
