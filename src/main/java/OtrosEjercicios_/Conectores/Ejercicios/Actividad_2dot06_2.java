package OtrosEjercicios_.Conectores.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Actividad_2dot06_2 {
	public static void main(String[] args) {
		try {
			// Establecemos la conexion con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
				//se a�ade la zona horaria ya que si no da error
			
			// Consulta
			Statement sentencia = conexion.createStatement();
			String sql = 
					"SELECT empleados.apellidos, empleados.salario, departamentos.dnombre\r\n"
					+ "FROM empleados\r\n"
					+ "INNER JOIN departamentos ON empleados.dept_no = departamentos.dept_no\r\n"
					+ "WHERE salario = (SELECT MAX(SALARIO) FROM empleados);";
			ResultSet resul = sentencia.executeQuery(sql); 
			
			// Recorremos el resultado para visualizar cada fila
			// Para esto, se hace un bucle mientras haya registros y se van mostrando
			while (resul.next()) {
				System.out.printf("%s %f %s %n", 
						resul.getString(1), //apellidos
						resul.getFloat(2), //salario
						resul.getString(3)); //departamento
			}
			
			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
