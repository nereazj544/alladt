package alladt.Ficheros.TodoFicheros_Clase.randomsccessfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerFicheroAleatorioUnReg {
public static void main(String[] args) {
	File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\Aleatorio.dat");
	if (args.length != 1) {
		System.out.println("No hay parametos");
		System.exit(0);
	}
	String x = args[0];
	
	try (RandomAccessFile rf = new RandomAccessFile(fl, "r")){
		int id;
		String apellido = "";
		Double salario ;
		int poscion;
		int xx =Integer.parseInt(x);
		
		for (int i = 0; i < 10; i++) {
			apellido += rf.readChar();
		}
		poscion = ((xx - 1) * 36);
		if (poscion >= rf.length()) {
			System.out.println("ID no existe");
		}else {
			rf.seek(poscion);
			System.out.println(apellido);
			System.out.println(rf.readInt());
			System.out.println(rf.readInt());
			System.out.println(rf.readDouble());
			
		}
		
	}catch (FileNotFoundException e) {
		System.out.println("> El sistema no ha encontrado el archivo expecificado.");
		System.out.println("> Error: ");
		e.printStackTrace();
		
	} 
	catch (IOException e) {
		System.out.println("> El sistema no ha encontrado lo expecificado.");
		System.out.println("> Error: ");
		e.printStackTrace();
	}
	
	
}
}
