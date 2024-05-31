package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.*;

public class ProcedimientoSubida2 {
	public static String depS;
	public static String subidaS;

	public static void main(String[] args) {
		// Falta controlar que el nº de argumentos es correcto
		depS = args[0];
		subidaS = args[1];
		try {
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/ejemplo? UseSSL=true & serverTimezone =UTC", "ejemplo", "ejemplo");
			/*
			 * Habría que comprobar que el departamento existe. Ya tenemos alguno hecho en
			 * los de sentencias preparadasparadas Si existe continuamos con la construccion
			 * de llamada ... Si no existe lanzamos un mensaje
			 */
			// construir orden DE LLAMADA
			String sql = "{ call subidaSal2 (?, ?) } ";
			// Preparamos la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			// Damos valor a los argumentos
			llamada.setInt(1, Integer.parseInt(depS)); // primer argumento-dep
			llamada.setFloat(2, Float.parseFloat(subidaS)); // segundo arg
			llamada.executeUpdate(); // ejecutar el procedimiento
			System.out.println("Subida realizada....");
			llamada.close();
			conexion.close();
		} catch (SQLException e) {
			// Falta tratar las posibles EXCEPTION que puedan ocurrir
			e.printStackTrace();
		}

	}// fin de main
}// fin de la clase
