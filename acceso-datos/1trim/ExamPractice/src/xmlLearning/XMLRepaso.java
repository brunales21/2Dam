package xmlLearning;

import org.w3c.dom.*;
import org.w3c.dom.traversal.DocumentTraversal;
import org.w3c.dom.traversal.NodeFilter;
import org.w3c.dom.traversal.NodeIterator;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XMLRepaso {

    private final Document document;


    public XMLRepaso(String fileName) {
        this.document = getDocument(fileName);
        this.document.normalize();

    }

    public static Element crearElemento(String nombre, String valor, Document document) {
        Element elemento = document.createElement(nombre);
        Text texto = document.createTextNode(valor);
        elemento.appendChild(texto);
        return elemento;
    }

    public Document getDocument(String fileName) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(new File(fileName));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            return null;
        }
    }

    public void addLibro(Libro libro) {
        Element newElementoLibro = document.createElement("libro");
        newElementoLibro.setAttribute("id", libro.getId());
        newElementoLibro.appendChild(crearElemento("titulo", libro.getTitulo(), document));
        newElementoLibro.appendChild(crearElemento("autor", libro.getAutor(), document));
        newElementoLibro.appendChild(crearElemento("anio", libro.getAnio(), document));

        document.getDocumentElement().appendChild(newElementoLibro);
        guardarDocumento();
    }

    private void guardarDocumento() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("libros.xml"));
            transformer.transform(source, result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void transformarXml(String rutaXML) {
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
        File myFile = new File(rutaXML);

        // Mostrar los resultados por consola y escribirlos en el archivo.
        StreamResult console = new StreamResult(System.out);
        StreamResult file = new StreamResult(myFile);
        try {
            transf.transform(source, console);
            transf.transform(source, file);

        } catch (TransformerException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Libro> cargarLibros() {
        List<Libro> libros = new ArrayList<>();
        NodeList elementosLibro = document.getElementsByTagName("libro");

        for (int i = 0; i < elementosLibro.getLength(); i++) {
            Element libroElemento = (Element) elementosLibro.item(i);
            String id = libroElemento.getAttribute("id");
            String titulo = obtenerContenidoElemento(libroElemento, "titulo");
            String autor = obtenerContenidoElemento(libroElemento, "autor");
            String anio = obtenerContenidoElemento(libroElemento, "anio");

            libros.add(new Libro(id, titulo, autor, anio));
        }
        return libros;
    }

    //con iterator
    public List<Libro> cargarLibrosIterator() {
        List<Libro> libros = new ArrayList<>();

        NodeIterator iterator = ((DocumentTraversal) document).createNodeIterator(document.getDocumentElement(), NodeFilter.SHOW_ELEMENT, null, false);

        while (iterator.nextNode() != null) {
            Node libroNode = iterator.nextNode();
            Element libroElement = (Element) libroNode;

            String id = libroElement.getAttribute("id");
            String titulo = obtenerContenidoElemento(libroElement, "titulo");
            String autor = obtenerContenidoElemento(libroElement, "autor");
            String anio = obtenerContenidoElemento(libroElement, "anio");

            libros.add(new Libro(id, titulo, autor, anio));
        }
        return libros;
    }

    private String obtenerContenidoElemento(Element elemento, String tagName) {
        return elemento.getElementsByTagName(tagName).item(0).getTextContent();
    }

    public Document createDocument(String name) {
        // creamos el builder que nos permiterá crear documentos, etc.
        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = null;
        try {
            builder = builderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            return null;
        }
        // obtenemos una implementación del DOM
        DOMImplementation implementation = builder.getDOMImplementation();
        // Creamos el documento
        Document documento = implementation.createDocument(null, name, null);
        // establecemos la version de XML
        documento.setXmlVersion("1.0");
        return documento;
    }

    public void imprimirElemento(String nombreElement) {
        Element raizElement = document.getDocumentElement();
        NodeList elementosRaiz = raizElement.getChildNodes();
        for (int i = 0; i < elementosRaiz.getLength(); i++) {
            if (elementosRaiz.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element libroElement = (Element) elementosRaiz.item(i);
                Element target = (Element) libroElement.getElementsByTagName(nombreElement).item(0);
                System.out.println(target.getTextContent());
            }
        }
    }

}
