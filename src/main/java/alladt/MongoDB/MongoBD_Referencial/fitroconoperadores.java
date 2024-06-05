package alladt.MongoDB.MongoBD_Referencial;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;
import java.util.*;

public class fitroconoperadores {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> El sistema requiere que se eliga una opcion");
        System.out.println("1 - Busqueda con operadores logicos (juego y personaje) (teclado)");
        System.out.println("2 - Busqueda con operadores logicos (empresa (+ datos de esta) y personaje) (teclado)");
        int r = sc.nextInt();

        switch (r) {
            case 1:
                Operador();
                break;
            case 2:
                Operador2();
                break;

            default:
                break;
        }
        sc.close();

    }

    private static void Operador() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String col = "Videojuegos";
        String peticion = "filtrar nombre de juego y/o personaje";
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
            String p2 = "Operador logico";
            System.out.println("> El sistema requiere que se introduca un: '" + p + "' del personaje");
            String nombre = sc.nextLine();

            System.out
                    .println("> El sistema requiere que se introduca un: '" + p2 + "' ('AND' / 'OR' (en minusculas))");
            String operador = sc.nextLine();

            if (!operador.equals("and") && !operador.equals("or")) {
                System.out.println("> El sistema ha detectado que no se ha escrito correctamente lo que se ha pedido");
                System.exit(0);
            }

            System.out.println("> El sistema requiere que se introduca un: '" + p + "' del juego");
            String juego = sc.nextLine();

            // ! Filtro de busqueda.
            Document filtroP = new Document("nombre", nombre);
            Document filtroJ = new Document("juego", juego);
            Document FiltroResultado = new Document();
            if (operador.equals("and")) {
                FiltroResultado = new Document("$and", List.of(filtroP, filtroJ));
            } else if (operador.equals("or")) {
                FiltroResultado = new Document("$or", List.of(filtroP, filtroJ));

            }

            List<Document> r = collection.find(FiltroResultado).into(new ArrayList<>());

            if (r.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + nombre + "' y '" + juego + "'");
                for (Document document : r) {
                    System.out.println(document.toString());
                }
            } else {
                System.out.println("> El sistema no ha encontrado nada");
            }

            sc.close();
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }
    }

    private static void Operador2() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String string1 = "Empresa";
        String col = "Videojuegos";
        String peticion = "filtrar nombre de juego y/o empresa";
        System.out.println("> El sistema ha detectado la peticion: << " + peticion + " >>");
        try {
            System.out.println("> El sistema ha establecido conecion con MongoDB");

            // ! Establece la conexion
            MongoClient m = new MongoClient();
            MongoDatabase db = m.getDatabase(col);
            MongoCollection<Document> collectionPer = db.getCollection(string);
            MongoCollection<Document> collectionEmp = db.getCollection(string1);

            System.out.println("");

            // ! Mensaje + busqueda
            String p = "Nombre";
            String p2 = "Operador logico";
            String p3 = "Numero de la empresa";
            System.out.println("> El sistema requiere que se introduca un: '" + p3 + "'");
            int numero = sc.nextInt();
            sc.nextLine();
            System.out
                    .println("> El sistema requiere que se introduca un: '" + p2 + "' ('AND' / 'OR' (en minusculas))");
            String operador = sc.nextLine();

            if (!operador.equals("and") && !operador.equals("or")) {
                System.out.println("> El sistema ha detectado que no se ha escrito correctamente lo que se ha pedido");
                System.exit(0);
            }

            System.out.println("> El sistema requiere que se introduca un: '" + p + "' del juego");
            String juego = sc.nextLine();

            // ! Filtro de busqueda.
            Document filtroN = new Document("empresa_id", numero);
            Document filtroJ = new Document("juego", juego);
            Document FiltroResultado = new Document();
            if (operador.equals("and")) {
                FiltroResultado = new Document("$and", List.of(filtroN, filtroJ));
            } else if (operador.equals("or")) {
                FiltroResultado = new Document("$or", List.of(filtroN, filtroJ));

            }

            List<Document> r = collectionPer.find(FiltroResultado).into(new ArrayList<>());

            if (r.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + numero + "' y '" + juego + "'");
                System.out.println("> El sistem pasara a mostrar datos de la empresa: " + numero);
                System.out.println("> El resultado de la busqueda: ");
                for (Document document : r) {
                    System.out.println(document.toString());
                    System.out.println("\n");

                    int empresa_id = document.getInteger("empresa_id");
                    Document filtroEm = new Document("id", empresa_id);
                    FindIterable<Document> busquedaEm = collectionEmp.find(filtroEm);
                    if (busquedaEm.iterator().hasNext()) {
                        for (Document document2 : busquedaEm) {
                            System.out.println(document2.toString());
                        }
                    } else {
                        System.out.println("> El sistema no ha detectado ninguna empresa");
                    }
                }
            } else {
                System.out.println("> El sistema no ha encontrado nada");
            }

            sc.close();
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }
    }




}
