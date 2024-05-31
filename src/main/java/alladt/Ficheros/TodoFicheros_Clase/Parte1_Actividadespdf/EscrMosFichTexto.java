package alladt.Ficheros.TodoFicheros_Clase.Parte1_Actividadespdf;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EscrMosFichTexto {
    public static void main(String[] args) {
        File ruta = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo");

        File f = new File(ruta, "FicheroTextoBuff.txt");
        try {
            if (f.createNewFile()) {
                System.out.println("archvio txt creado");
            } else {
                System.out.println("No se ha posido crear y/o archvio ya creado");
            }

            File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\FicheroTextoBuff.txt");
            BufferedWriter bw = new BufferedWriter(new FileWriter(fl));
            for (int i = 0; i < 11; i++) {
                bw.write("Fila numero: " + i);
                bw.newLine(); //salto de linea
            }
            bw.close();

            //! Mostrar contenido.
            BufferedReader br = new BufferedReader(new FileReader(fl));
            String linea;
            System.out.println("CONTENIDO DEL ARCHIVO:");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();

        }catch(FileNotFoundException k){
            System.out.println("El sitema no pudo encontrar el fichero especificado");
        } catch (IOException e) {
            System.out.println("El sistema no puede encontrar la ruta especificada");
        }

    }
}