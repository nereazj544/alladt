package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej04;

import java.io.FileWriter;
import java.io.IOException;

public class EscribeFichero {
	static void ejemploEscribeFichTexto(String nomFich, int i, double x, String str) throws IOException {
		FileWriter out = null;
		try {
			out = new FileWriter("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\EscribeFichero.txt");
			out.write("Entero: " + i + " Real: " + x + "\n");
			out.write("String: " + str);
		} finally {
			if (out != null)
				out.close();
		}
	}
}
