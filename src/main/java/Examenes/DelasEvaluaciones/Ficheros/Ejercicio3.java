package Examenes.DelasEvaluaciones.Ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Ejercicio3 {
	public static String ruta;
	public static void main(String[] args) {
		//introducimos la ruta 
		String ruta = "";
		if (args.length == 1) {
			ruta = args[0]; // el programa sólo funcionará si se introduce una única ruta
			consulta(); //se consulta el empleado
			borrado(); //se borra el empleado
		}
	}
	
	public static void consulta() {
		//se crea el archivo
		File file = new File(ruta);
		
		try {
			//se crea el RandomAccessFile, que permite la lectura del archivo
			RandomAccessFile raf = new RandomAccessFile(new File(ruta), ruta);
			raf.seek(0);
			
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void borrado() {
		//se crea el archivo
		File file = new File(ruta);
		
		//se crea el RandomAccessFile, que permite la modificación del archivo
		try {
			RandomAccessFile raf = new RandomAccessFile(new File(ruta), ruta);
			raf.seek(0);
		} catch (FileNotFoundException fnf) {
			fnf.printStackTrace();
		} catch (IOException io) {
			io.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
