package alladt.MongoDB.MongoBD_Referencial;

import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class RefConsultas {
    public static void MetdoSwitchPersonaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema requiere una respuesta a de ser un numero de la lista: ");
        System.out.println("1 - Buscar nombre de personaje");

        int r = sc.nextInt();

        switch (r) {
            case 1:
                NombrePersonaje(sc);
                break;

            default:
                System.out.println("> El sistema no ha detectado una respuesta valida.");
                break;
        }
    }

    public static void MetdoSwitchEmpresa() {

    }

    // ! PERSOANJES
    public static void listarEmpresa() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String col = "Videojuegos";
        String peticion = "Buscar nombre de personaje y listar empresa";
        System.out.println("> El sistema ha detectado la peticion: << " + peticion + " >>");

    }

    private static void NombrePersonaje(Scanner sc) {
        sc.nextLine();
        String string = "Personajes";
        String col = "Videojuegos";
        String peticion = "Buscar nombre de personaje";
        System.out.println("> El sistema ha detectado la peticion: << " + peticion + " >>");

        try {
            System.out.println("> El sistema ha establecido conecion con MongoDB");
            
            // ! Establece la conexion
            MongoClient m = new MongoClient(); 
            MongoDatabase db = m.getDatabase(col);
            MongoCollection<Document> collection = db.getCollection(string);

            System.out.println("");
            
            //! Mensaje + busqueda
            String p = "Nombre";
            System.out.println("> El sistema requiere que se introduca un: '" + p + "'");
            String nombre = sc.nextLine();

            //! Filtro de busqueda.
            Document filtro = new Document("nombre", nombre);
            FindIterable<Document> busqueda = collection.find(filtro);

            if (busqueda.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + nombre + "'.");
                System.out.println("> El resultado de la busqueda: ");

                for (Document document : busqueda) {
                    System.out.println(document.toJson());
                }
            } else {
                System.out.println("> El sistema no ha detectado nada con el nombre: " + nombre);
                // System.out.printf("El sistema no ha detectado nada con el nombre:  '%s'", nombre);
            }



        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }

    }

    // ! END CLASS RefConsultas
}
