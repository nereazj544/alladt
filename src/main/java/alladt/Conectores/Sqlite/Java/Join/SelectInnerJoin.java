package alladt.Conectores.Sqlite.Java.Join;

import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectInnerJoin {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\Users\\nzjha\\Desktop\\CLASE\\alladt\\src\\main\\java\\alladt\\Conectores\\Sqlite\\DATABASE\\Sqlite_EmpleadosDepartamentos.db");

            Scanner sc = new Scanner(System.in);
            System.out.println("> El sistema necesita que se ingrese un numero: ");
            int numero = sc.nextInt();

            // Statement s = conexion.createStatement();
            String sql = "SELECT empleados.apellido, departamentos.dnombre " +
                    "FROM empleados "
                    + " INNER JOIN departamentos " +
                    "ON empleados.dept_no = departamentos.dept_no " +
                    "WHERE departamentos.dept_no = ?";

            PreparedStatement ps = conexion.prepareStatement(sql);
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            System.out.printf("> El sistema ha detectado el nº '%d' \n", numero);
            while (rs.next()) {
                System.out.println("Apellido: " + rs.getString("apellido"));
                System.out.println("Departamento: " + rs.getString("dnombre"));
            }

            conexion.close();
            sc.close();
        } catch (SQLException e) {
            System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo, campo repetido");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }
    }
}
