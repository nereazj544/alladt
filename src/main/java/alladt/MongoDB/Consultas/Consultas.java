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
import com.mongodb.client.FindIterable;
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
        r = r.toLowerCase();
        switch (r) {
            case "crear":
                Insertardatos();
                break;
            case "consulta":
                System.out.println("> El sistema requiere enter para confirmar");
                Consulta(sc);
                break;
                default:
                System.out.println("> El sistema ha detectado que no has escrito correctamente.");
            }
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
    
    private static void Consulta(Scanner sc) {
        
        System.out.println("> El sistema requiere que selecione una opcion: nombre, arma, rareza o elemento");
        String r = sc.nextLine();
        r = r.toLowerCase();
        
        switch (r) {
            case "nombre":
            consultaNombre(sc);
            System.out.println("> El sistema requiere enter para confirmar");
            break;
            // case "arma":
            // consultaArma(sc);
            //     break;
            // case "rareza":
            //     consultaRareza(sc);
            //     break;
            // case "elemento":
            //     consultaElemento(sc);
            //     break;
        
            default:
            System.out.println("> El sistema no ha detectado una opcion valida. Pruebe de nuevo.");
                break;
        }
    }

    private static void consultaNombre(Scanner sc) {
        String consulta = "Nombre";
        System.out.println("> El sistema ha detectado la orden de la consulta: " + consulta);
        try {
            System.out.println("> El sistema ha extablecido conexion con MongoDB: ");
            MongoClient m = new MongoClient();
            MongoDatabase db = m.getDatabase("WutheringWuvas");
            MongoCollection<Document> c = db.getCollection("Consultas");
            
            System.out.println("\n");
            
            System.out.println("> El sistema requiere que se introduca un: " + consulta);
            String nombre = sc.nextLine();
            
            Document filtro = new Document("nombre", nombre);
            FindIterable<Document> busqueda = c.find(filtro);

            
            if (busqueda.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con: " + nombre + ". Resultado de la busqueda: ");
                for (Document document : busqueda) {
                    System.out.println(document.toJson());
                }
            }else{
                System.out.println("> El sistema no ha detectado nada con: " + nombre);
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
    

    // private static void consultaArma(Scanner sc) {
    //     sc.nextLine();
    //     String consulta = "Arma";
    //     System.out.println("> El sistema ha detectado la orden de la consulta: " + consulta);
        
    //     System.out.println("> El sistema requiere que se introduca un: " + consulta);
    //     String con = sc.nextLine();
        
        
    // }
    
    // private static void consultaRareza(Scanner sc) {
    //     sc.nextLine();
    //     String consulta = "Rareza";
    //     System.out.println("> El sistema ha detectado la orden de la consulta: " + consulta);
        
    //     System.out.println("> El sistema requiere que se introduca una: " + consulta + " (4 o 5)");
    //     int con = sc.nextInt();
        
    // }
    
    // private static void consultaElemento(Scanner sc) {
    //     sc.nextLine();
    //     String consulta = "Elemento";
    //     System.out.println("> El sistema ha detectado la orden de la consulta: " + consulta);
        
    //     System.out.println("> El sistema requiere que se introduca un: " + consulta);
    //     String con = sc.nextLine();
    // }
}
