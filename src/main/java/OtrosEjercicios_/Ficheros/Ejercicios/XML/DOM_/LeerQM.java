package OtrosEjercicios_.Ficheros.Ejercicios.XML.DOM_;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerQM {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
				//Fichero XML a leer
			String ruta = "C:\\Users\\aplod\\Desktop\\eclipse\\workspace\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\XML\\ficheros";
			File fichXML = new File(ruta + "\\Empleados.xml");
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			Document document = builder.parse(fichXML);
			//Elimina nodos vacios y combina adyacentes en caso de que los hubiera
			document.getDocumentElement().normalize();
			
			System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
			// crea una lista con todos los nodos empleados
			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("nodos empleado a recorrer: %d %n", empleados.getLength());
			
			//recorrer la lista
			for (int i = 0; i< empleados.getLength(); i++)  {
				Node emple = empleados.item(i); //obtener un nodo empleado
				if (emple.getNodeType() == Node.ELEMENT_NODE) { //tipo de nodo
					//obtener los elementos del nodo
					Element elemento = (Element) emple;
					System.out.printf("ID = %s %n", elemento.getElementsByTagName("id").item(0).getTextContent());
					System.out.printf(" * Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.printf(" * Departamento = %s %n", elemento.getElementsByTagName("departamento").item(0).getTextContent());
					System.out.printf(" * Salario = %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} //fin main
}
