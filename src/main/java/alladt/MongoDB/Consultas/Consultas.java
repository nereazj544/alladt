package alladt.MongoDB.Consultas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.bson.Document;
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class Consultas {
    public static void main(String[] args) {


        // ** Lo basico es esto:
        /*
         * 
         * MongoClient m = new MongoClient(); //Conexion
         * MongoDatabase db = m.getDatabase("WutheringWuvas"); 
         * // Seleccionar la base, si no esta creada te la crea automaticamente.
         * db.createCollection("Consultas"); 
         * //para crear la coleccion si no esta creada
         * MongoCollection<Document> collection = db.getCollection("Consultas");
         * //Seleccionar la coleccion que esta dentro de la base
         */

        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema requiere que seleccione una opcion: Crear o Consulta");
        String r = sc.nextLine();
        switch (r) {
            case "Crear":
                Insertardatos();
                break;
            case "Consulta":
                Consulta();
                break;
            default:
                break;
        }
        sc.close();
    }

    private static void Insertardatos() {
        String t = "Insertar datos desde JSON";
        System.out.println("Funcion: " + t);

        try {
            String ruta = "C:\\Users\\nzjha\\Desktop\\GITHUB\\alladt-1\\src\\main\\java\\alladt\\MongoDB\\database";
            FileReader fr = new FileReader(ruta + "\\wuthering_waves.json");
            BufferedReader bf = new BufferedReader(fr);

            MongoClient m = new MongoClient();
            System.out.println("> El sistema ha extablecido conexion con MongoDB");
            MongoDatabase db = m.getDatabase("WutheringWuvas");
            MongoCollection<Document> c = db.getCollection("Consultas");

            StringBuilder stb = new StringBuilder();
            String l;
            System.out.println("> El sistema ha insertado datos de la ruta: " + ruta);
            System.out.println("> El sistema ha empezado a leer el archivo de la ruta anterios");
            while ((l = bf.readLine()) != null) {
                stb.append(l);
            }

            JSONArray json = new JSONArray(stb.toString());
            for (int i = 0; i < json.length(); i++) {
                JSONObject obj = json.getJSONObject(i);
                Document doc = Document.parse(obj.toString());
                c.insertOne(doc);

            }

            System.out.println("> El sistema ha añadido correctamente los datos.");
            bf.close();
        } catch (FileNotFoundException e) {
            System.out.println("> El sistema no ha encontrado ningun archivo.");
        } catch (IOException e) {
            System.out.println("> El sistema no ha podido seguir la orden.");

        }
    }

    private static void Consulta() {

    }
}
