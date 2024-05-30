package alladt.Conectores.MySql.ProcedimientosyFuncion;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Procedimiento2 {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/napoles?useSSL=true&serverTimezone=UTC", "haku", "123");

            String dep = args[0];
            String subida = args[0];

            String sql = "{call subida_sal (?, ?)}";
            // Se esta usando un procedimiento.s

            CallableStatement l = conexion.prepareCall(sql);

            l.setInt(1, Integer.parseInt(dep));
            l.setFloat(2, Float.parseFloat(subida));

            l.executeUpdate();
            System.out.println("Subida realizada.... ");

        } catch (SQLException e) {
            System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo.");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }
    }
}
