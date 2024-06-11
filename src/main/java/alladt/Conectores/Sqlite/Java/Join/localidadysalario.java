package alladt.Conectores.Sqlite.Java.Join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class localidadysalario {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:C:\\Users\\nzjha\\Desktop\\CLASE\\alladt\\src\\main\\java\\alladt\\Conectores\\Sqlite\\DATABASE\\Sqlite_EmpleadosDepartamentos.db";

        /*
         * ! SALARIO MAXIMO
         * Select MAX(salario) FROM empleados;
         */
        try (Connection connection = DriverManager.getConnection(url)) {
            // Con esto ya no hace falta cerrarlo

            if (args.length != 2) {
                System.out.println("> El sistema no ha detectado ningun parametro por argumento");
                System.exit(0);
            }

            String localidad = args[0];
            String numero = args[1];

            String sql = "SELECT MAX(empleados.salario), empleados.apellido, departamentos.dnombre "
                    + "FROM empleados "
                    + "INNER JOIN departamentos " +
                    "ON empleados.dept_no = departamentos.dept_no " +
                    "WHERE departamentos.dept_no = ? AND departamentos.loc = ?";

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(numero));
            ps.setString(2, localidad);
            ResultSet rs = ps.executeQuery();
            System.out.printf("> El sistema ha detectado el nº '%s' y la localidad '%s' %n", numero, localidad);
            while (rs.next()) {
                System.out.println("Departamento: " + rs.getString("dnombre"));
                System.out.println("Salario Maximo: " + rs.getDouble(1));
                System.out.println("Apellido: " + rs.getString("apellido"));
            }

        } catch (SQLException e) {
            System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo, campo repetido");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();

        }
    }
}