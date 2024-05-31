package OtrosEjercicios_.Ficheros.Ejemplos.XML.SAX;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class LeerPersonasTlfn {
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		String ruta = "C:\\Users\\aplod\\Desktop\\eclipse\\workspace\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\XML\\SAX\\ficheros";
		SAXParserFactory factory = SAXParserFactory.newInstance(); //creamos la base del parser
		SAXParser parser = factory.newSAXParser(); //creamos el parser
			// un parser basicamente traduce el xml a un formato que se puede leer?

		PersonaTlfnHandlerDH handlerDH = new PersonaTlfnHandlerDH();
			//el handler "adapta" el parser, hace que podamos adaptar la traduccion a nuestras necesidades
		parser.parse(ruta + "\\PersonasTlfn.xml", handlerDH); //con extends DefaultHandler, podemos hacer que parsee directamente la ruta sin necesidad de un reader
		//aqui se termina la opci�n 1
		
		XMLReader reader = parser.getXMLReader(); //no se que hace el reader exactamente? creo que permite que se traduzca a string somehow
		PersonaTlfnHandler handler = new PersonaTlfnHandler(); 
		reader.setContentHandler(handler); //el reader necesita un handler, que es la manera de traducir creo?
			//este handler est� hecho con implements ContentHandler
				//CREO que defaultHandler es una clase base para que no se tengan que implementar todos los metodos vacios
		InputSource xml = new InputSource(ruta + "\\PersonasTlfn.xml"); //la input source nos selecciona la ruta de la que queremos coger el archivo
		reader.parse(xml); //parseamos directamente
		//aqu� termina la opci�n 2
	}
}
