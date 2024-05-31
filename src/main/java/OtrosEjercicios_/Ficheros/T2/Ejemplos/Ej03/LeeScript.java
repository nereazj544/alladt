package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LeeScript {
	public static void main(String[] args) throws IOException {
		String str = "", num;
		double x = 0;
		BufferedReader ent = null;

		try {
			ent = new BufferedReader(new FileReader("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\d2.txt"));
			do {
				str = ent.readLine(); // lee una l�nea
				if (str != null) {
					System.out.println("Texto: " + str);
					num = ent.readLine();
					try {
						x = Double.parseDouble(num);
						System.out.println("Numero: " + x);
					} catch (NumberFormatException e) {
						System.out.println("Error al leer el numero real: " + num);
					} // try
				} // if
			} while (str != null);
		} finally {
			if (ent != null) {
				System.out.println(str + " " + x);
				ent.close();
			}
		} // try
	} // main
} // close
