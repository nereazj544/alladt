package alladt.Ficheros.TodoFicheros_Clase.Persona;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

public class EscribirPersona {
public static void main(String[] args) {
	File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\Persona\\Persona.dat");
	if (!fl.exists()) {
		MiObjetoOut miObjetoOut;
	}
	
	try {
		FileOutputStream out = new FileOutputStream(fl, true);
		ObjectOutputStream ob = new ObjectOutputStream(out);
		
		
		String[] nombre = {
	            "Kilari Miracle",
	            "Galio (Tablei) Miracle",
	            "Alyssa O’Doherty",
	            "Brantley (Bran) Slora",
	            "Kirian Slora",
	            "Bahir Loughty",
	            "Coral Loughty",
	            "Gemma Berrycloth",
	            "Bosco Berrycloth" };

	    int[] edad = { 18, 17, 18, 17, 18, 17, 17, 18 };
	    
	    
	    for (int i = 0; i < edad.length; i++) {
			Persona p = new Persona(nombre[i], edad[i]);
			ob.writeObject(p);
			System.out.println("> OK");
		}
	    ob.close();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	
	
}
}
