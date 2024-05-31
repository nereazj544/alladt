package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej09;

import java.io.IOException;

public class Excepcion extends Throwable {
	
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) throws IOException {
		String a = args[0];
		EscribeFichero.ejemploEscribeFichTexto(a);
		//lanza la excepcion si no se puede escribir el nombre
	}
}
