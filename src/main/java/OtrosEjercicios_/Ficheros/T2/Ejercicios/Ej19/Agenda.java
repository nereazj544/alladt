package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Agenda {

	ObjectOutputStream oos;
	ObjectInputStream ois;

	Agenda() throws IOException {
		this.oos = new ObjectOutputStream(new FileOutputStream("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej19.bin"));
		this.ois = new ObjectInputStream(new FileInputStream("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej19.bin"));
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// FUNCIONES EDICION ARCHIVO
	///////////////////////////////////////////////////////////////////////////////////////////////

	void a�adirCont(String nom, String dni, int num) throws IOException {
		oos.write((nom + " " + dni + " " + num + "\n").getBytes());
		System.out.println("Contacto " + nom + " a�adido, por favor, reinicie el programa para guardar");
	}

	void buscarCont(String nom) throws IOException {
		System.out.println("Agenda buscar --- nom: " + nom);
		String linea = ois.readLine(); 
		boolean found = false;
		while (linea != null) {
			if (linea.contains(nom))
				System.out.println(linea);
			linea = ois.readLine();
		}
		if (found) {
			System.out.println("No se ha encontrado el contacto introducido" + "\n"
					+ "para a�adir un contacto bajo el nombre " + nom + " usa el comando 'a�adir'");
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	// FUNCIONES APP
	///////////////////////////////////////////////////////////////////////////////////////////////

	void iniciar() throws IOException {
		System.out.println("-- AGENDA --");
		byte[] bytes = ois.readAllBytes();
		for (Byte b : bytes) {
			System.out.println(b.toString());
		}
		System.out.println("-- LISTA DE COMANDOS --" + "\n" + "a�adir (contacto) (dni) (n�mero)" + "\n"
				+ "buscar (contacto)" + "\n" + "mostrar" + "\n" + "salir");
		ois = new ObjectInputStream(new FileInputStream("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej19.bin"));
	}

	public void mostrar() throws IOException { 
		byte[] bytes = ois.readAllBytes();
		for (Byte b : bytes) {
			System.out.println(b.toString());
		}
		ois = new ObjectInputStream(new FileInputStream("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej19.bin"));

	}

	void salir() throws IOException {
		ois.close();
		oos.close();
	}

}
