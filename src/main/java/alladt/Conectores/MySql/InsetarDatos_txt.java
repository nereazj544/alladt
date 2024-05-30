package alladt.Conectores.MySql;



import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsetarDatos_txt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("> Inserta la ruta del archivo txt: ");
        String ruta = sc.nextLine();

        File fl = new File(ruta);

        if (!fl.exists() | !fl.isFile()) {
            System.out.println("> No existe o no es un fichero.");
            System.exit(0);
        }

        sc.close();
        try {
            Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/napoles?useSSL=true&serverTimezone=UTC", "haku", "123");
            BufferedReader br = new BufferedReader(new FileReader(fl));
            String sql = ("INSERT INTO departamentos VALUES ( ?,?,?)");
            PreparedStatement ps = conexion.prepareStatement(sql);

            String linea;

            while ((linea = br.readLine()) != null) {
                String []  v  = linea.split(","); 
                // String []  v  = linea.split("\\s+");
                int d = Integer.parseInt(v[0].trim());
                String n = v[1].trim();
                String l = v[2].trim();
                
                ps.setInt(1, d);
                ps.setString(2, n);
                ps.setString(3, l);

                int f = ps.executeUpdate();

                System.out.println("Lineas afectadas: " + f);
            }
            

            conexion.close();
            br.close();
        } catch (SQLException e) {
            System.out
                    .println("> El sistema no a encontrado la base de datos, la tabla o el campo.\n O campo repetido");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("> El sistema no a encontrado el archivo.");
            System.out.println("> Expecificacion del error: ");
            e.printStackTrace();
        }
    }
}
