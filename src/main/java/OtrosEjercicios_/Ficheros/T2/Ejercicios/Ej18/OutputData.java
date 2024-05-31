package OtrosEjercicios_.Ficheros.T2.Ejercicios.Ej18;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class OutputData {
	
	ObjectInputStream ois;
	
	OutputData(String s) throws FileNotFoundException, IOException {
		this.ois = new ObjectInputStream(new FileInputStream(s));
	}
	
	public String output() throws FileNotFoundException, IOException {
		//imprime las frases
		String output = ois.readUTF();
		return output;
	}
}
