package alladt.Hibernate.Clase_Ejercicos;

import java.util.List;
import java.util.Set;

import org.hibernate.*;

import ClasesHibernate.*;


public class Ej3 {
	public static void main(String[] args) {
		// Sesion con Hibernate
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();

		// Comprobacion de los argumentos
		if (args.length != 3) {
			System.out.println("PROPOCIONA TRES ARGUMENTOS: \n" + 
			"Nombre de la version\n" + "OPERADOR\n" + "Version");
			System.exit(0);
		}

		// Almacenamos los argumentos

		String n = args[0].toLowerCase(); // Nombre
		String o = args[1].toLowerCase(); // Operador
		String v = args[2].toLowerCase(); // Version

		// Si no has introducido bien los operadores
		if (!o.equalsIgnoreCase("AND") && !o.equalsIgnoreCase("OR")) {
			System.out.println("No has introducido un AND o un OR");
			System.exit(0);
		}

		String q = "From Programas where nombre like '" + n + "' " + o + " ver like '" + v + "'";

		
		List<Programas> p = s.createQuery(q).list();

		if (p.isEmpty()) {
			System.out.println("NO HAY DATOS CON LO QUE HAS BUSCADO: \n" + 
			"Lo que has buscado.\nNombre: " + n +" y Version: " + v);
			System.exit(0);
		}

		System.out.println("RESULTADO: Con los parametros que has añadido. Nombre ->" + n + "\n Version -> " + v);
		for (Programas programas : p) {
			System.out.println("CODIGO: " + programas.getCodPro() + "\nNombre: " + programas.getNombre() + "\nVersion: " + programas.getVer());
			
			//! Metodo para invocar a los Fabricantes:
			Set<Fabricantes> f = programas.getFabricanteses();
			for (Fabricantes fabricantes : f) {
				System.out.println("Fabricantes: " + fabricantes.getNombre());
			}
		}
		
		s.close();
		System.out.println("SESION CERRADA");
		
	}



}
