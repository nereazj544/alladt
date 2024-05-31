package OtrosEjercicios_.Ficheros.T1Ejemplos;

import java.io.File;

public class BorrarFicheros {

	public static void main(String[] args) {

		File fichero = new File(".\\prueba\\datos.txt");

		if (fichero.delete()) {
			System.out.println("Fichero eliminado");
		} else {
			System.out.print("Fichero no eliminado. ");
			if (!fichero.exists())
				System.out.println("Raz�n: fichero no existe");
			else
				System.out.println("Raz�n desconocida");
		}

		File directorio = new File(".\\maniobra");
		if (directorio.delete()) {
			System.out.print("Directorio eliminado. ");
		} else {
			System.out.print("Fichero no eliminado. ");
			if (!fichero.exists())
				System.out.println("Raz�n: fichero no existe");
			else
				System.out.println("Raz�n desconocida");
		}

	}

}
