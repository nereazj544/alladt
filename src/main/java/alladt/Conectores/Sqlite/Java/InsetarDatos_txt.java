package alladt.Conectores.Sqlite.Java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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
                    "jdbc:sqlite:C:\\Users\\nzjha\\Desktop\\CLASE\\alladt\\src\\main\\java\\alladt\\Conectores\\Sqlite\\DATABASE\\sqlite.db");
            BufferedReader br = new BufferedReader(new FileReader(fl));
            String sqlpreparada = ("INSERT INTO departamentos VALUES ( ?,?,?)");
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
