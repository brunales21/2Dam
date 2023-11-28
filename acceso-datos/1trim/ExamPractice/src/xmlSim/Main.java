package xmlSim;

import XmlUtils.XmlUtils;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        Path xmlPath = Paths.get("almacenes/Precipitaciones.xml");
        PrecipitacionesDom pdom = new PrecipitacionesDom(xmlPath.toString());
        pdom.addCantidad("Segovia", "1");
        XmlUtils.transformarXml(pdom.document, xmlPath.toString());

        pdom.leerLugares(null).forEach(System.out::println);
    }
}
