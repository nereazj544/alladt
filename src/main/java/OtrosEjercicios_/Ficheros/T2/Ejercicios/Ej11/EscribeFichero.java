package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej11;

import java.io.FileWriter;
import java.io.IOException;

public class EscribeFichero {
	static void ejemploEscribeFichTexto(String linea) throws IOException {
		FileWriter out = null;
		try {
			out = new FileWriter("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej11.txt",
					true);
			out.write(linea + "\n"); //escribe en el fichero la linea
		} finally {
			if (out != null)
				out.close();
		}
	}
}
