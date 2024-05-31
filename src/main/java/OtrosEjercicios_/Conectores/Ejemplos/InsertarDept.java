package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertarDept {
	public static void main(String[] args) {
		try {
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
			// recuperar argumentos de main
			String dep = args[0]; // num. departamento
			String dnombre = args[1]; // nombre
			String loc = args[2]; // localidad
			// construir orden INSERT
			String sql = String.format("INSERT INTO departamentos VALUES (%s, '%s', '%s')", dep, dnombre, loc);
			//ej: 50, direcci�n, oviedo (SEPARADAS POR INTRO)
			System.out.println(sql);
			Statement sentencia = conexion.createStatement();
			int filas = sentencia.executeUpdate(sql);
			System.out.printf("Filas afectadas: %d %n", filas);
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}// fin de main
}// fin de la clase
