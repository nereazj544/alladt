package alladt.MongoDB.MongoDB_IE_trabajo;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.bson.Document;
import org.bson.types.ObjectId;

//! Esta biblioteca es para que se pueda implementar bien los archivos de JSON. 
import org.json.JSONArray;
import org.json.JSONObject;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

/**
 * @author Nerea Zapatero Jara
 * 
 * TODO: Falta implementar lo del jugador si no tiene equipo, ¿que pasa? 
 */
public class MongoDb_Recuperacion {

	public static void main(String[] args) {

		// Scanner para la lectura de datos.
		Scanner sc = new Scanner(System.in);

		// While para que te muestre las opciones
		while (true) {

			System.out.println("\n==========================");
			System.out.println("Selecciona una opcion:");
			System.out.println("==========================\n");
			System.out.println(
					"1- Crear base de datos ('IE_Recu') y las dos colecciones llamadas: 'Jugadores' y 'Equipos'");
			System.out.println("2- Insertar datos desde un archivo JSON.");
			System.out.println("3- Insertar datos por teclado.");
			System.out.println("4- Borrar ID.");
			System.out.println("5- Visualizar datos.");
			System.out.println("6- Crear JSON de las coleciones llamasdas: 'Jugadores' y 'Equipos'.");
			System.out.println("7- Salir.");
			System.out.print("\nEscribe tu opcion: ");

			int e = sc.nextInt(); // Cuando el usuario ponga el numero saltara el caso en el switch

			//Switch para llamar a los metods
			switch (e) {
			case 1:
				CrearBD(sc); // ** Llama al metodo para crear la Database
				break;
			case 2:
				JSONDatos(sc); // ** Llama al metodo para insertar datos con JSON
				break;

			case 5:
				VisualizarDatos(sc); // ** Llama al metodo para visualizar los datos
				break;
			case 3:
				InsertarDatosScanner(sc); // * Llama al metodo para insertar los datos
				break;

			case 4:
				Borrar(sc); // * Llama al metodo para borrar datos
				break;
			case 6:
				CrearJSON(sc); // * Llama al metodo para crear archivos JSON
				break;
			case 7:
				System.err.println("Adios :)"); // * Mensaje de despedida
				System.exit(0); // Salir del programa
			default:
				System.out.println("Opcion no valida");

			}

		}
	}

	// ! Creacion de la Database
	/*
	 * -------METODOS PARA CREAR DATABASE-------
	 */
	private static void CrearBD(Scanner sc) {
		String s = sc.nextLine();
		while (true) {
			System.out.println("¿Que coleccion quieres crear?");
			System.out.println("=================");
			System.out.println("1- Jugadores");
			System.out.println("2- Equipos");
			System.out.println("3- Salir");
			System.out.println("=================");
			System.out.print("Escribe tu opcion: ");

			String opcion = sc.nextLine();
			int num;

			try {
				num = Integer.parseInt(opcion); // Conversion de la opcion a un nº entero
				if (num < 1 || num > 3) {
					// Se verifica si el nº esta dentro del rango valido
					System.err.println("Error: Introduce un número válido (1, 2, o 3).");
					continue; // Se vuelve al inicio del bucle para solicitar nuevamente la opcion
				}
			} catch (NumberFormatException e) {
				System.err.println("Error: Introduce un número válido (1, 2, o 3).");
				continue;
			}

			try {
				switch (num) {
				case 1:
					JugadoresCollection();
					break;
				case 2:
					EquiposCollection();
					break;
				case 3:
					System.out.println("FINALIZA EL PROGRAMA");
					System.exit(0);
					break;
				default:
					System.err.println("Opcion invalida.");
				}
			} catch (Exception e) {
				System.out.println("Error: \n");
				e.printStackTrace();
			}

		}

	}

	private static void JugadoresCollection() {
		// Texto para que salga por pantalla y asi moficarlo tanto para equipo.
		String texto = "Jugadores";

		// Conexion con MongoDB
		MongoClient m = new MongoClient();

		MongoDatabase db = m.getDatabase("IE_Recu"); // Seleccion de la Database, la cual si no se encuentra prehecha la
														// crea.
		db.createCollection("Jugadores"); // Creacion de la coleccion.

		System.out.println("\nSe ha generado la coleccion de: " + texto + " dentro de la database: IE_Recu.\n");
		// Confirmamos que se ha creado la colleccion.

		m.close();

	}

