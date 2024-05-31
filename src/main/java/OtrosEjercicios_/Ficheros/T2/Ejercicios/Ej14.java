package OtrosEjercicios_.Ficheros.T2.Ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ej14 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej13.bin"));
		double n = ois.readDouble(); //lee el valor guardado en el fichero binario del ejercicio anterior
		ois.close();
		System.out.println(n);
	}
}
