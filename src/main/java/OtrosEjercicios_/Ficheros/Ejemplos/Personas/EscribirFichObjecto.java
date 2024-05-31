package OtrosEjercicios_.Ficheros.Ejemplos.Personas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * crea y escribe en un fichero 9 objectos de la clase Persona
 */

public class EscribirFichObjecto {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Persona persona;
		String ruta = "C:\\Users\\aplod\\git\\ADT_2DAM\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\Personas\\fichero";
		// declaro el fichero
		// File fic = new File(ruta +"FichPersona.dat");
		File fic = new File(ruta + "\\FichPersona.dat");
		try {
			// crear el flujo de salida, a�adir true para las pruebas de error con la
			// cabecera al leer
			// FileOutputStream fileout = new FileOutputStream(fic);
			FileOutputStream fileout = new FileOutputStream(fic, true);

			// conecta el flujo de bytes al flujo de datos
			ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

			// Datos de las personas
			String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andr�s", "Julio", "Antonio",
					"Mar�a Jes�s" };

			int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };

			System.out.println("GRABO LOS DATOS DE PERSONA.");
			for (int i = 0; i < edades.length; i++) { // recorro los arrays
				persona = new Persona(nombres[i], edades[i]); // creo la persona
				objectOS.writeObject(persona); // escribo la persona en el fichero
				System.out.println("GRABO LOS DATOS DE PERSONA.");
			}
			objectOS.close(); // cerrar stream de salida
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e2) {
			System.out.println("Error E/S" + e2);
		}
	}
}
