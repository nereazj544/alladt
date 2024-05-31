package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej09;

import java.io.FileWriter;
import java.io.IOException;

public class EscribeFichero {
	static void ejemploEscribeFichTexto(String nombre) throws IOException {
		FileWriter out = null;
		try {
			out = new FileWriter("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej09.txt",
					true);
			out.write(nombre + "\n"); //escribir nombre introducido en llamada al metodo, y un intro
		} finally {
			if (out != null)
				out.close();
		}
	}
}
