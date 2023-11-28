package xmlSim;

import XmlUtils.XmlUtils;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrecipitacionesDom {
    public Document document;
    private String fileName;

    public PrecipitacionesDom(String fileName) {
        this.document = getDocument(fileName);
        this.fileName = fileName;

    }

    public void borrarLugarByPoblacion(String poblacion) {
        Element elementTarget = getElementLugarByPoblacion(poblacion);
        document.getDocumentElement().removeChild(elementTarget);
        XmlUtils.guardarDocumento(document, fileName);
        XmlUtils.transformarXml(document, fileName);

    }


    public List<Element> getElementsLugarByProvincia(String provincia) {
        List<Element> listaElementosLugar = new ArrayList<>();
        NodeList elementosLugar = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < elementosLugar.getLength(); i++) {
            Node lugarNode = elementosLugar.item(i);
            if (lugarNode.getNodeType() == Node.ELEMENT_NODE) {
                Element lugarElement = (Element) lugarNode;
                Element provinciaElement = (Element) lugarElement.getElementsByTagName("provincia").item(0);
                if (provinciaElement.getTextContent().equals(provincia)) {
                    listaElementosLugar.add(lugarElement);
                }
            }
        }
        return listaElementosLugar;
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
    public List<Lugar> leerLugares(String provincia) {
        List<Lugar> lugaresList = new ArrayList<>();
        Element elementoRaiz = document.getDocumentElement();
        NodeList lugares = elementoRaiz.getChildNodes();
        if (provincia == null) {
            return leerTodosLugares();
        }
        for (int i = 0; i < lugares.getLength(); i++) {
            Node currentNode = lugares.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element lugar = (Element) currentNode;
                Element prov = (Element) lugar.getElementsByTagName("provincia").item(0);
                if (prov.getTextContent().equals(provincia)) {
                    lugaresList.add(getLugar(lugar));
                }
            }

        }
        return lugaresList;
    }

    public List<Lugar> leerTodosLugares() {
        List<Lugar> lugaresList = new ArrayList<>();
        Element elementoRaiz = document.getDocumentElement();
        NodeList lugares = elementoRaiz.getChildNodes();
        for (int i = 0; i < lugares.getLength(); i++) {
            Node currentNode = lugares.item(i);
            if (currentNode.getNodeType() == Node.ELEMENT_NODE) {
                Element lugar = (Element) currentNode;
                lugaresList.add(getLugar(lugar));
            }

        }
        return lugaresList;
    }

    public void addCantidad(String poblacion, String newPrecipitacion) {
        Element lugarElement = getElementLugarByPoblacion(poblacion);
        Element newCant = getNewElemento("cantidad", newPrecipitacion, document);
        lugarElement.getElementsByTagName("cantidades").item(0).appendChild(newCant);
        XmlUtils.guardarDocumento(document, fileName);
    }




    public Element getNewElemento(String etiqueta, String valor, Document document) {
        Element newElement = document.createElement(etiqueta);
        Text textNode = document.createTextNode(valor);
        newElement.appendChild(textNode);
        return newElement;
    }

    public Element getElementLugarByPoblacion(String poblacion) {
        NodeList lugarElements = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < lugarElements.getLength(); i++) {
            if (lugarElements.item(i).getNodeType() == Node.ELEMENT_NODE) {
                Element lugarElement = (Element) lugarElements.item(i);
                if (getLugar(lugarElement).getPoblacion().equals(poblacion)) {
                    return lugarElement;
                }
            }
        }
        return null;
    }

    public Lugar getLugar(Element lugar) {
        List<Cantidad> cantidadList = new ArrayList<>();
        String poblacion = lugar.getElementsByTagName("poblacion").item(0).getTextContent();
        String provincia = lugar.getElementsByTagName("provincia").item(0).getTextContent();
        NodeList cantidades = lugar.getElementsByTagName("cantidades");
        Node nodoCantidades = cantidades.item(0);
        if (nodoCantidades.getNodeType()==Node.ELEMENT_NODE) {
            Element elementoCantidades = (Element) nodoCantidades;
            NodeList elementosCantidad = elementoCantidades.getChildNodes();
            for (int j = 0; j < elementosCantidad.getLength(); j++) {
                if (elementosCantidad.item(j).getNodeType() == Node.ELEMENT_NODE) {
                    Element cantidadElement = (Element) elementosCantidad.item(j);
                    String valor = cantidadElement.getTextContent();
                    cantidadList.add(new Cantidad(valor));
                }
            }
        }
        return new Lugar(poblacion, provincia, cantidadList);
    }



}
