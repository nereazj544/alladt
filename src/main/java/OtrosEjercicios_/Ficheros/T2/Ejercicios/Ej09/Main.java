package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej09;

import java.io.IOException;

public class Main {
	public static void main(String[] args) throws Excepcion, IOException {
		//llamadas al metodo con nombres a introducir
		EscribeFichero.ejemploEscribeFichTexto("Claudia Casero �lvarez");
		EscribeFichero.ejemploEscribeFichTexto("Mateo L�pez �lvarez");
		EscribeFichero.ejemploEscribeFichTexto("David Men�ndez Santos");
		EscribeFichero.ejemploEscribeFichTexto("�gueda Prieto Llamas");
		EscribeFichero.ejemploEscribeFichTexto("Nerea Zapatero Jara");
		System.out.println("Se ha escrito en el fichero correctamente");
	}
}
