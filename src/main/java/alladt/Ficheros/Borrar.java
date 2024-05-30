package alladt.Ficheros;

import java.io.File;

public class Borrar {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("> No has introducido una ruta.");
            System.exit(0);
        }
        String ruta = args[0];
        
        File fl = new File(ruta);
        if (!fl.exists()) {
            System.out.println("> No existe el directorio a borrar.");
            System.exit(0);
        }else{
            System.out.println("> Directorio: " + ruta);
            borrar(fl);
        }
    }

    private static void borrar(File fl) {
        File [] a = fl.listFiles();

        for (File file : a) {
            if (file.isFile()) {
                System.out.println("> Eliminado: " + file.getName());
                file.delete();
            }
        }
    }
}
