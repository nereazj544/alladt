package alladt.Ficheros.TodoFicheros_Clase.Parte1_Actividadespdf;

import java.io.File;

public class VerDirActul {

	public static void main(String[] args) {
		System.out.println("Introduce por argumemto la ruta");
		String dir = args[0];
		
		if (args.length > 1) {
			System.out.println("No has introducido una ruta.");
			System.exit(0);
		}else {
		File fl = new File(dir);
		String[] ar = fl.list();
		System.out.println("Ficheros en el dir acutal: " + ar.length);
		for (int i = 0; i < ar.length; i++) {
			File fl1 = new File(fl, ar[i]);
			System.out.printf("Nombre: %s, es fichero?: %b, es directorio?: %b %n", ar[i], fl1.isFile(), fl1.isDirectory());
		}
		}
	}

}