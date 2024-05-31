package alladt.Hibernate.Clase_Ejercicos;

import java.util.Set;

import org.hibernate.*;

import ClasesHibernate.*;

public class Ej4 {
public static void main(String[] args) {
	// Sesion con Hibernate
			SessionFactory sFactory = HibernateUtil.getSessionFactory();
			Session s = sFactory.openSession();
	        Transaction t = s.beginTransaction();

	        
	        if (args.length != 1) {
	            System.out.println("No has introduccido un codigo del fabricante");
	        }


	        String cod = args[0].toUpperCase(); //codigo

	        try {
	            // Fabricantes f = new Fabricantes();
	            Fabricantes f = s.get(Fabricantes.class, cod);
	            if (f == null) {
	                System.out.println("No se encontro ningun fabricante con el codigo: " + cod);
	            }else{
	                System.out.println("DATOS DEL FABRICANTE CON EL COD: " + cod);
	                System.out.println("Codigo: " + f.getCodFab());
	                System.out.println("Nombre: " + f.getNombre());
	                System.out.println("Pais: " + f.getPais());
	            }

	           Set<Programas> p = f.getProgramases();
	           if (p.isEmpty()) {
	            System.out.println("PROGRAMA ASOCIADO: ");
	           }else{
	            System.out.println("Programsa del fabricante con el cod: " + cod);
	            for (Programas programas : p) {
	                System.out.println("Codigo " + programas.getCodPro());
	                System.out.println("Nombre " + programas.getNombre());
	                System.out.println("Version " + programas.getVer());
	            }
	           }

	t.commit();


	        } catch (Exception e) {
	            // TODO: handle exception
	        }

	        s.close();

	    }
}

