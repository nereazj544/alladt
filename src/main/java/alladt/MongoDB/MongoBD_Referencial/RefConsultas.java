package alladt.MongoDB.MongoBD_Referencial;

import java.util.Arrays;
import java.util.Scanner;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.AggregateIterable;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;

public class RefConsultas {
    public static void MetdoSwitchPersonaje() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema requiere una respuesta a de ser un numero de la lista: ");
        System.out.println("1 - Buscar nombre de personaje.");
        System.out.println("2 - Buscar nombre de personaje y mostrar empresa asociada.");
        System.out.println("3 - Mostrar todos los persoanjes de un juego.");
        System.out.println("4 - Buscar nombre de juego y mostrar solo personajes.");
        System.out.println("5 - Cuantos personajes hay en el jeugo introducido (en la base de datos).");

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
            case 4:
                BuscarJuego();
                break;
            case 5:
                CuantosPersonajesPorJuegos();
                break;

            default:
                System.out.println("> El sistema no ha detectado una respuesta valida.");
                break;
        }
    }

    public static void MetdoSwitchEmpresa() {
        Scanner sc = new Scanner(System.in);
        System.out.println("> El sistema requiere una respuesta a de ser un numero de la lista: ");
        System.out.println("1 - Buscar nombre de empresa y mostrar personajes asociado.");
        System.out.println("2 - Buscar nombre de personaje y mostrar empresa que lo creo.");

        int r = sc.nextInt();

        switch (r) {
            case 1:
                ListarEmpresP();
                break;
            case 2:
                EmpresaCreoPersonaje();
                break;

            default:
                System.out.println("> El sistema no ha detectado una respuesta valida.");
                break;
        }
        sc.close();
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
            sc.close();
            m.close();
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
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }

    }

    private static void Juegos() {
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
            sc.close();
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }

    }

    private static void BuscarJuego() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String col = "Videojuegos";
        String peticion = "Mostrar todos los personajes (solo el nombre)  del juego introducido";
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
                    System.out.println(document.get("nombre").toString());
                }
            } else {
                System.out.println("> El sistema no ha detectado nada con el nombre: " + nombre);
                // System.out.printf("El sistema no ha detectado nada con el nombre: '%s'",
                // nombre);
            }
            sc.close();
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }

    }

    private static void CuantosPersonajesPorJuegos() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String col = "Videojuegos";
        String peticion = "Mostrar todos los personajes (solo el nombre)  del juego introducido";
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
            AggregateIterable<Document> conteo = collection
                    .aggregate(Arrays.asList(Aggregates.group(filtro, Accumulators.sum("count", 1))));

            if (conteo.iterator().hasNext()) {
                for (Document document : conteo) {
                    System.out.println("> El sistema a contado: " + document.toString());
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

    // ! EMPRESA

    private static void ListarEmpresP() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String string2 = "Empresa";
        String col = "Videojuegos";
        String peticion = "Buscar nombre de empresa y mostrar persoanjes asociados";
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
            System.out.println("> El sistema requiere que se introduca un: '" + p + "' de la empresa a mostrar");
            String nombre = sc.nextLine();

            // ! Filtro de busqueda.
            Document filtro = new Document("nombre", nombre);
            FindIterable<Document> busqueda = collectionEmp.find(filtro);

            if (busqueda.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + nombre + "'.");
                System.out.println("> El resultado de la busqueda: ");
                for (Document document : busqueda) {
                    System.out.println(document.toJson());

                    int empresa_id = document.getInteger("id");
                    Document filtroP = new Document("empresa_id", empresa_id);
                    FindIterable<Document> busque = collection.find(filtroP);

                    if (busque.iterator().hasNext()) {
                        System.out.println("> El sistema ha detectado personajes asociados a la empresa.");
                        System.out.println("> El resultado de la busqueda: ");
                        for (Document document2 : busque) {
                            System.out.println(document2.toJson());
                        }
                    } else {
                        System.out.println("> El sistema no ha detectado ningun personaje asocuado a la empresa.");

                    }
                }

            } else {
                System.out.println("> El sistema no ha detectado nada con el nombre: " + nombre);
                // System.out.printf("El sistema no ha detectado nada con el nombre: '%s'",
                // nombre);
            }
            sc.close();
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }
    }

    public static void EmpresaCreoPersonaje() {
        Scanner sc = new Scanner(System.in);
        String string = "Personajes";
        String string2 = "Empresa";
        String col = "Videojuegos";
        String peticion = "Buscar nombre de personaje y mostrar empresa que lo creo";
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
            System.out.println("> El sistema requiere que se introduca un: '" + p
                    + "' del personaje para buscar la empresa que lo creo.");
            String nombre = sc.nextLine();

            // ! Filtro de busqueda.
            Document filtro = new Document("nombre", nombre);
            FindIterable<Document> busqueda = collection.find(filtro);

            if (busqueda.iterator().hasNext()) {
                System.out.println("> El sistema ha encontrado resultados con '" + nombre + "'.");
                for (Document document : busqueda) {
                    int empresa_id = document.getInteger("empresa_id");
                    Document filter = new Document("id", empresa_id);
                    FindIterable<Document> find = collectionEmp.find(filter);
                    if (find.iterator().hasNext()) {
                        System.out.println("> El sistema ha encotrado la empresa que creo a " + nombre);
                        for (Document document2 : find) {
                            System.out.println(document2.toJson());
                        }
                    } else {
                        System.out.println("> El sistema no encontro nada");
                    }
                }

            } else {
                System.out.println("> El sistema no ha detectado nada con el nombre: " + nombre);
                // System.out.printf("El sistema no ha detectado nada con el nombre: '%s'",
                // nombre);
            }
            sc.close();
            m.close();
        } catch (Exception e) {
            System.out.println("> El sistema ha dectado un error: ");
            System.out.println("> Error: ");
            e.printStackTrace();
        }

    }

    // ! END CLASS RefConsultas
}
