package OtrosEjercicios_.Conectores.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad_2dot06 {
	public static void main(String[] args) {
		try {
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
				//se a�ade la zona horaria ya que si no da error
			
			// Consulta
			Statement sentencia = conexion.createStatement();
			String sql = 
					"SELECT apellidos, oficio, salario "
					+ "FROM empleados "
					+ "WHERE dept_no = 10";
			ResultSet resul = sentencia.executeQuery(sql); 
			
			// Recorremos el resultado para visualizar cada fila
			// Para esto, se hace un bucle mientras haya registros y se van mostrando
			while (resul.next()) {
				System.out.printf("%s, %s %f %n", 
						resul.getString(1), //apellidos
						resul.getString(2), //oficio
						resul.getFloat(3)); //salario
//				System.out.println();
			}
			
			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
