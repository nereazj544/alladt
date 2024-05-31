package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej11;

import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Excepcion, IOException {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			//escribir en el fichero cuando haya texto a escribir
			EscribeFichero.ejemploEscribeFichTexto(scanner.next());
			System.out.println("Se ha escrito en el fichero correctamente");
		}
		scanner.close();
	}
}
