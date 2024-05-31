package alladt.Ficheros.TodoFicheros_Clase.Parte1_Actividadespdf;

import java.io.File;
import java.io.IOException;

public class CrearDir2 {
    public static void main(String[] args) {
        File ruta = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo");
        // !para crear un directorio
        if (!ruta.exists()) {
            System.out.println("No existe la ruta propocionada asi que acontinuacion se creara.");
            ruta.mkdirs();
        }
        File f = new File(ruta, "archvio.txt");
        File f2 = new File(ruta, "archvio2.txt");

        try {
            if (f.createNewFile()) {
                System.out.println("archvio.txt creado");
            } else {
                System.out.println("No se ha posido crear");
            }
            if (f2.createNewFile()) {
                System.out.println("archvio2.txt creado");
            } else {
                System.out.println("No se ha posido crear");
            }
        } catch (IOException e) {
            System.out.println("El sistema no puede encontrar la ruta especificada");
            System.err.println("\nExpecificacion del error:");
            e.printStackTrace();
        }
        // !renombrar ficheros:
        f.renameTo(new File(ruta, "nombre.txt"));
        System.out.println("Se ha cambiado el nombre del fichero con el nombre: archivo.txt por nombre.txt");

        try {
            File f3 = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\f3.txt");
            f3.createNewFile();

            if (f3.delete()) {
                System.out.println("Fichero: f3 borrardo");
            } else {
                System.out.println("No se ha podido borrar");
            }
        } catch (IOException en) {
            System.out.println("El sistema no puede encontrar la ruta especificada");
            System.err.println("\nExpecificacion del error:");
            en.printStackTrace();
        }

    }

}