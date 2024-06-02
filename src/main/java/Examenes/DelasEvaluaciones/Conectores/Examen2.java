package Examenes.DelasEvaluaciones.Conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Examen2 {
	public static void main(String[] args) {
		try {
			//crear conexion
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/examen? UseSSL=true & serverTimezone=UTC", "ExamenAPL", "Examen-2");
			
			//comprueba que tabla
			int queTabla = Integer.parseInt(args[0]);
			String tablas = null;
			String[] array = new String[3];
			switch (queTabla) { //añadir datos a la sentencia
			case 1: // CLIENTES
				array[0] = "5, 'PILAR MARTÍN', 'C/Félix Fernández 12', 'Cáceres', '927229988', '11223434L'";
				array[1] = "6, 'FERNANDO GARCÍA', 'C/Serrano 25', 'Madrid', '916754554', '88004320E'";
				array[2] = "7, 'PEDRO AGUILAR', 'Av Valdecañas 1', 'Navalmoral', '927908790', '4133219J'";
				tablas = "CLIENTES";
				break;
			case 2: // PRODUCTOS
				array[0] = "1, 'Cubo de basura rojo 20 litros', 20, 2, 12.00";
				array[1] = "2, '200 lapices Staedtler', 15, 2, 15.25";
				array[2] = "3, 'Flamenco chill in, 2 discos', 14, 1, 8.00";
				tablas = "PRODUCTOS";
				break;
			default: //si no fuese un dato correcto, no se ejecuta
				System.out.println("NO SE HA INTRODUCIDO UN VALOR CORRECTO");
				System.exit(0);
			}
			if (tablas != null) {
				int filas = 0;
				Statement sentencia = null;
				for (int i = 0; i < array.length; i++) { //se inserta en la tabla correspondiente los valores
					String sql = "INSERT INTO " + tablas + " VALUES(" + array[i] + ");";
					System.out.println(sql);
					sentencia = conexion.createStatement();
					sentencia.execute(sql);
					filas++;
				}
				System.out.printf("Filas afectadas: %d %n", filas);
				sentencia.close(); 
			} 
			conexion.close(); 
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}

