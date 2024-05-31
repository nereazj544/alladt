package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej20;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		InputData in = new InputData(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej18.txt");
		System.out.println("Introduce una frase � una l�nea vac�a para terminar el proceso");
		String s = "";
		while (s != null) {
			s = scanner.nextLine();
			if (!s.isBlank())
				in.input(s);
			else
				break;
		}
		OutputData out = new OutputData(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej18.txt");
		out.output();
		scanner.close();
	}
}
