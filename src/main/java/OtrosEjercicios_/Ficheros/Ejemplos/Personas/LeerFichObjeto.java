package OtrosEjercicios_.Ficheros.Ejemplos.Personas;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LeerFichObjeto {
	public static void main(String[] args) {
		Persona persona;
		String ruta = "C:\\Users\\aplod\\Desktop\\eclipse\\workspace\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\Personas\\fichero\\fichPersona.dat";
		File fic = new File(ruta);
		try {
			// crea un flujo de entrada y lo conecta a los datos
			FileInputStream fis = new FileInputStream(fic);
			ObjectInputStream ois = new ObjectInputStream(fis); 
			
			//coje de los datos la primera instancia de la clase Persona
			persona = (Persona) ois.readObject(); 
			
			//este int contar� el n�mero de personas
			int i = 1;
			
			//mientras la clase de la variable persona sea Persona
			do {
				//imprime las personas, cambia el n�mero, y coje la siguiente instancia de Persona
				System.out.println(i + " => Nombre: " + persona.getNombre() + ", Edad: " + persona.getEdad());
				i++;
				persona = (Persona) ois.readObject();
			} while (persona.getClass() == Persona.class);
			ois.close();
			
		//si no existiese la clase 
		} catch (ClassNotFoundException e) {
			//no se van a cumplir las condiciones para esta excepci�n
			
		//si llegase al final del archivo 
		} catch (EOFException e) {
			System.out.println("FIN DEL ARCHIVO");
			
		//si hubiese alguna otra excepci�n
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
