package alladt.Conectores.MySql.ProcedimientosyFuncion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class Funcion2 {
    public static void main(String[] args) {
		try {
			Connection conexion = DriverManager.getConnection(
                "jdbc:mysql://localhost/napoles?useSSL=true&serverTimezone=UTC", "haku", "123");

			String num = args[0];

			String sql = "{? = call nombre_dep(?)}";

			CallableStatement c = conexion.prepareCall(sql);
			c.registerOutParameter(1, Types.VARCHAR); //Valor devuelto
			c.setInt(2, Integer.parseInt(num)); //Parámetro de entrada

			c.execute();

			System.out.println("> NUMERO INTRODUCIDO: " + num + "\nResultado de la busqueda:");
			System.out.println("> Nombre del departamento: " + c.getString(1));
//			System.out.println("Localidad del departamento: " + c.getString(3));
			
	}catch (SQLException e) {
        System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo.\n O campo repetido");
        System.out.println("> Expecificacion del error: ");
        e.printStackTrace();
	}
	
	//Main Edn
	}
}
