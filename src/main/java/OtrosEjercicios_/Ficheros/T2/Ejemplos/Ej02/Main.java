package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej02;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws excepcionEdad {
		Scanner scanner = new Scanner(System.in);
		Persona p = new Persona();
		System.out.println("Introduce tu edad");
		int age = scanner.nextInt();
		p.escribeEdad(age);
		System.out.println("Se ha guardado la edad");
		scanner.close();
	}
}
