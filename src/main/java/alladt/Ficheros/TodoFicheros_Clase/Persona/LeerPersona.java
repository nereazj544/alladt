package alladt.Ficheros.TodoFicheros_Clase.Persona;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.StreamCorruptedException;

public class LeerPersona {
	public static void main(String[] args) throws StreamCorruptedException {
		File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\Persona\\Persona.dat");
		try {
			ObjectInputStream obj = new ObjectInputStream(new FileInputStream(fl));
			int i = 1;
			while (true) {
				Persona p = (Persona) obj.readObject();
				System.out.println("Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// TODO: handle exception
		}
	}
}
