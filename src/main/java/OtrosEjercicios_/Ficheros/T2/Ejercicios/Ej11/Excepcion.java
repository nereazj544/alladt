package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej11;

import java.io.IOException;

public class Excepcion extends Throwable {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		//lanza excepcion si no se puede escribir la frase
		String a = args[0];
		EscribeFichero.ejemploEscribeFichTexto(a);
	}
}
