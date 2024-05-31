package OtrosEjercicios_.Conectores.Ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;
import java.util.regex.Pattern;

public class Actividad_2dot10 {
	public static void main(String[] args) {
		if (args.length == 7) {
			try {
				// Establecemos la conexion con la BD
				Connection conexion = DriverManager.getConnection(
						"jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
				// recuperar argumentos de main
				Pattern.compile("\\W");
				int emp_no = Integer.parseInt(args[0]);
				String apellidos = args[1];
				String oficio = args[2];
				int dir = Integer.parseInt(args[3]);
				Float salario = Float.parseFloat(args[4]);
				Float comision = Float.parseFloat(args[5]);
				int dept_no = Integer.parseInt(args[6]);
				if (apellidos.matches("\\W") || oficio.matches("\\W")) {
					throw new Exception("");
				}
				// construir orden INSERT
				String sql = String.format(
						"INSERT INTO " + "empleados(emp_no, apellidos, oficio, dir, salario, comision, dept_no) "
								+ "VALUES(%s, '%s', '%s', %s, %s, %s, %s);",
						// 1111 Apellidos Oficio 2222 3333.33 444 50
						"" + emp_no, apellidos, oficio, "" + dir, "" + salario, "" + comision, "" + dept_no);
				System.out.println("Ha introducido la sentencia: " + sql);
				Statement sentencia = conexion.createStatement();
				int filas = sentencia.executeUpdate(sql);
				System.out.printf("Filas afectadas: %d %n", filas);
				sentencia.close(); // Cerrar Statement
				conexion.close(); // Cerrar conexi�n
			} catch (SQLIntegrityConstraintViolationException e) { 
				System.out.println("ERROR: uno de los datos introducidos no concuerda con las restricciones de la base de datos.");
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				System.out.println("ERROR: se ha introducido un n�mero inv�lido");
			} catch (Exception e) {
				System.out.println("ERROR: se ha introducido una linea de texto inv�lida");
				e.printStackTrace();
			}
		} else if (args.length < 7) {
			System.out.println("ERROR: no se han introducido todos los datos");
		} else { // mas de 7 args
			System.out.println("ERROR: se han introducido m�s argumentos de los posibles");
		}
	}// fin de main
}
