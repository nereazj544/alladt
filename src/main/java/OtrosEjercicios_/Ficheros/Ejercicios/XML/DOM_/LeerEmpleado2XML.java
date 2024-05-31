package OtrosEjercicios_.Ficheros.Ejercicios.XML.DOM_;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class LeerEmpleado2XML {
	public static void main(String[] args) {
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		try {
			String ruta = "C:\\Users\\aplod\\Desktop\\eclipse\\workspace\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\XML\\ficheros";
			
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(new File(ruta + "\\Empleados2.xml"));
			document.getDocumentElement().normalize(); //elimina nodos vacios
			
			System.out.printf("Elemento raiz: %s %n", document.getDocumentElement().getNodeName());
			//crea una lista con todos los nodos empleado
			NodeList empleados = document.getElementsByTagName("empleado");
			System.out.printf("Nodos empleado a recorrer: %d %n", empleados.getLength());
			
			//recorrer la lista
			for (int i = 0; i<empleados.getLength(); i++) { 
				Node emple = empleados.item(i); //seleccionar nodo
				if (emple.getNodeType() == Node.ELEMENT_NODE) { //comprobar que el nodo es nodo
					Element elemento = (Element) emple; //coger todos los elementos del empleado e imprimirlos
					System.out.printf("ID = %s %n", elemento.getAttribute("id"));
					System.out.printf(" * Apellido = %s %n", elemento.getElementsByTagName("apellido").item(0).getTextContent());
					System.out.printf(" * Departamento = %s %n", elemento.getElementsByTagName("dep").item(0).getTextContent());
					System.out.printf(" * Salario = %s %n", elemento.getElementsByTagName("salario").item(0).getTextContent());
				}
				
			}
		} catch (Exception e) { //en caso de excepcion, imprime el error
			e.printStackTrace();
		}
	} //fin del main
} //fin de la clase
