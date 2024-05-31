package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej18;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Scanner scanner = new Scanner(System.in);
		InputData in = new InputData("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej18.txt");
		System.out.println("Introduce una frase � una l�nea vac�a para terminar el proceso");
		String s = scanner.nextLine();
		while (!s.isBlank()) { //guarda frases hasta que se introduzca una linea vacia
			s = scanner.nextLine();
			in.input(s); //InputData
		}
		OutputData out = new OutputData("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej18.txt");
		System.out.println(out.output()); //imprime las frases
		scanner.close();
	}
}
