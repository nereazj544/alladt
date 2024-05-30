package alladt.Examenes.Recuperaciones.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import RecuP1.HibernateUtil;
import RecuP1.Programas;

public class RecuP3 {

	public static void main(String[] args)  {
		SessionFactory sessionF = HibernateUtil.getSessionFactory();
		Session session = sessionF.openSession();

		String name = "";

		if (args.length >= 1) {
			name = args[0];
		} else {
			System.err.println("No se ha introducido un nombre");
			System.exit(0);		
		}
		
		name += "%";
		
		String qString = "FROM programas pro where pro.nombre like '" + name + "'";
		Query q = session.createQuery(qString, Programas.class);
		List<Programas> programas = q.list();
		
		
		System.out.println("Comprbando programas...");
		if (programas.size()<1) {
			System.err.println("No hay programas con dicho nombre"); 
		}else {
			System.out.println("Numero de programas que contienen ese nombre o version: " + programas.size());
			programas.forEach(p -> {
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("Programa: " + p.getNombre() + " Fabricante: " + p.getFabricanteses());
			});
			System.out.println("-----------------------------------------------------------------------");
			
			
		}
		
		session.close();

	}

}
