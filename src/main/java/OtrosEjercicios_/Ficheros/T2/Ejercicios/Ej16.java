package OtrosEjercicios_.Ficheros.T2.Ejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Ej16 {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
				"C:\\Users\\aplod\\Desktop\\ubicaciones_ficheros_eclipse\\Ejercicios_T2\\Ej15.bin"));
		Double dub = (double) (ois.read()); //lee el primer double
		while (dub != null) {
			System.out.println(dub);
			dub = (double) (ois.read()); //lee el siguiente valor double en el fichero binario
			if (dub == -1.0) {
				break;
			}
		}
		ois.close();
	}
}
