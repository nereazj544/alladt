package OtrosEjercicios_.Ficheros.Ejercicios.Personas_;

import java.io.File;
import java.util.Scanner;

/*
Borrar un directorio, por ejemplo el que has creado en el ejercicio anterior.

Si el directorio contiene archivos, no se puede borrar, lanza un mensaje de advertencia 
y lista lo que contiene el directorio.

Puedes completar el ejercicio de manera que: Primero elimines los archivos que contiene 
el directorio y luego elimines el directorio.

Tratar excepciones, es suficiente con que visualice el StackTrace.
*/

public class BorrarDir {
	public static void main(String[] args) {
		String ruta = "C:\\Users\\aplod\\Downloads" + "\\CrearDir";
		// crea una string a la que le asignamos la ruta que queremos usar
		// para cambiar la ruta, hay que cambiar la String; en este caso, va a borrar la
		// carpeta creada por la actividad 2 (CrearDir)

		Scanner scanner = new Scanner(System.in);
		// crea un scanner para posteriormente decidir si borrar un fichero o no. (linea
		// 23)

		File f = new File(ruta);
		// crea un objeto archivo "f" en el que se almacena la ruta introducida en la
		// String "ruta"

		if (f.isDirectory()) { // comprueba que "f" es un directorio
			if (f.list().length > 0) { // si el directorio contiene archivos, te pregunta si quieres borrarlos
				System.out.println("El directorio tiene archivos dentro, �quiere borrar estos archivos? (Y/N)");
				String[] lista = f.list();
				for (int i = 0; i < lista.length; i++)
					System.out.println("- " + lista[i]); //imprime los archivos dentro del directorio
				String ans = scanner.next().toUpperCase(); //recoge la respuesta dada
				if (ans.equals("Y")) { //en caso de que la respuesta sea s� (yes)
					for (int i = 0; i < lista.length; i++) {
						File borrar = new File(ruta + "\\" + lista[i]); 
						borrar.delete();
						// crea un objecto archivo "borrar" en el que se almacena la ruta del archivo a borrar, posteriormente lo borra con el metodo delete()
					}
					f.delete(); //borra el directorio en el que se han almacenado los archivos
					System.out.println("Se han eliminado los archivos");
				} else { //si la respuesta a borrar el archivo es no
					System.out.print("Se ha cancelado la opci�n");
					if (!ans.equals("N")) //en caso de que se haya introducido un comando incorrecto, cancela la operaci�n y te informa de ello
						System.out.println(" debido a un comando incorrecto");
				}
			} else { //si el directorio est� vacio
				f.delete();
				System.out.println("Se ha eliminado el directorio");
			}

		}
		scanner.close(); //cierra el scanner
	}
}