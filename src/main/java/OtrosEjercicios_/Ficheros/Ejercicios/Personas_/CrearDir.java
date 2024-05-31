package OtrosEjercicios_.Ficheros.Ejercicios.Personas_;

import java.io.File;
import java.io.IOException;

/*
Ha de crear un directorio NUEVODIR, (mkdir) y a continuaci�n dos ficheros vac�os en dicho 
directorio y renombrar uno de ellos (Utilizar el tercer constructor File(File directorio, 
String nombrefichero)). En el primero indicamos directorio donde se crear� el fichero y en 
el segundo el nombre del fichero
*/

public class CrearDir {
	public static void main(String[] args) {
		String ruta = "C:\\Users\\aplod\\Downloads" + "\\CrearDir";
		//crea una string a la que le asignamos la ruta que queremos usar
		//para cambiar la ruta, hay que cambiar la primera frase; ya que la segunda se usar� para crear el directorio en el que se almacenaran los archivos
		
		
		File f = new File(ruta); 
		f.mkdir(); 
		//crea un objeto archivo "f" al que se le asigna una ruta. este objeto luego crea el directorio asignado a la string ruta
		
		
		File f1 = new File(ruta, "fichero1"); 
		try {
			f1.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		} 
		//crea un objeto archivo "f1" al que se le asigna una ruta. este objeto luego crea un archivo en blanco "fichero1"
		//en caso de que no se pueda crear el archivo por la excepci�n IOException, se imprimir� en la consola su stacktrace. 
		
		
		File f2 = new File(ruta, "fichero2"); 
		try {
			f2.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		//crea un objeto archivo "f2" al que se le asigna una ruta. este objeto luego crea un archivo en blanco "fichero2"
		//en caso de que no se pueda crear el archivo por la excepci�n IOException, se imprimir� en la consola su stacktrace. 
		
		File fRenombrar2 = new File(ruta, "ficheroRenombrado2");
		f2.renameTo(fRenombrar2);
		//el metodo renameTo cambiar� el nombre del archivo "f2" al que le hemos asignado a "fRenombrar2"
	}
}
