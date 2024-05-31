package OtrosEjercicios_.Conectores.Ejemplos;

import java.sql.*;

public class conectarListaDepartamentos_01 {
	public static void main(String[] args) {
		try {
			// Cargar el driver
//			Class.forName("com.mysql.cj.jdbc.Driver");
//			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			
			// Establecemos la conexion con la BD
			//getConnection(String url, String user, String password);
			Connection conexion = DriverManager.getConnection
					("jdbc:mysql://localhost/ejemplo1? UseSSL=true & serverTimezone=UTC", "usuario", "contrase�a");
						//MYSQL
//					("jdbc:sqlite:C:\\Users\\Tarde\\Desktop\\ADT\\databases\\sqlite\\ejemplo.db");
						//SQLITE
//					("jdbc:derby:C:\\Users\\Tarde\\Desktop\\ADT\\databases\\apache_derby\\ejemplo");
						//APACHE DERBY
							//FIXME Error occurred during initialization of boot layer
							// java.lang.module.FindException: Module org.apache.derby.commons not found, required by org.apache.derby.engine
//					("jdbc:hsqldb:file:C:\\Users\\Tarde\\Desktop\\ADT\\databases\\hsqldb");
						//HSQLDB
							//FIXME SQLSyntaxErrorException: usuario no tiene privilegios suficientes o objeto no encontrado: DEPARTAMENTOS
//					("jdbc:h2:C:\\Users\\Tarde\\Desktop\\ADT\\databases\\h2\\ejemplo", "sa", "");
						//H2
					//FIXME AMBOS FIXME FUNCIONAN CON MAVEN
			// Preparamos la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM departamentos";
			ResultSet resul = sentencia.executeQuery(sql);
			
			// Recorremos el resultado para visualizar cada fila
			// Se hace un bucle mientras haya registros y se van mostrando
			
//			resul.last();
//			System.out.println("NUMERO DE FILAS: " + resul.getRow());
//			resul.beforeFirst();
			
			while (resul.next()) {
//				System.out.printf("Fila %d: %d, %s, %s %n", //tambien se puede poder cadenas en vez de nums
				System.out.printf("%d, %s, %s %n",
//						resul.getRow(),
						resul.getInt(1), //resul.getInt("dept_no"),
						resul.getString(2), //resul.getString("dnombre"), 
						resul.getString(3)); //resul.getString("loc")
			}
			
			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n
		} catch (SQLException e) {
			e.printStackTrace();
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
		}
	}
}
