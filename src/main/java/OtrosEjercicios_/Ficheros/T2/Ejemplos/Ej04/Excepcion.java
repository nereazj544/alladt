package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej04;

import java.io.IOException;

public class Excepcion extends Throwable {
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(args[1]);
		double b = Double.parseDouble(args[2]);
		EscribeFichero.ejemploEscribeFichTexto(args[0], a, b, args[3]);
	}
}
