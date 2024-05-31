package alladt.Ficheros.TodoFicheros_Clase.Parte1_Actividadespdf;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FicheroData {
    public static void main(String[] args) throws Exception {
        File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\FicheroData.dat");
        if (!fl.exists()) {
        	System.out.println("> Se ha creado el archivo");
			fl.createNewFile();
		}
        leerficDa(fl);
        escribirficDa(fl);
    }

    private static void escribirficDa(File fl)  {
        // System.out.println("> Se han escrito los datos");
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(fl))) {
            String[] n = {
                "Kilari Miracle",
                "Galio (Tablei) Miracle",
                "Alyssa O’Doherty",
                "Brantley (Bran) Slora",
                "Kirian Slora",
                "Bahir Loughty",
                "Coral Loughty",
                "Gemma Berrycloth",
                "Bosco Berrycloth"
            };
            int[] e = {18, 17, 18, 17, 18, 17, 17, 18};

            for (int i = 0; i < e.length; i++) {
                out.writeUTF(n[i]);
                out.writeInt(e[i]);
            }
        } catch (IOException e) {
            System.out.println("El sistema no puede encontrar la ruta especificada");
            e.printStackTrace(); // Añadir esta línea ayudará a identificar el problema exacto
        }
    }

private static void leerficDa(File fl) {
    System.out.println("> Mostrando datos escritos: ");
    try (DataInputStream in = new DataInputStream(new FileInputStream(fl))) {
        while (true) {
            try {
                String nombre = in.readUTF();
                int edad = in.readInt();
                System.out.println("Nombre: " + nombre + ", edad: " + edad);
            } catch (IOException e) {
                // Se alcanza el final del archivo
                break;
            }
        }
    } catch (IOException e) {
        System.out.println("Error al leer el archivo");
        e.printStackTrace(); // Añadir esta línea ayudará a identificar el problema exacto
    }
}
}