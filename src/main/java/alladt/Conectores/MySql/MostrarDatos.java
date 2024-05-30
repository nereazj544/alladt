package alladt.Conectores.MySql;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MostrarDatos {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/napoles?useSSL=true&serverTimezone=UTC", "haku", "123");
            Statement s = conexion.createStatement();
            String sql = "SELECT * FROM departamentos";
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                System.out.println("> Departamentos: ");
                System.out.println(r.getInt(1));
                System.out.println(r.getString(3));
                System.out.println(r.getString(2));
            }
            
            System.out.println("============================");
            String sql1 = "SELECT * FROM empleados";
            r = s.executeQuery(sql1);
            while (r.next()) {
                System.out.println("> Empleados:");
                System.out.println( "> Nº empleado: "+ r.getInt("emp_no") + 
                "\n> Apellido: " +  r.getString("apellido") + 
                "" + r.getString("oficio"));
            }

        } catch (SQLException e) {
            System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo.");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }
    }
}
