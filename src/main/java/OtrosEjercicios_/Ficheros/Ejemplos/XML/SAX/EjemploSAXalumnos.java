package OtrosEjercicios_.Ficheros.Ejemplos.XML.SAX;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class EjemploSAXalumnos {
	public static void main(String[] args) throws FileNotFoundException, IOException, SAXException, ParserConfigurationException {
		//// Como la clase XMLReaderFactory esta obsoleta desde la version 9, utilizo la recomendada ahora. 
		// Se crea una instancia de la ipleentaci�n predeterminada de SAXParserFacotry
//		XMLReader procesadorXML = XMLRederFActory.createXMLReader();
		String ruta = "C:\\Users\\aplod\\git\\ADT_2DAM\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\XML\\SAX\\ficheros\\";
		
		SAXParserFactory parserFactory = SAXParserFactory.newInstance();
		// Se especifica que el parser producido por este codigo tendr� soporte para espacios de nombre XML
		parserFactory.setNamespaceAware(true);
		// Se crea una instancia de SAXParser usando loos parametros actuales del SAXParserFactory
		SAXParser parser = parserFactory.newSAXParser();
		// Se crea el objeto procesador de XML
		XMLReader procesadorXML = parser.getXMLReader();
		
		GestionContenido2 gestor = new GestionContenido2();
		procesadorXML.setContentHandler(gestor);
		InputSource fileXML = new InputSource(ruta + "\\alumnos.xml");
		procesadorXML.parse(fileXML);
	}
}