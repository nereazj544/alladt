package alladt.Ficheros.TodoFicheros_Clase.randomsccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Aleatorio {
    public static void main(String[] args) throws IOException {
    	 File fl = new File("D:\\Aeclipse-workspace\\Ficheros_ZJ_Nerea\\src\\FicherosAleatorios\\Aleatorio.dat");
        RandomAccessFile rf = new RandomAccessFile(fl, "rw");
        //! Mode (segundo parametro (en ecplise no muestra "mode")): "r", "rw", "rws", o "rwd".

        String [] apellidos = {
            "FERNANDEZ", 
            "GIL", 
            "LOPEZ", 
            "RAMOS", 
            "SEVILLA", 
            "CASTILLA", 
            "REY"}; 
        	//! Cada una ocupa 16 (2 bytes). Entonces ocupa 20.

        int [] dep = {10, 20, 10, 10, 30, 30, 20}; //int = 4
        Double [] salario = {1000.45, 2400.60, 3000.0, 1500.56, 2200.0, 1435.87, 2000.0}; //double = 8 
        StringBuffer sb = null; 
        int n = apellidos.length; //int = 4

        for (int i = 0; i < n; i++) {
            rf.writeInt(i + 1);
            sb = new StringBuffer(apellidos[i]);
            sb.setLength(10); //Siempre va a tener 10
            rf.writeChars(sb.toString());
            rf.writeInt(dep[i]);
            rf.writeDouble(salario[i]);
            
        }

        System.out.println("CREADO");
        rf.close();
    }
}
