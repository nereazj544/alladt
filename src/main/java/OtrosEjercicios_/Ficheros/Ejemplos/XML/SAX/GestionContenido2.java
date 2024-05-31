package OtrosEjercicios_.Ficheros.Ejemplos.XML.SAX;

import java.util.jar.Attributes;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Clase que hereda de DefaultHandler, tratando los eventos basicos
 * inicio y fin de documento
 * inicio y fin de etiqueta encontrada
 * datos caracter encontrados
 */

public class GestionContenido2 extends DefaultHandler {
	
	public GestionContenido2() {
		super();
	}
	
	@Override
	public void startDocument() {
		System.out.println("Comienzo del documento XML");
	}
	
	@Override
	public void endDocument() {
		System.out.println("Final del documento XML");
	}
	
	public void startElement(String uri, String nombre, String nombreC, Attributes atts) {
		System.out.printf("\t Principio Elemento: %s %n", nombre);
	}
	
	@Override
	public void endElement(String uri, String nombre, String nombreC) {
		System.out.printf("\t Fin Elemento: %s %n", nombre);
	}
	
	@Override
	public void characters(char[] ch, int inicio, int longitud) throws SAXException {
		String car = new String(ch, inicio, longitud);
		car = car.replaceAll("[\t\n]", ""); //para que ponga "" en vez de un tabulador/salto de linea
		System.out.printf("\t Caracteres: %s %n", car);
	}
	
}
