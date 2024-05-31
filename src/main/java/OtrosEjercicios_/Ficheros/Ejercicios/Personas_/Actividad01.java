package OtrosEjercicios_.Ficheros.Ejercicios.Personas_;

import java.io.File;

/*
Realiza un programa Java que utilizando el m�todo list() de Files, muestre los ficheros de 
un directorio. El nombre del directorio se pasar� al programa desde los argumentos de main().
Si no hay argumento se muestra el mensaje "HAY QUE INTRODUCIR UN DIRECTORIO....". Si el 
directorio no existe se debe mostrar un mensaje indic�ndolo "DIRECTORIO INEXISTENTE"
*/

public class Actividad01 {
	public static void main(String[] args) {
		String dir = ".";
		if (dir.length() == 0) //si no se ha introducido un nombre de directorio
			System.out.println("Hay que introducir un directorio");
		else {
			File f = new File(dir);
			if (!f.exists()) //si no existe el archivo
				System.out.println("No existe el directorio " + dir);
			else {
				String[] archivos = f.list(); //coge los archivos en una lista
				System.out.printf("Ficheros en el directorio actual: %s %n", archivos.length);
				for (int i = 0; i < archivos.length; i++) { //imprime los archivos, mirando que tipo de archivo son
					File f2 = new File(f, archivos[i]);
					System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", archivos[i], f2.isFile(),
							f2.isDirectory());
				}
			}
		}

	}
}
