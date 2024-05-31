package OtrosEjercicios_.Ficheros.Ejemplos.XML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PersonaTlfnHandlerDH extends DefaultHandler {
	
	private StringBuilder value;
	
	public PersonaTlfnHandlerDH() {
		this.value = new StringBuilder();
	}

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Comienzo de PersonasTlfn.XML");
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Final PersonasTlfn.XML");
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
		this.value.setLength(0);
		if(qName.equals("persona")) {
			String tlfn = atts.getValue("telefono");
			System.out.println("Atributo tel�fono: " + tlfn);
		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		switch (qName) {
		case "persona": 
			System.out.println("");
			break;
		case "nombre": 
			System.out.println("Nombre: " + this.value.toString());
			break;
		case "edad": 
			System.out.println("Edad: " + this.value.toString());
			break;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		this.value.append(ch, start, length);
	}
	
	
}
