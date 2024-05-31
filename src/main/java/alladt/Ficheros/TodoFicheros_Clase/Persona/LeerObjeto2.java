package alladt.Ficheros.TodoFicheros_Clase.Persona;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;



public class LeerObjeto2 {
public static void main(String[] args) throws FileNotFoundException, IOException {
	File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\Persona.dat");
	
	ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fl));
	
	int i = 1;
	try {
		while (true) {
			Persona persona = (Persona) obj.readObject();
			System.out.println("> Persona" + i);
			i++;
			System.out.printf("Nombre: %s, edad: %d %n", persona.getNombre(), persona.getEdad());
			
		}
		
	} catch (EOFException e) {
		System.out.println("final de fichero");
	}catch (StreamCorruptedException e) {
	}catch (ClassNotFoundException e) {
		System.out.println("Error: \n");
		e.printStackTrace();
	}finally {
		obj.close();
	}
}
}
