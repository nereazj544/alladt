package alladt.Ficheros.TodoFicheros_Clase.Persona;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class EscribirFichObject {

	public static void main(String[] args) throws IOException {
		Persona persona;
		File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\Persona.dat");
	       
        FileOutputStream out = new FileOutputStream(fl, true);
        ObjectOutputStream obj = new ObjectOutputStream(out);

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
        try {
        	for (int i = 0; i < edad.length; i++) {
        		Persona p = new Persona(nombre[i], edad[i]);
        		obj.writeObject(p);
        		System.out.println("> Ok grabado");
        	}
			
		} finally {
			// TODO: handle finally clause
			obj.close();
		}
	}

}
