package alladt.Ficheros.TodoFicheros_Clase.randomsccessfile;

import java.io.File;
import java.io.RandomAccessFile;

public class LeerFicheroAleatorioFor {
public static void main(String[] args) {
	File fl = new File("D:\\\\eclipse-workspace\\\\Ficheros_Nerea\\\\src\\\\dirnuevo\\Aleatorio.dat");
    
    int id, dep;
    int p = 0; //Se situa al final 
    Double salario;
    char [] apellidos = new char[10];
    char a;
    boolean fin = false;
    
    int r = 5;
    
    while(true) {
    	try (RandomAccessFile rf = new RandomAccessFile(fl, "r")){
			rf.seek(p);
			id = rf.readInt();
			
			for (int i = 0; i < apellidos.length; i++) {
				a = rf.readChar();
				apellidos[i] = a;
				
			}
			String apellido = new String(apellidos);
			dep = rf.readInt();
			salario = rf.readDouble();
		
			if (id > 0) {
				System.out.println("ID: " + id + ", Apellido: " + apellido.trim() + ", Departamento: " + dep
	                    + ", salario: " + salario);
			}
			p = (p -1 ) * 36; 
		} catch (Exception e) {
			fin = true;
		}
    }
}
}
