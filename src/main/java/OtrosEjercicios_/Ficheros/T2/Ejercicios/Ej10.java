package OtrosEjercicios_.Ficheros.T2.Ejercicios;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Ej10 {
	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		BufferedReader in = new BufferedReader(
				new FileReader("C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej09.txt"));
		//lector del archivo 
		
		String linea = "";
		int numChrs = 0, numLns = 0, numWrd = 0;
		
		
		while (linea != null) { //si la linea tiene contenido
			numChrs = numLns = numWrd = 0; //resetear valores
			for (int i = 0; i < 20; i++) { //para que aparezcan 20 lineas por pagina
				linea = in.readLine();
				if (linea != null) { 
					numLns++; //si la linea no es nula, a�ade uno al numero de lineas
					String[] words = linea.split(" ");
					numWrd += words.length; //se cuentan las palabras de la linea
					System.out.println(linea);
					numChrs += linea.length(); //se cuentan los caracteres de la linea
				}
			}
			if (linea != null) {  //imprime el final de la pagina en caso de que no haya llegado al final del documento
				System.out.println("Num. L�neas -> " + numLns + "     Num. Palabras -> " + numWrd + "     Num. Chars. -> " + numChrs);
				System.out.println("--PULSA 'ENTER' PARA VER LA SIGUIENTE PAGINA--");
				scanner.nextLine();
			}
		}
		//imprime el final del documento
		System.out.println("Num. L�neas -> " + numLns + "     Num. Palabras -> " + numWrd + "     Num. Chars. -> " + numChrs);
		System.out.println("--FIN DOCUMENTO--");
		
		in.close();
		scanner.close();
		//cerrar recursos abiertos
	}
}
