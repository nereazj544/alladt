package OtrosEjercicios_.Ficheros.T2.Ejemplos.Ej01;

import java.util.Scanner;

public class CreacionExcepciones {
	public static void main(String[] args) {
		int a;
		int b;
		int res;
		Scanner teclado = new Scanner(System.in);
		System.out.println("Valor de a:");
		a = teclado.nextInt();
		if (a == 13)
			try {
				throw new ExcepcionVerificada("13!!!");
			} catch (ExcepcionVerificada ex) {
				System.out.println("Error: " + ex.getMessage());
				return;
			}
		System.out.println("Valor de b:");
		b = teclado.nextInt();
		if (b == 13)
			try {
				throw new ExcepcionVerificada("13!!!");
			} catch (ExcepcionVerificada ex) {
				System.out.println("Error: " + ex.getMessage());
				return;
			}
		res = a * b;
		System.out.println("Resultado: " + res);
	}
}
