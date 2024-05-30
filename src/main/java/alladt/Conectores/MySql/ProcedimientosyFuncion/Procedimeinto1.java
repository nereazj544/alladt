package alladt.Conectores.MySql.ProcedimientosyFuncion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedimeinto1 {
    public static void main(String[] args) {
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/napoles?useSSL=true&serverTimezone=UTC", "haku", "123");
            String procedimiento = "{call pro1}";


                
        }catch (SQLException e) {
            System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo.\n O campo repetido");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }
    }
}
