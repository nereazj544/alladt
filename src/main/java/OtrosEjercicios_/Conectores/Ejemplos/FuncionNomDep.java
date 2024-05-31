package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.*;

public class FuncionNomDep {
	public static String depS;

	public static void main(String[] args) {
		// faltaría controlar que el nº de argumentos es correcto
		depS = args[0];

		try {
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejemplo? UseSSL=true & serverTimezone =UTC", "ejemplo", "ejemplo");

			String sql = "{ ? = call nombre_dep (?) } "; // MYSQL

			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);

			llamada.registerOutParameter(1, Types.VARCHAR); // valor devuelto
			llamada.setInt(2, Integer.parseInt(depS)); // param de entrada

			llamada.executeUpdate(); // ejecutar el procedimiento
			System.out.println("Departamento: " + depS + " - Nombre Dep: " + llamada.getString(1));
			llamada.close();
			conexion.close();

		} catch (SQLException e) {
			// Falta controlar las distintas EXCEPTION que se puedan producir
			e.printStackTrace();
		}
	}// fin de main
}// fin de la clase
