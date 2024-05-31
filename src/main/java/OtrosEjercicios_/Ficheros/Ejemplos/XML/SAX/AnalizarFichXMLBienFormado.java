package OtrosEjercicios_.Ficheros.Ejemplos.XML.SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

/*
 * Analiza si el fichero XML est� bien formado
 * @args ruta
 * fichero mal formado en 2� etiqueta <alumnos> sobre la sbb
 * fichero bien formado ruta
 * Necesita la clase DocHandler.java
 */

public class AnalizarFichXMLBienFormado {
	public static void main(String[] args) throws ParserConfigurationException {
		if (args.length != 1) {
			System.out.println("Debe haber un par�metro (el fichero)");
		}
		else {
			String fich = args[0];
			System.out.println("Analizando: " + fich + "\n");
			try {
				//Creamos una instancia del analizador (clase SAXParser), que vamos a manejar a trav�s de la interfaz XMLReader
				SAXParserFactory sfactory = SAXParserFactory.newInstance();
				SAXParser parser = sfactory.newSAXParser();
				//Para analizar el documento llamamos al m�todo parse, pas�ndole el fichero que sea
				
				XMLReader xmlparser = parser.getXMLReader();
				xmlparser.setContentHandler(new AnalizaDocHandler());
				xmlparser.parse(new InputSource(fich));
				
				System.out.println("Fin del an�lisis: sin errores");
			} catch (IOException e) {
				System.out.println(e);
				//si hay alg�n problema con el an�lisis, se genera una excepci�n SAXException y el an�lisis se detiene. 
			} catch (SAXException e) {
				System.out.println(e);
			} 
		}
	}
} 
