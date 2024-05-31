package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Agenda {

	BufferedReader in;
	FileWriter out;

	Agenda() throws IOException {
		this.in = new BufferedReader(
				new FileReader("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej12.txt"));
		this.out = new FileWriter("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej12.txt",
				true);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	// FUNCIONES EDICION ARCHIVO
	///////////////////////////////////////////////////////////////////////////////////////////////

	void a�adirCont(String nom, String dni, int num) throws IOException { //a�adir Nombre DNI 123123123
		//a�ade un contacto a la agenda
		out.write(nom + " " + dni + " " + num + "\n"); //escribe el contacto con la estructura //Nombre DNI 123123123
		System.out.println("Contacto " + nom + " a�adido, por favor, reinicie el programa para guardar");
	}

	void buscarCont(String nom) throws IOException { //buscar Nombre
		//busca un contacto en la agenda. ense�ara todos los contactos introducidos
		System.out.println("Agenda buscar --- nom: " + nom);
		String linea = in.readLine(); 
		boolean found = false;
		while (linea != null) { //recoge cada linea de la agenda y muestra los resultados iguales
			if (linea.equals(nom)) {
				found = true;
				System.out.println(linea);
			}
			linea = in.readLine();
		}
		if (found) { //si no se ha encontrado
			System.out.println("No se ha encontrado el contacto introducido" + "\n"
					+ "para a�adir un contacto bajo el nombre " + nom + " usa el comando 'a�adir'");
		}

	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	// FUNCIONES APP
	///////////////////////////////////////////////////////////////////////////////////////////////

	void iniciar() throws IOException { //iniciar
		//ense�a los contenidos de la agenda y los comandos que se pueden introducir
		in.mark(100000);
		String linea = "";
		System.out.println("-- AGENDA --");
		do {
			linea = in.readLine();
			if (linea != null)
				System.out.println(linea);
		} while (linea != null);
		System.out.println("-- LISTA DE COMANDOS --" + "\n" + "a�adir (contacto) (dni) (n�mero)" + "\n"
				+ "buscar (contacto)" + "\n" + "mostrar" + "\n" + "salir");
		in.reset();
	}

	public void mostrar() throws IOException { //mostrar
		//muestra los contactos almacenados
		String linea = in.readLine();
		while (linea != null) {
			System.out.println(linea);
			linea = in.readLine();
		}
		in.reset();
	}

	void salir() throws IOException { //salir
		//guarda y cierra la agenda
		in.close();
		out.close();
	}

}
