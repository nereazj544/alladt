package alladt.Ficheros.randomsccessfile.Ejmplos;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Scanner;

public class Tienda {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("> Ruta del archivo '.dat' : ");
        String ruta = sc.nextLine();

        System.out.println("> Crear o Consulta: ");
        String respuesta = sc.nextLine();

        switch (respuesta) {
            case "crear":
                Crear(ruta);
                break;
            case "consulta":
                Consulta(sc, ruta);
                break;

            default:
                System.out.println("> No has escrito 'Crear' o 'Consulta'");
                break;
        }
    }

    private static void Crear(String ruta) {
        System.out.println("> Funcion crear");

        ArrayList<Productos> productos = new ArrayList<>();
        productos.add(new Productos(1, "p", 30.93));
        productos.add(new Productos(2, "s", 40.09));
        productos.add(new Productos(3, "pd", 0.89));

        try (RandomAccessFile rf = new RandomAccessFile(ruta, "rw")) {

            for (Productos p : productos) {
                rf.writeInt(p.getId());
                rf.writeDouble(p.getPrecio());
                StringBuffer sb = new StringBuffer(p.getNombre());
                sb.setLength(10);
                rf.writeChars(sb.toString());
            }
            System.out.println("> Se han añadidio los datos.");
        } catch (FileNotFoundException e) {
            System.out.println("> El sistema no ha encontrado la ruta o el fichero expecificado. \n> A continuacion el error expecificado: ");
            e.printStackTrace();
        }catch(IOException e){
            System.out.println("> El sistema no ha encontrado la ruta o el fichero expecificado. \n> A continuacion el error expecificado: ");
            e.printStackTrace();

        }
    }

    private static void Consulta(Scanner sc, String ruta) {
        System.out.println("> Introduce el numero del id a consultar");
        int x = sc.nextInt();
        try (RandomAccessFile rf = new RandomAccessFile(ruta, "r")){
        int poscion = 0;
        String nombre = "";
        for (int i = 0; i < 10; i++) {
			nombre += rf.readChar();
		}
		poscion = ((x - 1) * 32);
		if (poscion >= rf.length()) {
			System.out.println("ID no existe");
		}else {
            System.out.println("> Resultado del numero: " + x);
			rf.seek(poscion);
			System.out.println("> Nombre: " + nombre);
			System.out.println("> Id: " + rf.readInt());
			System.out.println("> Precio: " + rf.readDouble());
			
		}
		
	}catch (FileNotFoundException e) {
		System.out.println("> El sistema no ha encontrado el archivo expecificado.");
		System.out.println("> Error: ");
		e.printStackTrace();
		
	} 
	catch (IOException e) {
		System.out.println("> El sistema no ha encontrado lo expecificado.");
		System.out.println("> Error: ");
		e.printStackTrace();
	}
    sc.close();
    }
}
