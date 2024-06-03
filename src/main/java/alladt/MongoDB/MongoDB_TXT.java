package alladt.MongoDB;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
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
                String[] p = linea.split(": ");
                if(p.length < 2) continue; //! Salta lineas mal formadas
                String k = p[0].trim();
                String v = p[1].trim();

                switch (k) {
                    case "nombre":
                        nombre = v;
                        break;
                    case "posicion":
                        posicion = v;
                        break;
                    case "elemento":
                        elemento = v;
                        break;
                    case "arma":
                        arma = v;
                        break;
                    case "rareza":
                        rareza = Integer.parseInt(v);
                        break;
                }

            }

            bf.close();

            Document doc = new Document();
            doc.put("nombre", nombre);
            doc.put("rareza", rareza);
            doc.put("posicion", posicion);
            doc.put("elemento", elemento);
            doc.put("arma", arma);

            MongoCollection<Document> collection = db.getCollection("Calcharo <3");

            collection.insertOne(doc);
            System.out.println("> El sistema a introducido correctamente los elementos del txt.");
        } catch (Exception e) {
            System.out.println("> El sistema no ha podido seguir las indicaciones dadas.");
            System.out.println("> El sitema proporciona el error: " + e.getMessage());
        }
    }
}
