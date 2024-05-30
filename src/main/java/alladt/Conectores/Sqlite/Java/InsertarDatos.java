package alladt.Conectores.Sqlite.Java;

import java.util.Scanner;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarDatos {
    public static void main(String[] args) {
        try {
            Connection conexion = DriverManager.getConnection(
                    "jdbc:sqlite:C:\\Users\\nzjha\\Desktop\\CLASE\\alladt\\src\\main\\java\\alladt\\Conectores\\Sqlite\\DATABASE\\sqlite.db");

            // ! Con Args
            if (args.length != 3) {
                System.out.println("> No has insertado datos correctos. Insete: nº departamento, nombre y localidad.");
                System.exit(0);
            }

            String d = args[0];
            String dn = args[1];
            String l = args[2];

            String sql = ("INSERT INTO departamentos VALUES ( " + d + ", '" + dn + "' , '" + l + "')"); 
            // ! Si se hace de esta manera es importante añadir las '' a los textos.

            Statement s = conexion.createStatement();
            int f = s.executeUpdate(sql);

            System.out.println("> Datos insertados: ");
            System.out.println("> Numero del nuevo Departamento: " + d);
            System.out.println("> Nombre del nuevo Departamento: " + dn);
            System.out.println("> Localidad del nuevo Departamento: " + l);

            System.out.println("===============");
            System.out.println("> Filas afectadas: " + f);
            System.out.println("===============");

            // !con Scanner + Sentencia prepraradas
            Scanner sc = new Scanner(System.in);
            System.out.println("> Introduce datos para nuevo empleado");

            // 1
            System.out.println("> Nº empleado: ");
            int emp_no = Integer.parseInt(sc.nextLine());

            // 2
            System.out.println("> Apellido empleado: ");
            String apellido = sc.nextLine();

            
            
            // 3
            System.out.println("> Oficio empleado: ");
            String oficio = sc.nextLine();
            
            // 4
            System.out.println("> Direccion (numero) empleado: ");
            int direcion = Integer.parseInt(sc.nextLine());
            
           
            // 5
            System.out.println("> Fecha de alta (AÑO-MES-DIA) empleado: ");
            String fecha = sc.nextLine();

            // 6
            System.out.println("> Salario empleado: ");
            double salario = Double.parseDouble(sc.nextLine());

            // 7
            System.out.println("> Comision empleado: ");
            double comision = Double.parseDouble(sc.nextLine());
          

            String sqlpreparada = ("INSERT INTO departamentos VALUES ( ?,?,?, ?,?,?, ?)");
            PreparedStatement ps = conexion.prepareStatement(sqlpreparada);
            ps.setInt(1, emp_no);
            ps.setString(2, apellido);
            ps.setString(3, oficio);
            ps.setInt(4, direcion);
            ps.setString(5, fecha);
            ps.setDouble(6, salario);
            ps.setDouble(7, comision);
            

            

            int filas = ps.executeUpdate(sqlpreparada);
            System.out.println("> Datos insetados. Nº de filas afectadas: " + filas);

            sc.close();
        
        } catch (SQLException e) {
            System.out.println("> El sistema no a encontrado la base de datos, la tabla o el campo.\n O campo repetido");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }
}
}
