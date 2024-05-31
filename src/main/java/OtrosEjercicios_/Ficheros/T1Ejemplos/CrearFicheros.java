package OtrosEjercicios_.Ficheros.T1Ejemplos;

import java.io.File;

public class CrearFicheros {

	public static void main(String[] args) { // VA A CREAR UNA CARPETA EN LA RUTA
		// run configurations > arguments

		File directorio = new File(".\\prueba");
		// creamos ruta?

		if (directorio.mkdir()) {
			System.out.print("Directorio creado"); // crea una carpeta
		} else {
			System.out.print("Directorio no creado");
			if (directorio.exists())
				System.out.print(": directorio ya existe");
			else
				System.out.print(": raz�n desconocida");
		}

	}

}
