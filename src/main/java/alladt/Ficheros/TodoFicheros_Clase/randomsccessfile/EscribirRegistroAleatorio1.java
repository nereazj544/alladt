package alladt.Ficheros.TodoFicheros_Clase.randomsccessfile;

import java.io.File;
import java.io.RandomAccessFile;

public class EscribirRegistroAleatorio1 {

	public static void main(String[] args) throws Exception{
		File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\FicherosAleatorios\\Aleatorio.dat");
		RandomAccessFile rf = new RandomAccessFile(fl, "rw");
		
		String nombre = "Jiyan"; //2*10 = 20
		Double salario = 2398.78; // 8
		int departamento = 30; // 4
		int x = 30;
	
		long p = (x - 1)* 32;
		rf.seek(p);
		rf.writeInt(departamento);
		
		StringBuffer sf = new StringBuffer(nombre);
		sf.setLength(10);
		rf.writeChars(sf.toString());
		rf.writeDouble(salario);
		
	}

}
