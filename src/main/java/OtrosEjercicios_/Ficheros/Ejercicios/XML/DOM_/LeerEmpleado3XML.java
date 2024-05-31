package OtrosEjercicios_.Ficheros.Ejercicios.XML.DOM_;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerEmpleado3XML {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			String ruta = "C:\\Users\\aplod\\Desktop\\eclipse\\workspace\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\XML\\ficheros";
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(ruta + "\\Empleados.xml"));
			document.getDocumentElement().normalize(); //elimina nodos vacios???
			
			System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
			//crea una lista con todos los nodos empleado
			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());
			
			//recorrer la lista
			for (int i = 0; i<empleados.getLength(); i++) {
				Node emple = empleados.item(i);
				if (emple.getNodeType() == Node.ELEMENT_NODE) {
					Element elemento = (Element) emple;
					if (elemento.hasChildNodes()) {
						NodeList nl = emple.getChildNodes();
						for (int j = 0; j<nl.getLength(); j++) {
							Node nd = nl.item(j);
							System.out.println(nd.getNodeName() + " = " + nd.getTextContent());
						}
					}
					System.out.println();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //fin del main
} //fin de la clase


/*
	//si quiero que se imprima como LeerEmpleadoXML.java; usar este codigo
		if (elemento.hasChildNodes()) {
			NodeList nl = emple.getChildNodes();
			System.out.println(elemento.getFirstChild().getNodeName() + " = " + elemento.getFirstChild().getTextContent());
			for (int j = 1; j<nl.getLength(); j++) {
				Node nd = nl.item(j);
				System.out.println(" * " + nd.getNodeName() + " = " + nd.getTextContent());
			}
		}
*/
