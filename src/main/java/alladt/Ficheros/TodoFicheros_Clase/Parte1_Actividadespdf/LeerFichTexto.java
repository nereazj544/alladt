package alladt.Ficheros.TodoFicheros_Clase.Parte1_Actividadespdf;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LeerFichTexto {

	public static void main(String[] args) throws IOException {
		File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\Lorem.txt");
		FileReader fr = new FileReader(fl);
		int i;
		//Propuesta de ejercio
		char b [] = new char[30];
		while ((i = fr.read(b)) != -1) {
			System.out.println(b);
			
		}
		fr.close();

	}

}