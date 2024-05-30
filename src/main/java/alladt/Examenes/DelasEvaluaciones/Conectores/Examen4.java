package alladt.Examenes.DelasEvaluaciones.Conectores;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Examen4 {
	public static String depS;

	public static void main(String[] args) {
		if (args.length != 2) { //si no hubiese suficientes argumentos, no se ejecutaria
			System.out.println("ARGUMENTOS ERRONEOS");
			System.exit(0);
		}
		try {
			//se establece la conexion
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/examen? UseSSL=true & serverTimezone=UTC", "ExamenAPL", "Examen-2");
			
			//establecemos la sentencia y le asignamos los valores
			String sql = "{call subidastock (?, ?) } "; 
			CallableStatement llamada = conexion.prepareCall(sql);
			llamada.setInt(1, Integer.parseInt(args[0])); 
			llamada.setInt(2, Integer.parseInt(args[1]));
			
			//ejecutamos la sentencia
			System.out.println(sql);
			int filas = llamada.executeUpdate();
			System.out.println("FILAS AFECTADAS = " + filas);
			
			llamada.close();
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
