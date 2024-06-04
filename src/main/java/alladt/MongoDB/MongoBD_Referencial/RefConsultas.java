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
        System.out.println("1 - Buscar nombre de personaje.");
        System.out.println("2 - Buscar nombre de personaje y mostrar empresa asociada.");
        System.out.println("3 - Mostrar todos los persoanjes de un juego.");

        int r = sc.nextInt();

        switch (r) {
            case 1:
                NombrePersonaje(sc);
                break;
            case 2:
                listarEmpresa();
                break;
            case 3:
                Juegos();
                break;

            default:
                System.out.println("> El sistema no ha detectado una respuesta valida.");
                break;
        }
    }

    public static void MetdoSwitchEmpresa() {

    }

    // ! PERSOANJES
    // ** Muestra las empresas asociadas a los personajes.
    public static void listarEmpresa() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String string2 = "Empresa";
        String col = "Videojuegos";
        String peticion = "Buscar nombre de personaje y listar empresa";
        System.out.println("> El sistema ha detectado la peticion: << " + peticion + " >>");

        try {
            System.out.println("> El sistema ha establecido conecion con MongoDB");

            // ! Establece la conexion
            MongoClient m = new MongoClient();
            MongoDatabase db = m.getDatabase(col);
            MongoCollection<Document> collection = db.getCollection(string);
            MongoCollection<Document> collectionEmp = db.getCollection(string2);

            System.out.println("");

            // ! Mensaje + busqueda
            String p = "Nombre";
            System.out.println("> El sistema requiere que se introduca un: '" + p + "'");
            String nombre = sc.nextLine();

            // ! Filtro de busqueda.
            Document filtro = new Document("nombre", nombre);
            FindIterable<Document> busqueda = collection.find(filtro);

            if (busqueda.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + nombre + "'.");
                System.out.println("> El resultado de la busqueda: ");

                for (Document document : busqueda) {
                    System.out.println(document.toJson());

                    // ! Mostrar datos asociados
                    int empresa_id = document.getInteger("empresa_id");
                    Document filtroEm = new Document("id", empresa_id);
                    FindIterable<Document> busquedaEm = collectionEmp.find(filtroEm);
                    if (busquedaEm.iterator().hasNext()) {
                        System.out.println("> El sistema detecto la empresa asociada del personaje: '" + nombre + "'");
                        System.out.println("> El resultado de la busqueda: ");
                        for (Document document2 : busquedaEm) {
                            System.out.println(document2.toJson());
                        }
                    } else {
                        System.out.println(
                                "> El sistema no ha detectado ninguna empresa asociada al nombre del personaje '"
                                        + nombre + "'");
                    }
                }
            } else {
                System.out.println("> El sistema no ha detectado nada con el nombre: " + nombre);
                // System.out.printf("El sistema no ha detectado nada con el nombre: '%s'",
                // nombre);
            }
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }
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

            // ! Mensaje + busqueda
            String p = "Nombre";
            System.out.println("> El sistema requiere que se introduca un: '" + p + "'");
            String nombre = sc.nextLine();

            // ! Filtro de busqueda.
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
                // System.out.printf("El sistema no ha detectado nada con el nombre: '%s'",
                // nombre);
            }

        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }

    }

    private static void Juegos(){
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String col = "Videojuegos";
        String peticion = "Mostrar todos los personajes del juego introducido";
        System.out.println("> El sistema ha detectado la peticion: << " + peticion + " >>");
        try {
            System.out.println("> El sistema ha establecido conecion con MongoDB");

            // ! Establece la conexion
            MongoClient m = new MongoClient();
            MongoDatabase db = m.getDatabase(col);
            MongoCollection<Document> collection = db.getCollection(string);
            

            System.out.println("");

            // ! Mensaje + busqueda
            String p = "Nombre";
            System.out.println("> El sistema requiere que se introduca un: '" + p + "'" + " del juego a buscar");
            String nombre = sc.nextLine();

            // ! Filtro de busqueda.
            Document filtro = new Document("juego", nombre);
            FindIterable<Document> busqueda = collection.find(filtro);

            if (busqueda.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + nombre + "'.");
                System.out.println("> El resultado de la busqueda: ");

                for (Document document : busqueda) {
                    System.out.println(document.toJson());

                }
            } else {
                System.out.println("> El sistema no ha detectado nada con el nombre: " + nombre);
                // System.out.printf("El sistema no ha detectado nada con el nombre: '%s'",
                // nombre);
            }
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }


    }





























    // ! END CLASS RefConsultas
}
