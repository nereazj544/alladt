package OtrosEjercicios_.Conectores.Ejercicios;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actividad_2dot08 { //es literalmente EjemploDatabaseMetadata pero con sqlite
	public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection
					("jdbc:sqlite:C:\\Users\\Tarde\\Desktop\\ADT\\databases\\sqlite\\ejemplo.db");
						//SQLite
			DatabaseMetaData dbmd = conexion.getMetaData();
			ResultSet resul = null;
			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();
			System.out.println("INFORMACI�N SOBRE LA BASE DE DATOS:");
			System.out.println("----------------------------------");
			System.out.printf("Nombre: %s %n", nombre);
			System.out.printf("Driver: %s %n", driver);
			System.out.printf("URL: %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);
			// Obtener informaci�n de las tablas y vistas que hay
			resul = dbmd.getTables("ejemplo1", "ejemplo", null, null); //si en vez de ejemplo1 pones null, saca T0D0 lo que haya
			while (resul.next()) {
				String catalogo = resul.getString(1);// columna 1 (catalogo) (tmb "TABLE_CAT")
				String esquema = resul.getString(2); // columna 2 (esquema) (tmb "TABLE_SCHEM")
				String tabla = resul.getString(3); // columna 3 (nombre) (tmb "TABLE_NAME")
				String tipo = resul.getString(4); // columna 4 (tipo) (tmb "TABLE_TYPE")
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
			conexion.close(); // Cerrar conexi�n
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// fin de main
}// fin de la clase
