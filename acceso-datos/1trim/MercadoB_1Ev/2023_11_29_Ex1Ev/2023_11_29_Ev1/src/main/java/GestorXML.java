import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;

public class GestorXML {


    public static boolean crearDocumentoXML(Concierto concierto) throws IOException {
        Path path = Paths.get("concierto.xml");
        if (!Files.exists(path)) {
            Files.createFile(path);
        } else {
            Files.delete(path);
            Files.createFile(path);
        }

        Document document = getDocument(path.toString());
        document.appendChild(document.createElement("concierto"));

        Element fechaElement = getFechaElement(concierto, document);
        Element salaElement = getSalaElement(concierto, document);

        document.getDocumentElement().appendChild(fechaElement);
        document.getDocumentElement().appendChild(salaElement);

        for (Musico musico: concierto.getMusicos()) {
            crearElementoMusico(document, musico);
        }

        for (Obra obra: concierto.getObras()) {
            crearElementoObra(document, obra);
        }
        return true;
    }

    public static Element getSalaElement(Concierto concierto, Document document) {
        Element newElement = document.createElement("sala");
        Text textNode = document.createTextNode(concierto.getSala());
        newElement.appendChild(textNode);
        return newElement;
    }

    public static Element getFechaElement(Concierto concierto, Document document) {
        Element newElement = document.createElement("fecha");
        Text textNode = document.createTextNode(concierto.getFecha().toString());
        newElement.appendChild(textNode);
        return newElement;
    }

    public static Document getDocument(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(fileName));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    private static Element crearElementoMusico(Document doc, Musico musico) {
        Element elementoMusico = doc.createElement("musico");
        Element idMusicoElement = crearElementoTexto(doc, "idMusico", String.valueOf(musico.getIdMusico()));
        Element nombreElement = crearElementoTexto(doc, "nombre", String.valueOf(musico.getNombre()));
        Element apellidoElement = crearElementoTexto(doc, "apellido", String.valueOf(musico.getApellido()));

        doc.getDocumentElement().appendChild(elementoMusico);
        elementoMusico.appendChild(idMusicoElement);
        elementoMusico.appendChild(nombreElement);
        elementoMusico.appendChild(apellidoElement);

        return elementoMusico;
    }

    private static Element crearElementoObra(Document doc, Obra obra) {
        Element elementoObra = doc.createElement("musico");
        Element idObraElement = crearElementoTexto(doc, "idObra", String.valueOf(obra.getIdObra()));
        Element nombreElement = crearElementoTexto(doc, "nombre", String.valueOf(obra.getNombre()));
        Element anioElement = crearElementoTexto(doc, "anio", String.valueOf(obra.getIdObra()));

        doc.appendChild(elementoObra);
        elementoObra.appendChild(idObraElement);
        elementoObra.appendChild(nombreElement);
        elementoObra.appendChild(anioElement);

        return elementoObra;
    }

    private static Element crearElementoTexto(Document doc, String nombre, String texto) {
        Element elemento = doc.createElement(nombre);
        Text text = doc.createTextNode(texto);
        elemento.appendChild(text);
        return elemento;
    }

    private static void guardarDocumentoEnArchivo(Document doc, File archivo) throws TransformerException {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(archivo.getName()));
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

