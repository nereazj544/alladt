package OtrosEjercicios_.Conectores.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Actividad_2dot11 {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("ARGUMENTOS ERRONEOS");
			System.exit(0);
		}
		try {
			// Establecemos la conexi�n con la BD
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");

			// recuperar argumentos de main
			String dep = args[0]; 

			if (departamentoExists(dep)) {

				// construir sentencia sql
				String sql = "SELECT empleados.apellidos, empleados.salario, empleados.oficio, departamentos.dnombre "
						+ "FROM EMPLEADOS INNER JOIN DEPARTAMENTOS ON empleados.dept_no = departamentos.dept_no "
						+ "WHERE departamentos.dept_no = ?";
				
				//establecemos la conexion entre la sentencia y la base de datos; y ejecutamos la sentencia
				PreparedStatement sentencia = conexion.prepareStatement(sql);
				sentencia.setInt(1, Integer.parseInt(dep));
				sentencia.execute();
				
				
				ResultSet rs = sentencia.getResultSet();
				if (rs.first()) { //si la condicion WHERE se cumple
					int numEmps = 0;
					float media = 0;
					rs.next();
					System.out.println("==============================");
					System.out.println("DEPARTAMENTO " + dep + " --> " + rs.getString(4));
					System.out.println("==============================");
					rs.beforeFirst();
					while (rs.next()) { //se imprime cada fila que cumple la condicion
						System.out.printf("%s, %d, %s, %s %n", rs.getString(1), rs.getInt(2), rs.getString(3),
								rs.getString(4));
						numEmps++; //se suma 1 al numero de empleados
						media += rs.getInt(2); //se suma su salario al total de salarios
					}

					System.out.println("-------------------------");
					System.out.println("Salario medio: " + media / numEmps); //se haya la media
					System.out.println("N�mero de empleados: " + numEmps);
				} else { //si no se cumple la condici�n WHERE en ninguna fila
					System.out.println("EL DEPARTAMENTO " + dep + " NO TIENE EMPLEADOS");
				}

				sentencia.close();
			} else //si no se encuentra un departamento con el n�mero introducido
				System.out.println("NO EXISTE EL DEPARTAMENTO INTRODUCIDO");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static boolean departamentoExists(String dep) {
		try {
			//se crea una conexi�n con la base de datos, cambiando la sentencia para ver si existe el departamento
			Connection conexion;
			conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC",
					"usuario", "contrase�a");
			String sql = "SELECT * FROM departamentos WHERE departamentos.dept_no = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql);
			sentencia.setInt(1, Integer.parseInt(dep)); 
			sentencia.execute();
			ResultSet rs = sentencia.getResultSet(); //se recoge el resultado para saber el n�mero de filas
			return rs.first(); //si existe o no el departamento
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return false; 
	}
}
