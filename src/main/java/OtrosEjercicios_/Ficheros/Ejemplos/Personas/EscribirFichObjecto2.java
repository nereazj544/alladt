package OtrosEjercicios_.Ficheros.Ejemplos.Personas;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
 * crea y escribe en un fichero 9 objectos de la clase Persona
 */

public class EscribirFichObjecto2 {
	public static void main(String[] args) {
		Persona persona;
		String ruta = "C:\\Users\\aplod\\Desktop\\eclipse\\workspace\\AccesoADatos_2DAM\\src\\Isabel\\Ejemplos\\Personas\\fichero";

		// declaro el fichero
		File fic = new File(ruta + "\\fichPersona.dat");
		boolean existe = false;
		if (fic.exists())
			existe = true;
		try {
			// crear el flujo de salida, a�adir true para las pruebas de error con la
			// cabecera al leer
			FileOutputStream fileout = new FileOutputStream(fic, true);

			// conecta el flujo de bytes al flujo de datos
			MiObjectOutputStream oos = new MiObjectOutputStream(fileout);
			// se reescribe la clase ObjectOutputStream para el almacenamiento de headers,
			// que impide la posterior lectura del archivo
			ObjectOutputStream objectOS = new ObjectOutputStream(fileout);

			// datos de las personas
			String nombres[] = { "Ana", "Luis Miguel", "Alicia", "Pedro", "Manuel", "Andr�s", "Julio", "Antonio",
					"Maria Jes�s" };
			int edades[] = { 14, 15, 13, 15, 16, 12, 16, 14, 13 };
			System.out.println("GRABO LOS DATOS DE PERSONA.");

			for (int i = 0; i < edades.length; i++) { // recorro los arrays
				persona = new Persona(nombres[i], edades[i]); // creo la persona
				oos.writeObject(persona);
				System.out.println("GRABO LOS DATOS DE PERSONA.");
			}
//			objectOS.close(); //cerrar stream de salida
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
