package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej12;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {
		Agenda agenda = new Agenda();
		agenda.iniciar(); //inicia la agenda
		Scanner scanner = new Scanner(System.in);
		String accion = scanner.next();
		System.out.println(accion);
		boolean salir = false;
		while (!salir) { 
			switch (accion) { //selecciona entre las opciones de la agenda el comando a ejecutar, si no se encuentra entre ellos advierte de ello
			case ("salir"):
				agenda.salir();
				salir = true;
				break;
			case ("a�adir"):
				agenda.anadirCont(scanner.next(), scanner.next(), scanner.nextInt());
				break;
			case ("buscar"):
				agenda.buscarCont(scanner.next());
				break;
			case ("mostrar"):
				agenda.mostrar();
				break;
			default:
				System.out.println("El comando introducido no es v�lido");
				break;
			}
			if (!salir) {
				System.out.println();
				accion = scanner.next();
			}
		}
		System.out.println("Se ha cerrado la agenda");
		scanner.close();
	}

}
