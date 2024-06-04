package alladt.MongoDB.MongoBD_Referencial;

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


public class Referencial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema requiere que escribe una opcion: 'crear' o 'consulta'");
        String respuesta = sc.nextLine();
        respuesta = respuesta.toUpperCase();

        switch (respuesta) {
            case "CREAR":
                Crear();
                break;
            case "CONSULTA":
                Consulta();
                break;

            default:
                System.out.println("> El sistema no ha detectado una respuesta/opcion correcta. Intentolo más tarde.");
                System.exit(0);
        }
        sc.close();
    }

    private static void Crear() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema requiere que escribe una opcion: 'empresa' o 'personajes'");
        String r = sc.nextLine();
        r = r.toUpperCase();
        
        switch (r) {
            case "EMPRESA":
                Empresa();
                break;
                case "PERSONAJES":
                Personajes();
                break;
                
                default:
                System.out.println("> El sistema no ha detectado una respuesta/opcion correcta. Intentolo más tarde.");
                System.exit(0);
                break;
            }
            
            sc.close();
        }

        private static void Consulta() {
            Scanner sc = new Scanner(System.in);
            System.out.println("> El sistema requiere que escribe una opcion: 'consulta: empresa' o 'consulta: personajes'");
            String r = sc.nextLine();
            r = r.toUpperCase();
            switch (r) {
                case "CONSULTA: PERSONAJES":
                    RefConsultas.MetdoSwitchPersonaje();
                    break;
                case "CONSULTA: EMPRESA":
                    RefConsultas.MetdoSwitchEmpresa();
                    break;
            
                default:
                    break;
            }

            sc.close();
        }

    // ! SOLO METODOS DE CREACION
    private static void Empresa() {
        String string = "Empresa";
        String col = "Videojuegos";

        System.out.println("> El sistema ha detectado la opcion de crear: " + string);

        System.out.println("> El sistema se va ha conectar con MongoDB....");

        MongoClient m = new MongoClient(); // ! Establece la conexion

        MongoDatabase db = m.getDatabase(col);
        System.out.println(
                "> El sistema si no detecta la base de datos la creara auntomaticamente, en caso contrario (ya creada) no lo hara");

        MongoCollection<Document> collection = db.getCollection(string);
        System.out.println(
                "> El sistema ha generado la coleccion de: " + string + " dentro de la base de datos de: " + col);

        System.out.println("> El sistema va ha meter datos dentro de la coleccion: " + string);

        String ruta = "\\empresas.json";

        try (BufferedReader bf = new BufferedReader(new FileReader("src\\main\\java\\Tools\\DataBase\\json" + ruta))) {
            StringBuilder sb = new StringBuilder();
            String l; // ! Se ocupa de leer cada linea del archivo
            while ((l = bf.readLine()) != null) {
                sb.append(l);
            }

            JSONArray jArray = new JSONArray(sb.toString());
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jObject = jArray.getJSONObject(i);
                Document doc = Document.parse(jObject.toString());
                collection.insertOne(doc);
            }
            System.out.println("> El sistema ha añadido los datos del fichero " + ruta + ", correctamente");

        } catch (FileNotFoundException e) {
            System.out.println("> El sistema no ha encontrado el fichero.");
            System.out.println("> Error: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("> El sistema no ha encontrado lo pedido.");
            System.out.println("> Error: ");
            e.printStackTrace();

        }
        m.close();

    }

    private static void Personajes() {
        String string = "Personajes";
        String col = "Videojuegos";

        System.out.println("> El sistema ha detectado la opcion de crear: " + string);
        System.out.println("> El sistema se va ha conectar con MongoDB....");

        MongoClient m = new MongoClient(); // ! Establece la conexion
        MongoDatabase db = m.getDatabase(col);
        System.out.println(
                "> El sistema si no detecta la base de datos la creara auntomaticamente, en caso contrario (ya creada) no lo hara");

        MongoCollection<Document> collection = db.getCollection(string);
        System.out.println(
                "> El sistema ha generado la coleccion de: " + string + " dentro de la base de datos de: " + col);

        System.out.println("> El sistema va ha meter datos dentro de la coleccion: " + string);

        String ruta = "\\personajes.json";

        try (BufferedReader bf = new BufferedReader(new FileReader("src\\main\\java\\Tools\\DataBase\\json" + ruta))) {
            StringBuilder sb = new StringBuilder();
            String l; // ! Se ocupa de leer cada linea del archivo
            while ((l = bf.readLine()) != null) {
                sb.append(l);
            }
            JSONArray jArray = new JSONArray(sb.toString());
            for (int i = 0; i < jArray.length(); i++) {
                JSONObject jObject = jArray.getJSONObject(i);
                Document doc = Document.parse(jObject.toString());
                collection.insertOne(doc);
            }
            System.out.println("> El sistema ha añadido los datos del fichero " + ruta + ", correctamente");

        } catch (FileNotFoundException e) {
            System.out.println("> El sistema no ha encontrado el fichero.");
            System.out.println("> Error: ");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("> El sistema no ha encontrado lo pedido.");
            System.out.println("> Error: ");
            e.printStackTrace();
        }
        m.close();

    }

}