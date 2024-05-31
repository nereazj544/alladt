package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class ProcedimientoNomDep {

	public static String depS;

	public static void main(String[] args) {
		// Falta controlar nº de argumentos es correcto
		depS = args[0];
		try {
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejemplo? UseSSL=true & serverTimezone =UTC", "ejemplo", "ejemplo");
			// Construir orden de llamada
			String sql = "{call datos_dep (?, ?, ?) } "; // MYSQL
			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);

			llamada.setInt(1, Integer.parseInt(depS)); // param de entrada
			// Registrar parametro salida
			llamada.registerOutParameter(2, Types.VARCHAR); // parametro OUT

			// Registrar parametro de salida
			llamada.registerOutParameter(3, Types.VARCHAR); // parametro OUT
			// Ejecutar procedimiento
			llamada.execute();
			System.out.printf("Departamento: %s - Nombre: %s - Localidad: %s", depS, llamada.getString(2),
					llamada.getString(3));
			llamada.close();
			conexion.close();
		} catch (SQLException e) {
			// Falta tratar las posibles EXCEPTION que se puedan producir
			e.printStackTrace();
		}
	}// fin de main
}// fin de la clase
