package randomsccessfile;

import java.io.File;
import java.io.RandomAccessFile;

public class EscribirRegistroAleatorio {
	public static void main(String[] args) throws Exception {
		 File fl = new File("D:\\Aeclipse-workspace\\Ficheros_ZJ_Nerea\\src\\FicherosAleatorios\\Aleatorio.dat");		 
		 RandomAccessFile rf = new RandomAccessFile(fl, "rw");
		 
		 String a = "JIYAN";
		 Double s = 12345.30;
		 int d = 30;
		 
		 int i = 30;
		 
		 long p = (i - 1) * 36;
		 rf.seek(p);
		 
		 rf.writeInt(i);
		 StringBuffer sf = new StringBuffer(a);
		 sf.setLength(10);
		 rf.writeChars(sf.toString());
		 rf.writeInt(d);
		 rf.writeDouble(s);
		 
	}

}
