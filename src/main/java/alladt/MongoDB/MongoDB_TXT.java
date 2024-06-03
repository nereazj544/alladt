package alladt.MongoDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class MongoDB_TXT {
    public static void main(String[] args) {
        File fl = new File("src\\main\\java\\alladt\\MongoDB\\database\\ns.txt");

        datos(fl);
    }

    private static void datos(File fl) {
        String t = "Datos desde txt";
        System.out.println("Funcion: " + t);
        try {
            MongoClient m = new MongoClient();
            MongoDatabase db = m.getDatabase("WutheringWuvas");
            db.createCollection("Calcharo <3");

            BufferedReader bf = new BufferedReader(new FileReader(fl));

            String linea;
            String nombre = "";
            String posicion = "";
            String elemento = "";
            String arma = "";
            int rareza = 0;


            while ((linea = bf.readLine()) != null) {
                
            }
        } catch (Exception e) {
            System.out.println("> El sistema no ha podido seguir las indicaciones dadas.");
            System.out.println("> El sitema proporciona el error: " + e.getMessage());
        }
    }
}
