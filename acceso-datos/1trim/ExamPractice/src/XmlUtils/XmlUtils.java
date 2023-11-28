package XmlUtils;

import org.w3c.dom.Document;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class XmlUtils {

    public static void guardarDocumento(Document document, String rutaXml) {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(rutaXml));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void transformarXml(Document document, String rutaXml) {
        // Creamos el transformador.
        TransformerFactory transformerFactory;
        transformerFactory = TransformerFactory.newInstance();

        File xsltLimpiar = new File("limpiar.xslt");
        StreamSource limpiarStream = new StreamSource(xsltLimpiar);
        Transformer transf;
        try {
            transf = transformerFactory.newTransformer(limpiarStream);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        }
        // establecemos codificación y pedimos que indente.
        transf.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        transf.setOutputProperty(OutputKeys.INDENT, "yes");
        transf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
        // crea el árbol para una transformación.
        DOMSource source = new DOMSource(document);
        // Creamos el archivo para guardar los datos.
        File myFile = new File(rutaXml);

        // Mostrar los resultados por consola y escribirlos en el archivo.
        //StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);
        try {
            //transf.transform(source, console);
            transf.transform(source, file);

        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }
}
