package alladt.Ficheros.TodoFicheros_Clase.Persona;



import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;



public class FichObjeto {
    public static void main(String[] args) throws Exception {
        File fl = new File("D:\\eclipse-workspace\\Ficheros_Nerea\\src\\dirnuevo\\Persona.dat");
       
        FileOutputStream out = new FileOutputStream(fl, true);
        ObjectOutputStream obj = new ObjectOutputStream(out);

        String[] nombre = {
                "Kilari Miracle",
                "Galio (Tablei) Miracle",
                "Alyssa O’Doherty",
                "Brantley (Bran) Slora",
                "Kirian Slora",
                "Bahir Loughty",
                "Coral Loughty",
                "Gemma Berrycloth",
                "Bosco Berrycloth" };

        int[] edad = { 18, 17, 18, 17, 18, 17, 17, 18 };
        for (int i = 0; i < edad.length; i++) {
            Persona p = new Persona(nombre[i], edad[i]);
            obj.writeObject(p);
            System.out.println("> Ok grabado");
        }
        obj.close();
        // out.close();
        System.out.println("Contenido del archivo: ");
        mostrarDatos(fl);

    }

    private static void mostrarDatos(File fl) throws IOException {

        try (FileInputStream in = new FileInputStream(fl);
                ObjectInputStream obj = new ObjectInputStream(in)) {

            ArrayList<Persona> personas = new ArrayList<>();
            while (true) {
                try {
                    Persona p = (Persona) obj.readObject();
                    personas.add(p);
                } catch (EOFException e) {
                	System.out.println("Especificacion del error: ");
                    break; // Fin de archivo
                }
            }

            for (int i = 0; i < personas.size(); i++) {
                Persona p = personas.get(i);
                System.out.println((i + 1) + ") Nombre: " + p.getNombre() + ", Edad: " + p.getEdad());
            }

            System.out.println("FINAL DE LECTURA.");

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
