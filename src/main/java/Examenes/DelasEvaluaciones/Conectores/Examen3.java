package Examenes.DelasEvaluaciones.Conectores;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Examen3 {
	public static void main(String[] args) {
		try {
			//creamos la conexion
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/examen? UseSSL=true & serverTimezone=UTC", "ExamenAPL", "Examen-2");
			
			//determinamos el ciente
			int identCli = Integer.parseInt(args[0]);
			
			//comprobamos que existe
			clienteExists(identCli);
			
			//establecemos sentencia
			String sql = "select clientes.NOMBRE, ventas.IDVENTA, ventas.FECHAVENTA, productos.DESCRIPCION, ventas.CANTIDAD, productos.PVP from ventas "
					+ "join clientes on ventas.IDCLIENTE = clientes.id "
					+ "join productos on ventas.IDPRODUCTO = productos.id "
					+ "WHERE clientes.id = 5;";
			
			//ejecutamos sentencia
			PreparedStatement sentencia = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			sentencia.execute();
			
			//recogemos los valores
			ResultSet rs = sentencia.getResultSet();
			rs.first();
			
			//imprimimos los valores
			System.out.println("----------------------------------");
			System.out.println("Ventas del cliente: " + rs.getString(1));
			System.out.println("----------------------------------");
			float total = 0; //suma de todos los precios
			int filas = 0; 
			rs.beforeFirst();
			while (rs.next()) { //mientras haya resultados
				float cantidad = rs.getFloat(5);
				float pvp = rs.getFloat(6);
				float precio = cantidad*pvp;
				System.out.printf("Venta: %d ** %s %n"
						+ "	Producto: %s %n"
						+ "	Cantidad: %d ** PVP: " + rs.getFloat(6) + "%n"
						+ "	Importe: " + precio + " € %n", 
						rs.getInt(2), rs.getDate(3), rs.getString(4), rs.getInt(5));
				total += (rs.getInt(5)*rs.getFloat(6));
				filas++;
			}
			System.out.println("----------------------------------");
			System.out.println("Número total de ventas: " + filas);
			System.out.println("Importe total: " + total);
			System.out.println("----------------------------------");

			sentencia.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean clienteExists(int cli) {
		System.out.println("COMPROBANDO CLIENTE...");
		try { //se realiza otro statement para comprobar si existe el cliente
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/examen? UseSSL=true & serverTimezone=UTC", "ExamenAPL", "Examen-2");
			String sql = "SELECT * FROM CLIENTES WHERE CLIENTES.ID = ?";
			PreparedStatement sentencia = conexion.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			sentencia.setInt(1, cli); 
			sentencia.execute();
			ResultSet rs = sentencia.getResultSet(); //se recoge el resultado para saber el número de filas
			return rs.first(); //si existe o no el departamento
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return false; 
	}
	
}
