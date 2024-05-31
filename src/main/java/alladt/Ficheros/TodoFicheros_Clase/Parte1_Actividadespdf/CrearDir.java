package alladt.Ficheros.TodoFicheros_Clase.Parte1_Actividadespdf;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CrearDir {
    public static void main(String[] args) {

        File r = new File("src\\Clase\\PDF\\EjerciciosPdf1\\DirNuevo");
        if (!r.exists()) {
            System.out.println("> No existe el directorio en la ruta.\n >Se creara a continuacion.");
            r.mkdirs();
        }
        File f = new File(r, "Fichero1.txt");
        File f2 = new File(r, "Fichero2.txt");

        try {
            // ! Crear ficheros
            if (f.createNewFile()) {
                System.out.println("> Se a creado un archivo de txt: " + f);
            } else {
                System.out.println("> No se ha podido crerar el primer archivo");
            }
            if (f2.createNewFile()) {
                System.out.println("> Se a creado un archivo de txt: " + f2);
            } else {
                System.out.println("> No se ha podido crerar el primer archivo");
            }

            // ! Renombrarlos
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce un nombre para cambiar el nombre del primer txt");
            String nombre = sc.nextLine();

            f.renameTo(new File(r, nombre));

            try {
                File r2 = new File("src\\Clase\\PDF\\EjerciciosPdf1\\DirNuevo\\f3.txt");
                System.out.println("> ¿Crear nuevo fichero? (Si o no)");
                String respuesta = sc.nextLine();
                switch (respuesta) {
                    case "si":
                    System.out.println("> Se ha creado el fichero: f3.txt");
                    r2.createNewFile();
                    break;
                    case "no":
                    System.out.println("> No se creara");
                    System.exit(0);
                    break;
                    default:
                    System.out.println("> No has escribido una respuesta correcta. Introduce si o no");
                    break;
                }
                //!Borrar
                System.out.println("> ¿Borrar fichero? (Si o no)");
                String respuesta2 = sc.nextLine();
                switch (respuesta2) {
                    case "si":
                    System.out.println("> Se ha borrado el fichero: f3.txt");
                    r2.delete();
                    break;
                    case "no":
                    System.out.println("> No se borra");
                    break;
                    default:
                    System.out.println("> No has escribido una respuesta correcta. Introduce si o no");
                    break;
                }

                sc.close();

            } catch (IOException e) {
                System.out.println("El sistema no ha podidod encontrar la ruta especificada.");

                System.out.println("\nEXPECIFICACION DEL ERROR: " + e.getLocalizedMessage());

            }

        } catch (IOException e) {
            System.out.println("El sistema no ha podidod encontrar la ruta especificada.");

            System.out.println("\nEXPECIFICACION DEL ERROR: " + e.getLocalizedMessage());
        }

    }
}