package OtrosEjercicios_.Ficheros.Ejemplos.XML.DOM;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXML {
	public static void main(String[] args) throws IOException {
		String ruta = "C:\\Users\\aplod\\git\\ADT_2DAM\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\XML\\DOM\\ficheros";
		File fichero = new File(ruta + "\\Empleados.dat");
		RandomAccessFile file = new RandomAccessFile(fichero, "r");

		int id, dep, posicion = 0; // para situarnos al principio del fichero
		Double salario;
		char apellido[] = new char[10], aux;

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		// Creamos una instancia de DocumentBuilderFactory para crear el parser. Entre try-catch
		try {
			DocumentBuilder builder = factory.newDocumentBuilder();
			// Creamos un documento vacio de nombre document, con el nodo raiz de nombre Empleados y asignamos la version XML (1.0)
			// la interfaz DOMImplementation permite crear objetos Document con nodo raiz
			DOMImplementation implementation = builder.getDOMImplementation();
			Document document = implementation.createDocument(null, "Empleados", null);
			document.setXmlVersion("1.0");

			for (;;) { //for(;;) es equivalente a while(true)
				file.seek(posicion); // nos posicionamos
				id = file.readInt(); // obtengo id de empleado
				for (int i = 0; i < apellido.length; i++) {
					aux = file.readChar();
					apellido[i] = aux;
				}
				String apellidos = new String(apellido);
				dep = file.readInt();
				salario = file.readDouble();

				if (id > 0) { // id validos a partir de 1
					Element raiz = document.createElement("empleado"); // creamos nodo empleado
					document.getDocumentElement().appendChild(raiz); // lo pegamos a la ra�z del documento

					// a�adir ID
					CrearElemento("id", Integer.toString(id), raiz, document);
					CrearElemento("apellido", apellidos.trim(), raiz, document);
					CrearElemento("dep", Integer.toString(dep), raiz, document);
					CrearElemento("salario", Double.toString(salario), raiz, document);
				}
				posicion = posicion + 36; // me posiciono para el siguiente empleado
				if (file.getFilePointer() == file.length())
					break;
			} // fin del for que recorre el fichero

			// Crear la fuente XML a partir del documento
			Source source = new DOMSource(document);
			// Crear el resultado en el fichero Empleados.xml
			Result result = new StreamResult(new java.io.File(ruta + "\\Empleados.xml"));
			// Se obtiene un TransformerFactory
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			// Se realiza la transformaci�n del documento al fichero
			transformer.transform(source, result);
		} catch (Exception e) {
			System.err.println("Error: " + e);
		}
		file.close(); // cerrar fichero
	} // fin del main

	// Insercci�n de los datos del empleado
	static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
		Element elem = document.createElement(datoEmple); // creamos hijo
		Text text = document.createTextNode(valor); // damos valor
		raiz.appendChild(elem); // egamos el elemento hijo a la raiz
		elem.appendChild(text); // pegamos el valor
	}
} // fin de la clase
