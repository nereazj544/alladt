package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ProcSubida {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc Driver");
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
			// recuperar par�metros de main
			String dep = args[0]; // departamento
			String subida = args[1]; // subida
			// construir orden de llamada
			String sql = "{ call subida_sal (?, ?) }";
			// Preparar la llamada
			CallableStatement llamada = conexion.prepareCall(sql);
			// Dar valor a los argumentos
			llamada.setInt(1, Integer.parseInt(dep)); // primero
			llamada.setFloat(2, Float.parseFloat(subida)); // segundo
			// Ejecutar el procedimiento
			llamada.executeUpdate();
			System.out.println("Subida realizada....");
			llamada.close();
			conexion.close();
		} catch (ClassNotFoundException cn) {

		} catch (SQLException e) {

		}
	}
}
