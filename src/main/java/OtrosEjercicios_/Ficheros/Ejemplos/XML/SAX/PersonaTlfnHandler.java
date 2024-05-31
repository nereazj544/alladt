package OtrosEjercicios_.Ficheros.Ejemplos.XML.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;

public class PersonaTlfnHandler implements ContentHandler {
	
	private StringBuilder value;
	
	public PersonaTlfnHandler() {
		this.value = new StringBuilder();
	}

	@Override
	public void setDocumentLocator(Locator locator) {
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
	public void startPrefixMapping(String prefix, String uri) throws SAXException {
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
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

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length) throws SAXException {
	}

	@Override
	public void processingInstruction(String target, String data) throws SAXException {
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
	}
	
	
	
}
