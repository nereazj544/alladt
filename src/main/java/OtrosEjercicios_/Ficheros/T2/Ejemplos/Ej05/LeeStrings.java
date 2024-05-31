package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej05;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeStrings {
	public static void main(String[] args) throws IOException {
		BufferedReader ent = new BufferedReader(
				new FileReader("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\LeeStrings.txt"));
		String texto = "";
		String linea = ent.readLine();
		while (linea != null) {
			texto = texto + linea + "\n";
			linea = ent.readLine();
		}
		System.out.println(texto);
		ent.close();
	}
}
