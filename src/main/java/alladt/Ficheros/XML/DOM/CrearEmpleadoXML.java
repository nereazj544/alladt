package alladt.Ficheros.XML.DOM;

import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import java.io.*;

public class CrearEmpleadoXML {
public static void main(String[] args) {
    String ruta = "src\\main\\java\\alladt\\Ficheros\\XML\\ficheros";
    File fl = new File(ruta + "\\Empleados.xml");
    try (RandomAccessFile rf = new RandomAccessFile(fl, "r")){
        int id, dep, posicion = 0;
            Double salario;
            char apellido[] = new char[10], aux;

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            DOMImplementation dom = builder.getDOMImplementation();
            Document doc = dom.createDocument(null, "Empleados", null);

            while (posicion < rf.length()) {
                try {
                    rf.seek(posicion);
                    id = rf.readInt();

                    for (int i = 0; i < apellido.length; i++) {
                        aux = rf.readChar();
                        apellido[i] = aux;
                    }

                    String apellidos = new String(apellido).trim();
                    dep = rf.readInt();
                    salario = rf.readDouble();

                    if (id > 0) {
                        Element raiz = doc.createElement("empleado");
                        doc.getDocumentElement().appendChild(raiz);

                        CrearElemento("id", Integer.toString(id), raiz, doc);
                        CrearElemento("apellido", apellidos, raiz, doc);
                        CrearElemento("dep", Integer.toString(dep), raiz, doc);
                        CrearElemento("salario", Double.toString(salario), raiz, doc);
                    }
                    posicion += 36;
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }

            Source source = new DOMSource(doc);
            Result result = new StreamResult(new File(ruta + "\\Empleados.xml"));
            Transformer t = TransformerFactory.newInstance().newTransformer();
            t.transform(source, result);

        } catch (IOException | ParserConfigurationException | TransformerException e) {
            System.out.println("> El sistema no ha encontrado lo especificado.");
            System.out.println("> Error: ");
            e.printStackTrace();
        }
    }

    static void CrearElemento(String datoEmple, String valor, Element raiz, Document document) {
        Element elem = document.createElement(datoEmple); // creamos hijo
        Text text = document.createTextNode(valor); // damos valor
        raiz.appendChild(elem); // pegamos el elemento hijo a la raiz
        elem.appendChild(text); // pegamos el valor
    }
}
