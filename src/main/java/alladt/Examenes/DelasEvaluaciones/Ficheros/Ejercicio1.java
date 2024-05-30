package alladt.Examenes.DelasEvaluaciones.Ficheros;

import java.io.File;

public class Ejercicio1 {
	public static void main(String[] args) {
		
		// establecemos la ruta
		String ruta = ".";
		if (args.length == 1) {
			ruta = args[0];
			// si la ruta se ha introducido en la RunConfigurations, se utilizará
			// sólo se ejecutará si se ha introducido una única ruta

			// creamos el archivo con la ruta especificada
			File file = new File(ruta);

			if (file.exists()) { // si la ruta existe:
				System.out.println("DIRECTORIO A ELIMINAR: " + ruta); // indicamos en la consola que directorio vamos a
																		// borrar
			borrarFiles(file); //llamamos al método que borra los archivos
			} else { // si la ruta NO existe
				System.out.println("NO EXISTE LA RUTA ");
			}
		}

	}

	public static void borrarFiles(File file) {
		File[] archivos = file.listFiles(); // recogemos los archivos del directorio en un array
		for (File f : archivos) { // para cada archivo
			if (f.isFile()) { // si es un archivo
				System.out.println("Archivo eliminado: " + f.getName());
				f.delete(); // se borra el archivo
			} else { // si es un directorio
				borrarFiles(f); // se entra al directorio, y se aplica el método de nuevo
				f.delete(); // se borra el directorio
				System.out.println("Directorio eliminado: " + f.getName());
			}
		}
	}

}
