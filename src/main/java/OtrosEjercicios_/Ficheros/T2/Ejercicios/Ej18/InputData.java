package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej18;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InputData {
	
	ObjectOutputStream oos;
	
	InputData(String s) throws FileNotFoundException, IOException {
		this.oos = new ObjectOutputStream(new FileOutputStream(s, true));
	}
	
	public String input(String s) throws FileNotFoundException, IOException {
		if (s.isBlank()) 
			return null;
		byte[] bit = s.getBytes();
		oos.write(bit);
		oos.write((byte) '\n');
		System.out.println("Introduce una frase � una l�nea vac�a para terminar el proceso");
		return s;
	}
}
