package OtrosEjercicios_.Ficheros.T2.Ejercicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej13 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce un valor num�rico");
		Double dub = scanner.nextDouble(); //guarda el proximo valor double escrito en la consola
		scanner.close();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej13.bin"));
		oos.writeDouble(dub); //escribe el valor en el fichero binario
		oos.close();
		System.out.println("Se ha guardado el valor num�rico");
	}
}
