package OtrosEjercicios_.Ficheros.T2.Ejercicios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej15 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej15.bin"));
		System.out.println("Introduce un valor num�rico");
		Double dub = scanner.nextDouble(); //guarda el primer valor double introducido por consola
		while (dub >= 0 && dub != null) { //mientras que los siguientes valores sean doubles positivos
			oos.write(dub.byteValue()); //se escriben en el fichero binario
			System.out.println("Se ha guardado el valor" + "\n" + "Introduce un valor num�rico");
			dub = scanner.nextDouble(); //se guarda el siguiente double
		}
		oos.close();
		scanner.close();
		System.out.println("Se ha guardado el fichero");
	}
}
