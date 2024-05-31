package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ActualizarDatosEmps {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("ARGUMENTOS ERRONEOS");
			System.exit(0);
		}
		try {
			// Establecemos la conexi�n con la BD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");

			// recuperar argumentos de main
			String subida = args[0]; // subida de salario
			String dep = args[1]; // numero de dep

			if (departamentoExists(dep)) {

				// construir orden UPDATE
				String sql = "UPDATE empleados SET salario=salario + ? WHERE dept_no = ?";

				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setFloat(1, Float.parseFloat(subida)); // subida
				sentencia.setInt(2, Integer.parseInt(dep)); // num departamento

				int filas = sentencia.executeUpdate(); // filas afectadas
				System.out.println("Filas afectadas: " + filas);

				sentencia.close();
			} else {
				System.out.println("else");
			}
			System.out.println("end main");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static boolean departamentoExists(String dep) {
		try {
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC",
					"usuario", "contrase�a");
			String sql = "SELECT * FROM departamentos WHERE dept_no = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep)); // num departamento
			sentencia.execute();
			ResultSet rs = sentencia.getResultSet();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return false;
	}
}
