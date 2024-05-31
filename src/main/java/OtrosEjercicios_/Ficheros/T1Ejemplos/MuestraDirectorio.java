package OtrosEjercicios_.Ficheros.T1Ejemplos;

import java.io.File;

public class MuestraDirectorio {

	public static void main(String[] args) {

		String ruta = ".";
		// creo una ruta

		if (args.length >= 1) {
			ruta = args[0];
			// compruebo que existe la ruta??
		}

		File fichero = new File(ruta);
		// creo un archivo que lleva a mi ruta??
		// si no existe pues no te va a ense�ar nada :b

		if (!fichero.exists()) { // si NO existe el fichero
			System.out.println("No existe el fichero o directorio en " + ruta);
		} else {
			if (fichero.isDirectory()) {
				System.out.println(ruta + "es un directorio con contenidos: ");
				File[] ficheros = fichero.listFiles();
				// creamos un array que va a contener los archivos de mi carpeta
				for (File f : ficheros) {
					String textoDescr = f.isDirectory() ? "/" : f.isFile() ? "_" : "?";
					// dependiendo de que tipo de archivo sea va a poner barritas o cosas??? idk
					System.out.println(textoDescr + " " + f.getName());
					// te escribe la ruta del archivo???
				}
			} else if (fichero.isFile()) {
				System.out.println(ruta + " es un fichero llamado " + fichero.getName());
			}

		}

	}

}
