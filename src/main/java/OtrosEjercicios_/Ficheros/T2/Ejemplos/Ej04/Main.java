package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej04;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Excepcion, IOException {
		EscribeFichero ef = new EscribeFichero();
		EscribeFichero.ejemploEscribeFichTexto("idk", 2, 3, "hola");
		System.out.println("Se ha escrito en el fichero correctamente");
	}
}