	private static void EquiposCollection() {
		String texto = "Equipos";

		// Conexion con MongoDB
		MongoClient m = new MongoClient();
		MongoDatabase db = m.getDatabase("IE_Recu");
		db.createCollection("Equipos");
		// Creacion de la collection

		System.out.println("\nSe ha generado la coleccion de: " + texto + " dentro de la database: IE_Recu.");

		m.close();
	}

	// ! Implementacion de datos a las colecciones
	/*
	 * -------METODOS PARA IMPLEMENTAR DATOS A LAS COLECCIONES-------
	 */

	private static void JSONDatos(Scanner sc) {
		String e = sc.nextLine();
		while (true) {
			System.out.println("¿Que coleccion quieres añadirle datos?");
			System.out.println("=================");
			System.out.println("1- Jugadores");
			System.out.println("2- Equipos");
			System.out.println("3- Salir");
			System.out.println("=================");
			System.out.print("Escribe tu opcion: ");

			String opcion = sc.nextLine();
			int num;

			try {
				num = Integer.parseInt(opcion); // Conversion de la opcion a un nº entero
				if (num < 1 || num > 3) {
					// Se verifica si el nº esta dentro del rango valido
					System.err.println("Error: Introduce un número válido (1, 2, o 3).");
					continue; // Se vuelve al inicio del bucle para solicitar nuevamente la opcion
				}
			} catch (NumberFormatException e2) {
				System.err.println("Error: Introduce un número válido (1, 2, o 3).");
				continue;
			}

			try {
				switch (num) {
				case 1:
					JugadoresJSONDatos();
					break;
				case 2:
					EquiposJSONDatos();
					break;
				case 3:
					System.out.println("FINALIZA EL PROGRAMA");
					System.exit(0);
					break;
				default:
					System.err.println("Opcion invalida.");
				}
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}

	}

	/**
	 * @implNote En estos metodos se ha de usar la bibloteca: "ORG.JSON" La
	 *           utilizamos para parsear el archivo JSON y convertirlo en objetos
	 *           JSON capaz de ser manipulable por Java.
	 * 
	 */
	private static void JugadoresJSONDatos() {
		try {
			FileReader fr = new FileReader(new File("src\\main\\java\\RECUPERACION\\Recursos\\Jugadores.json"));
			BufferedReader bf = new BufferedReader(fr);

			// !CONEXION MONGODB
			MongoClient m = new MongoClient();
			MongoDatabase db = m.getDatabase("IE_Recu");
			MongoCollection<Document> c = db.getCollection("Jugadores");

			StringBuilder stb = new StringBuilder();
			String linea;

			System.out.println("DATOS INSERTADOS: ");
			while ((linea = bf.readLine()) != null) {
				System.out.println(linea); // Visualizamos las lineas que estan dentro del archivo JSON
				stb.append(linea);
			}

			// Parseo del JSON utilizando la biblioteca "org.json"
			JSONArray jsonArray = new JSONArray(stb.toString()); // JSON = Array
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i); // Obtenemos cada obj Json del Array

				// Convertimos cada objeto JSON en un doc BSON
				Document dc = Document.parse(jsonObject.toString());

				c.insertOne(dc);
				// INsertamos el documento en la coleccion
			}
			m.close();
			bf.close();

			System.out.println("\nSE HAN AÑADIDO LOS DATOS CORRECTAMENTE"); // Mensaje de confirmacion

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: EN EL ARCHIVO\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: \n");
			e.printStackTrace();
		}

	}

	private static void EquiposJSONDatos() {
		try {
			FileReader fr = new FileReader(new File("src\\main\\java\\RECUPERACION\\Recursos\\Equipos.json"));
			BufferedReader bf = new BufferedReader(fr);

			// !CONEXION MONGODB
			MongoClient m = new MongoClient();
			MongoDatabase db = m.getDatabase("IE_Recu");
			MongoCollection<Document> c = db.getCollection("Equipos");

			StringBuilder stb = new StringBuilder();
			String linea;

			System.out.println("DATOS INSERTADOS: ");
			while ((linea = bf.readLine()) != null) {
				System.out.println(linea);
				stb.append(linea);
			}

			// Parseo del JSON utilizando la biblioteca "org.json"
			JSONArray jsonArray = new JSONArray(stb.toString()); // JSON = Array
			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject = jsonArray.getJSONObject(i); // Obtenemos cada obj Json del Array

				// Convertimos cada objeto JSON en un doc BSON
				Document dc = Document.parse(jsonObject.toString());

				c.insertOne(dc);
				// INsertamos el documento en la coleccion
			}
			m.close();
			bf.close();

			System.out.println("\nSE HAN AÑADIDO LOS DATOS CORRECTAMENTE"); // Mensaje de confirmacion

		} catch (FileNotFoundException e) {
			System.out.println("ERROR: EN EL ARCHIVO\n");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("ERROR: \n");
			e.printStackTrace();
		}

	}

	// ! Crear JSON
	/*
	 * -------METODOS PARA CREAR JSON DE LAS COLECCIONES: JUGADORES Y EQUIPOS-------
	 */
	private static void CrearJSON(Scanner sc) {

		String e = sc.nextLine();
		while (true) { // Se usa un While para preguntarle al usuario que cual coleccion quiere que se
						// pase a JSON
			System.out.println("¿Para que coleccion quiere hacer el JSON?\n");
			System.out.println("=================");
			System.out.println("1- Jugadores");
			System.out.println("2- Equipos");
			System.out.println("3- Salir");
			System.out.println("=================");
			System.out.print("Escribe tu opcion: ");

			String choice = sc.nextLine();

			int num;
			try {

				num = Integer.parseInt(choice); // Conversion de la opcion a un nº entero
				if (num < 1 || num > 3) {
					// Se verifica si el nº esta dentro del rango valido
					System.err.println("Error: Introduce un número válido (1, 2, o 3).");
					continue; // Se vuelve al inicio del bucle para solicitar nuevamente la opcion
				}
			} catch (NumberFormatException ne) {
				// Si se produce un error en el formato del nº
				System.err.println("Error: Introduce un número válido (1, 2, o 3).");
				continue;
			}

			try {

				switch (num) {
				case 1:
					JugadoresJSON(); // Metodo de los jugadores
					break;
				case 2:
					EquiposJSON(); // Metodo del equipo
					break;
				case 3:
					System.exit(0); // salir
				default:
					System.out.println("Opción inválida.");
				}
//		            m.close();
			} catch (Exception en) {
				System.out.println("ERROR: \n");
				en.printStackTrace();
			}

		}
	}

	private static void JugadoresJSON() {

		// ! Conexion con MongoDB
		MongoClient m = new MongoClient();
		MongoDatabase database = m.getDatabase("IE_Recu"); // !Se selecciona la Base de datos la cual se llama "IE_Recu"
		MongoCollection<Document> jugadoresCollection = database.getCollection("Jugadores"); // !La coleccion

		// Especificacion de la ruta donde se va a guardar el JSON
		File file = new File("src\\main\\java\\RECUPERACION\\Consultas\\Doc\\Jugadores-MONGODB.json");
		FileWriter fic;
		System.out.println("\n------------");
		System.out.println("Ruta donde se creara el archivo: " + file); // !Muestor la ruta donde se guardara el doc.
		System.out.println("------------\n");

		try {
			fic = new FileWriter(file);
			BufferedWriter f = new BufferedWriter(fic);

			// los documentos de la coleccion de jugaodres y se escriben en el archivo JSON
			List<Document> c = jugadoresCollection.find().into(new ArrayList<Document>());
			System.out.println("=================");
			System.out.println("ELEMENTOS A AÑADIR: ");
			System.out.println("=================");
			for (int i = 0; i < c.size(); i++) {

				System.out.println("Elemnto: " + i + ", " + c.get(i).toString());
				f.write(c.get(i).toJson());
				f.newLine();
			}
			f.close(); // Se cierra el BufferedWriter

		} catch (Exception e) {
			System.out.println("Error: \n");
			e.printStackTrace();
		}

		m.close(); // Se cierra la conexion
	}

	private static void EquiposJSON() {

		// Conexion con MongoDB
		MongoClient m = new MongoClient();
		MongoDatabase database = m.getDatabase("IE_Recu");
		MongoCollection<Document> EquiposCollection = database.getCollection("Equipos");

		// Especificamos la ruta donde se guardara el JSON
		File file = new File("src\\main\\java\\RECUPERACION\\Consultas\\Doc\\Equipos-MONGODB.json");
		FileWriter fic;
		System.out.println("Ruta donde se creara el archivo: " + file); // Mostramos donde se guardo
		try {
			fic = new FileWriter(file);
			BufferedWriter f = new BufferedWriter(fic);

			List<Document> c = EquiposCollection.find().into(new ArrayList<Document>());
			System.out.println("=================");
			System.out.println("ELEMENTOS A AÑADIR: ");
			System.out.println("=================");
			for (int i = 0; i < c.size(); i++) {
				System.out.println("Elemnto: " + i + ", " + c.get(i).toString());
				f.write(c.get(i).toJson());
				f.newLine();
			}
			f.close(); // Cerramos BufferedWriter

		} catch (Exception e) {
			System.out.println("Error: \n");
			e.printStackTrace();
		}

		m.close(); // Cerramos conexion MongoDB
	}

	/*
	 * -------METODOS PARA INSERTAR DATOS (SCANNER) DE LAS COLECCIONES: JUGADORES Y
	 * EQUIPOS-------
	 */

	// ! Scanner = Datos
	private static void InsertarDatosScanner(Scanner sc) {
		String s = sc.nextLine();
		while (true) {
			System.err.println("¿A que coleccion le quieres añadir datos? (POR TECLADO)");
			System.out.println("=================");
			System.out.println("1- Jugadores");
			System.out.println("2- Equipos");
			System.out.println("3- Salir");
			System.out.println("=================");
			System.out.print("Escribe tu opcion: ");

			String choice = sc.nextLine();
			int num;

			try {

				num = Integer.parseInt(choice); // Conversion de la opcion a un nº entero
				if (num < 1 || num > 3) {
					// Se verifica si el nº esta dentro del rango valido
					System.err.println("Error: Introduce un número válido (1, 2, o 3).");
					continue; // Se vuelve al inicio del bucle para solicitar nuevamente la opcion
				}
			} catch (NumberFormatException ne) {
				// Si se produce un error en el formato del nº
				System.err.println("Error: Introduce un número válido (1, 2, o 3).");
				continue;
			}

			try {
				switch (num) {
				case 1:
					JugadoresSc(sc);
					break;
				case 2:
					EquiposSc(sc);
					break;
				case 3:
					System.exit(0);

				default:
					break;
				}
			} catch (Exception e) {
				System.out.println("ERROR: \n");
				e.printStackTrace();
			}
		}

	}

	private static void JugadoresSc(Scanner sc) {
		try {
			// ! Conexion con MongoDB
			MongoClient m = new MongoClient();
			MongoDatabase database = m.getDatabase("IE_Recu");
			// !Se selecciona la Base de datos la cual se llama "IE_Recu"

			System.out.println("====================================");
			System.out.println("Datos a insertar: Nombre, Posicion, Equipo");
			System.out.println("====================================\n");
			// Mostramos por pantalla los parametros que vamos a ir introduciendo por
			// teclado

			System.out.println("ENTER PARA CONTINUAR");
			String e = sc.nextLine();

			System.out.println("====================================");
			System.out.print("Nombre del jugador: ");
			String nombre = sc.nextLine();

			System.out.print("Posicion en la que juega: ");
			String posicion = sc.nextLine();

			System.out.print("Equipo en el que juega: ");
			String equipo = sc.nextLine();
			System.out.println("====================================\n");

			Document d = new Document();
			// !Insertamos los datos en las correspondientes datos en el MongoDb
			d.put("nombre", nombre);
			d.put("posiciones", posicion);
			d.put("Equipos", equipo);

			MongoCollection<Document> c = database.getCollection("Jugadores");
			c.insertOne(d); // Se insertan los nuevos campos dentro de la coleccion
			System.out.println("\nInsertado Correctamente.");

			m.close(); // Se cierra conexion con MongoDB
		} catch (Exception e) {
			System.out.println("Error: \n");
			e.printStackTrace();
		}
	}

	private static void EquiposSc(Scanner sc) {
		try {
			// ! Conexion con MongoDB
			MongoClient m = new MongoClient();
			MongoDatabase database = m.getDatabase("IE_Recu");
			// !Se selecciona la Base de datos la cual se llama "IE_Recu"

			System.out.println("====================================");
			System.out.println("Datos a insertar: Nombre, Liga, Entrenador, Capitan, Jugadores");
			System.out.println("====================================");
			// Mostramos por pantalla los parametros que vamos a ir introduciendo por
			// teclado

			System.out.println("Enter para continuar");
			String e1 = sc.nextLine();

			System.out.println("====================================");
			System.out.print("Nombre del Equipo: ");
			String nombreequ = sc.nextLine();

			System.out.print("Liga: ");
			String liga = sc.nextLine();

			System.out.print("Entrenador del Equipo: ");
			String entrenador = sc.nextLine();

			System.out.print("Capitan del Equipo: ");
			String capitan = sc.nextLine();
			System.out.print("Jugadores del Equipo: ");
			String jugadores = sc.nextLine();
			System.out.println("====================================");

			Document d = new Document();
			d.put("nombre", nombreequ);
			d.put("liga", liga);
			d.put("Entrenador", entrenador);
			d.put("Capitan", capitan);
			d.put("Jugadores", jugadores);

			MongoCollection<Document> c = database.getCollection("Equipos");
			c.insertOne(d); // Se insertan los nuevos campos dentro de la coleccion
			System.out.println("\nInsertado Correctamente.");

			m.close(); // Se cierra la conexion
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * -------METODOS PARA BORRAR DATOS-------
	 */
	private static void Borrar(Scanner sc) {

		String enter = sc.nextLine();

		// Solicitamos la coleccion que queremos hacer las modificaciones
		while (true) {

			System.out.println("¿A qué colección le quieres borrar datos? (POR TECLADO)");
			System.out.println("=================");
			System.out.println("1- Jugadores");
			System.out.println("2- Equipos");
			System.out.println("3- Salir");
			System.out.println("=================");
			System.out.print("Escribe tu opcion: ");

			String choice = sc.nextLine();

			int num;
			try {

				num = Integer.parseInt(choice); // Conversion de la opcion a un nº entero
				if (num < 1 || num > 3) {
					// Se verifica si el nº esta dentro del rango valido
					System.err.println("Error: Introduce un número válido (1, 2, o 3).");
					continue; // Se vuelve al inicio del bucle para solicitar nuevamente la opcion
				}
			} catch (NumberFormatException e) {
				// Si se produce un error en el formato del nº
				System.err.println("Error: Introduce un número válido (1, 2, o 3).");
				continue;
			}

			try {

				switch (num) {
				case 1:
					JugadoresBorrar(sc); // Metodo de los jugadores
					break;
				case 2:
					EquiposBorrar(sc); // Metodo del equipo
					break;
				case 3:
					System.exit(0); // salir
				default:
					System.out.println("Opción inválida.");
				}

			} catch (Exception e) {
				System.out.println("Error: \n");
				e.printStackTrace();
			}
		}

	}

	private static void JugadoresBorrar(Scanner sc) {
		MongoClient m = new MongoClient();
		MongoDatabase db = m.getDatabase("IE_Recu");
		System.out.println("\nIntroduce el ID del jugador que quieras borrar: ");
		MongoCollection<Document> jugadores = db.getCollection("Jugadores");

		String id = sc.nextLine(); // Se lee el ID introduccido

		if (!isId(id)) {
			// Se verifica si es valido, si no lo es se muestra el mensje de error
			System.err.println("No es valido");

		}

		DeleteResult dr = jugadores.deleteOne(Filters.eq("_id", new ObjectId(id)));
		// Se elimina el jugador de la coleccion usando el ID

		if (dr.getDeletedCount() == 1) { // Si se ha elimidado el jugador correctamente
			System.out.println("\nSe ha borrado el jugador con el ID: " + id);

		} else { // si no se ha encontrado ningun jugador
			System.out.println("No se ha encontrado ningun jugador");
		}

	}

	private static void EquiposBorrar(Scanner sc) {
		MongoClient m = new MongoClient();
		MongoDatabase db = m.getDatabase("IE_Recu");
		MongoCollection<Document> Equipos = db.getCollection("Equipos");

		System.out.println("\nIntroduce el ID del equipo que quieras borrar: ");
		String id = sc.nextLine();

		if (!isId(id)) {
			// Verificamos el ID
			System.err.println("No es valido");

		}

		DeleteResult dr = Equipos.deleteOne(Filters.eq("_id", new ObjectId(id)));
		// se elimina el equipo de la coleccion usando el ID
		if (dr.getDeletedCount() == 1) {
			// Si se ha eliminado el equipo correctamente
			System.out.println("\nSe ha borrado el equipo con el ID: " + id);

		} else {// si no se ha encontrado ningun equipos
			System.out.println("No se ha encontrado ningun equipo.");
		}
	}

	// Metodo para verificar ID
	private static boolean isId(String id) {
		try {
			new ObjectId(id);
			// Crear un objeto con el id proporcionado

			return true; // Si no se procudce ningun error (Vamos, que si es valido el ID)
		} catch (IllegalArgumentException e) {
			return false; // Si no es valido el ID
		}
	}

	/*
	 * -------METODOS PARA VISUALIZAR DATOS-------
	 */
	private static void VisualizarDatos(Scanner sc) {
		String s = sc.nextLine();
		while (true) {
			System.err.println("¿A que coleccion le quieres visualizar datos? ");
			System.out.println("=================");
			System.out.println("1- Jugadores");
			System.out.println("2- Equipos");
			System.out.println("3- Salir");
			System.out.println("=================");
			System.out.print("Escribe tu opcion: ");

			String choice = sc.nextLine();

			int num;
			try {

				num = Integer.parseInt(choice); // Conversion de la opcion a un nº entero
				if (num < 1 || num > 3) {
					// Se verifica si el nº esta dentro del rango valido
					System.err.println("Error: Introduce un número válido (1, 2, o 3).");
					continue; // Se vuelve al inicio del bucle para solicitar nuevamente la opcion
				}
			} catch (NumberFormatException ne) {
				// Si se produce un error en el formato del nº
				System.err.println("Error: Introduce un número válido (1, 2, o 3).");
				continue;
			}

			try {
				switch (num) {
				case 1:
					JugadoresVis(sc);
					break;
				case 2:
					EquiposVIs(sc);
					break;
				case 3:
					System.exit(0);

				default:
					System.out.println("Opción inválida.");
				}
			} catch (Exception en) {
				System.out.println("ERROR: \n");
				en.printStackTrace();
			}

		}
	}

	private static void JugadoresVis(Scanner sc) {
		// Conexion con MongoDB
		MongoClient m = new MongoClient();
		MongoDatabase db = m.getDatabase("IE_Recu");

		MongoCollection<Document> c = db.getCollection("Jugadores"); // !Coleccion

		List<Document> consulta = c.find().into(new ArrayList<Document>());
		// Se hace la consulta para obtener todas las entradas de la coleccion pre
		// seleccionada arriba ⤴️

		// Se recorre las entrads obteniendo las consultas
		for (int i = 0; i < consulta.size(); i++) {
			Document Jugadores = consulta.get(i);
			// Se obtienen los resultados de la coleccion: Jugadores
			System.out.println("===================================");
			System.out.println("Jugador: " + Jugadores.toString());
			System.out.println("===================================");
		}
		m.close();
	}

	private static void EquiposVIs(Scanner sc) {
		// Conexion con MongoDB
		MongoClient m = new MongoClient();
		MongoDatabase db = m.getDatabase("IE_Recu");

		MongoCollection<Document> c = db.getCollection("Equipos"); // !Coleccion

		List<Document> consulta = c.find().into(new ArrayList<Document>());
		// Se hace la consulta para obtener todas las entradas de la coleccion pre
		// seleccionada arriba ⤴️

		// Se recorre las entrads obteniendo las consultas
		for (int i = 0; i < consulta.size(); i++) {
			Document Equipos = consulta.get(i);
			// Se obtienen los resultados de la coleccion: Equipos
			System.out.println("===================================");
			System.out.println("Equipos: " + Equipos.toString());
			System.out.println("===================================");
		}
		m.close();
	}

	// !End Program
}
