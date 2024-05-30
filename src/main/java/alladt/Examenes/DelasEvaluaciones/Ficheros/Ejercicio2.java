package alladt.Examenes.DelasEvaluaciones.Ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {

		// introducimos la ruta (INTRODUCIR SOLO DIRECTORIO)
		String ruta = "";
		if (args.length == 1) {
			ruta = args[0]; // el programa sólo funcionará si se introduce una única ruta
			
			
			
			// se crea el archivo con la ruta especificada
			File file = new File(ruta, "refranes.txt");
			
			//creamos una lista para el posterior almacenamiento de las lineas
			List<String> lista = new ArrayList<>();
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(file)); // creamos el lector de archivos
				br.lines().forEach((s) -> {
					System.out.println(s);
					lista.add(s);
				}); // imprimimos cada línea del archivo, y la metemos en una lista
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}

			
			// se crea el archivo en el que introduciremos los refranes reescritos
			File file2 = new File(ruta, "refranesCONvocalintroducida.txt");
			
			//creamos un scanner que leerá el primer caracter introducido
			Scanner scanner = new Scanner(System.in); //creacion scanner
			System.out.println("Introducir vocal deseada: ");
			String caracter = scanner.next(); //se lee la linea introducida
			scanner.close(); //se cierra el scanner
			char car = caracter.charAt(0); //se transforma a caracter
			
			try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(file2)); //se crea el BufferedWriter que escribira el archivo
				lista.forEach((s)-> { //para cada frase
					String frase = "";
					for (char c : s.toCharArray()) {
						if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
							c = car; //si el caracter es una vocal, se cambia por la vocal especificada previamente
						frase += c; //se añade el caracter a la frase
					}
					try {
						bw.write(frase); //se añade la frase al archivo
						bw.newLine(); //se crea una linea nueva (para que no se guarde todo en una sola linea)
					} catch (IOException e) {
						e.printStackTrace();
					}
				});
				System.out.println("Se ha escrito el archivo"); //al finalizar, se indica que se ha escrito el archivo
				bw.close(); //se cierra el BufferedWriter
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}
}
