package alladt.Ficheros.randomsccessfile;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class LeerAleatorio {
    public static void main(String[] args) throws IOException {
        File fl = new File("D:\\\\eclipse-workspace\\\\Ficheros_Nerea\\\\src\\\\dirnuevo\\Aleatorio.dat");
        RandomAccessFile rf = new RandomAccessFile(fl, "r");
        int id, dep;
        int p = 0; //Se situa al final 
        Double salario;
        char [] apellidos = new char[10];
        char a;
        boolean fin = false;
        
        int r = 5;
        do {
            try {
                rf.seek(p);
                id = rf.readInt();

                for (int i = 0; i < apellidos.length; i++) {
                    a = rf.readChar();
                    apellidos[i] = a;
                }

                String ap = new String(apellidos);
                dep = rf.readInt();
                salario = rf.readDouble();
                if (id > 0) {
                    System.out.println("ID: " + id + ", Apellido: " + ap.trim() + ", Departamento: " + dep
                    + ", salario: " + salario);
                    //Para sacar esto ⤵️ se suma las variables. Es decir: 20 (string) + 4 + 4 (de los dos int) + 8 (double) = 36
//                    p = p + 36; 
                    p = (r -1) * 36;
                    if (p >= rf.length()) {
						System.out.println("ID: " + r + ", no existe");
					}else {
						rf.seek(p);
						id = rf.readInt();
					}
                }
                rf.close();
            } catch (Exception e) {
                // TODO: handle exception
            }
        } while (!fin);
    }
}