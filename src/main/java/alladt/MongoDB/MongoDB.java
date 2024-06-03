package MongoDB;
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

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

//! Clases json 
import org.json.JSONArray;
import org.json.JSONObject;
import org.bson.*;

public class MongoDB {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserte un numero: ");
		int r = sc.nextInt();
		
		switch (r) {
		case 1:
			Conexion();
			break;
		case 2:
			CrearBDyColeccion();
			break;
		case 3:
			Insertardatos();
			break;
		case 4:
			GenerarJSON();
			break;
		case 5:
			InsertarSC();
			break;
		case 6:
			Borrar();
			break;

		default:
			break;
		}

	}
	

	//! Conexion
	private static void Conexion() {
		String t = "Conexion";
		System.out.println("Funcion: " + t);
		MongoClient m = new MongoClient();
		
		System.out.println("> Se ha establecido conexion con MongoDB");
		
		System.exit(0);
	}
	
	//! CrearDB y colecciones
	private static void CrearBDyColeccion() {
		String t = "Crear base de datos junto a coleciones";
		System.out.println("Funcion: " + t);
		MongoClient m = new MongoClient();
		System.out.println("> El sistema ha extablecido conexion con MongoDB");
		MongoDatabase db = m.getDatabase("MongoDB");
		db.createCollection("Coleccion");
		System.out.println("> MongoDB ha creado todo lo que no se encontraba existente.");
	}
	
	//! Insertar Datos
	private static void Insertardatos() {
		String t = "Insertar datos desde JSON";
		System.out.println("Funcion: " + t); 	
		
		try {
String ruta = "D:\\Aeclipse-workspace\\MongoDB\\src\\main\\java\\database\\";
			FileReader fr = new FileReader(ruta + "archivo.json");
			BufferedReader bf = new BufferedReader(fr);
			
			MongoClient m = new MongoClient();
			System.out.println("> El sistema ha extablecido conexion con MongoDB");
			MongoDatabase db = m.getDatabase("MongoDB");
			MongoCollection<Document> c = db.getCollection("Coleccion");
		
			StringBuilder stb= new StringBuilder();
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
		}catch (FileNotFoundException e) {
			System.out.println("> El sistema no ha encontrado ningun archivo.");
		}catch (IOException e) {
			System.out.println("> El sistema no ha podido seguir la orden.");

		}
		
	}
	
	//! Generar JSON
	private static void GenerarJSON() {
		String t = "Generear JSON";
		System.out.println("Funcion: " + t);
		MongoClient m = new MongoClient();
		
		System.out.println("> Se ha establecido conexion con MongoDB");
		MongoDatabase db = m.getDatabase("MongoDB");
		MongoCollection<Document> c = db.getCollection("Coleccion");
		
		System.out.println("> El sistema ha detectado una carpeta contenedora");
		
		
		File fl = new File("D:\\Aeclipse-workspace\\MongoDB\\src\\main\\java\\database\\mongo.json");

		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(fl));
			List<Document> doc = c.find().into(new ArrayList<Document>());
			System.out.println("> El sistema ha añadido las entras en el archivo contendero");
			
			System.out.println("> El sistema ha detectado todos estos elementos: ");
			System.out.println("===============");
			for (int i = 0; i < doc.size(); i++) {
				System.out.println("Elemeto: " + i + ", " + doc.get(i).toString());
				bw.write(doc.get(i).toJson());
				bw.newLine();
			}
			System.out.println("===============");
			bw.close();
			System.out.println("> El sistema ha completado la escritura del archivo.");
		} catch (Exception e) {
			System.out.println("> El sistema no ha podido completar lo pedido.");
			System.exit(0);
		}
		
	}

	//! Insertar con SC
	private static void InsertarSC() {
		String t = "Insertar desde teclado";
		System.out.println("Funcion: " + t);
		MongoClient m = new MongoClient();
		MongoDatabase db = m.getDatabase("MongoDB");
		MongoCollection<Document> c = db.getCollection("Coleccion");
		
		System.out.println("> El sistema socilita los siguientes datos: ");
		Scanner sc = new Scanner (System.in);
	
		System.out.println("> El sistema requiere: Nombre");
		String nombre = sc.nextLine();
	}


	

	private static void Borrar() {
		// TODO Auto-generated method stub
		
	}





}
