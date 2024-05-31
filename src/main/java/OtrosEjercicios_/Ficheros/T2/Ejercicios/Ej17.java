package OtrosEjercicios_.Ficheros.T2.Ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class Ej17 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Introduce una frase");
		String s = scanner.next(); //guarda la siguiente frase
		scanner.close();
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej13.bin"));
		oos.writeBytes(s); //guarda la frase
		oos.close();
		System.out.println("Se ha guardado la frase");
		
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej13.bin"));
		String out = "";
		try {
			out = ois.readAllBytes().toString(); //guarda la frase del fichero en un String
		} catch (IOException e) {
			System.out.println("ha fallado");
		}
		ois.close();
		System.out.println(out);
	}
}
