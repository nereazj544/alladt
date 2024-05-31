package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDeptPreparedStatement {
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("ARGUMENTOS ERRONEOS");
			System.exit(0);
		}
		try {
			// Establecemos la conexi�n con la BD
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
			
			//recuperar argumentos de main
			String dep = args[0]; //num.dep
			String dnombre = args[1]; //nombre
			String loc = args[2]; //localidad
			
			//construir orden INSERT
			String sql = "INSERT INTO departamentos VALUES " +  "( ?, ?, ? )"; //( 1, 2, 3 )
			
			System.out.println(sql);
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			//Al asignar los valores, ya paresamos con el m�todo setXXX
			sentencia.setInt(1, Integer.parseInt(dep)); //puede lanzar ArithmeticException
			sentencia.setString(2, dnombre);
			sentencia.setString(3, loc);
			
			int filas; //
			filas = sentencia.executeUpdate();
			System.out.println("Filas afectadas: " + filas);
			
			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ArithmeticException e) {
			
		}
	}
}
