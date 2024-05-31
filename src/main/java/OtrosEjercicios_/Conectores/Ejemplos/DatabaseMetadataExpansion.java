package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseMetadataExpansion {

	static Connection conexion;
	static DatabaseMetaData dbmd;
	static ResultSet resul;

	public static void main(String[] args) {
		try {
			conexion = DriverManager.getConnection // MySQL
			("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
			dbmd = conexion.getMetaData();
			resul = null;

			infoBD();
			System.out.printf("%n %n %n");
			columnasTablaDepartamentos();
			System.out.printf("%n %n %n");
			getPKs();
			System.out.printf("%n %n %n");
			getFKs();
			System.out.printf("%n %n %n");

			conexion.close(); // Cerrar conexi�n
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void infoBD() {
		try {
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
			resul = dbmd.getTables("ejemplo1", "ejemplo", null, null); // si en vez de ejemplo1 pones null, saca T0D0 lo
																		// que haya
			while (resul.next()) {
				String catalogo = resul.getString(1);// columna 1 (catalogo) (tmb "TABLE_CAT")
				String esquema = resul.getString(2); // columna 2 (esquema) (tmb "TABLE_SCHEM")
				String tabla = resul.getString(3); // columna 3 (nombre) (tmb "TABLE_NAME")
				String tipo = resul.getString(4); // columna 4 (tipo) (tmb "TABLE_TYPE")
				System.out.printf("%s - Catalogo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void columnasTablaDepartamentos() {
		try {
			System.out.println("COLUMNAS TABLA DEPARTAMENTOS:");
			System.out.println("-----------------------------");
			resul = dbmd.getColumns(null, "ejemplo", "departamentos", null);
			while (resul.next()) {
				String nombCol = resul.getString("COLUMN_NAME"); // getString(4)
				String tipoCol = resul.getString("TYPE_NAME"); // getString(6)
				String tamCol = resul.getString("COLUMN_SIZE"); // getString(7)
				String nula = resul.getString("IS_NULLABLE"); // getString(18)
				System.out.printf("Columna: %s, Tipo: %s, Tama�o: %s, �Puede ser Nula:? %s %n", nombCol, tipoCol,
						tamCol, nula);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void getPKs() {
		try {
			System.out.println("CLAVES PRIMARIAS DEPARTAMENTOS:");
			System.out.println("-------------------------------");
			resul = dbmd.getPrimaryKeys(null, "ejemplo", "departamentos");
			String pkDep = "", separador = "";
			while (resul.next()) {
				pkDep = pkDep + separador + resul.getString("COLUMN_NAME");// getString(4)
				separador = "+";
			}
			System.out.println("Clave Primaria: " + pkDep);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void getFKs() {
		try {
			System.out.println("CLAVES AJENAS DEPARTAMENTOS:");
			System.out.println("----------------------------");
			resul = dbmd.getExportedKeys(null, "ejemplo", "departamentos"); 
				//con empleados no devuelve nada ya que ninguna tabla tiene fk de empleados
			while (resul.next()) {
				String fk_name = resul.getString("FKCOLUMN_NAME");
				String pk_name = resul.getString("PKCOLUMN_NAME");
				String pk_tablename = resul.getString("PKTABLE_NAME");
				String fk_tablename = resul.getString("FKTABLE_NAME");
				System.out.printf("Tabla PK: %s, Clave Primaria: %s %n", pk_tablename, pk_name);
				System.out.printf("Tabla FK: %s, Clave Ajena: %s %n", fk_tablename, fk_name);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
