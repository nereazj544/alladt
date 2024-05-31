package alladt.Hibernate.Clase_Ejercicos.Versiones;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.DataException;

import ClasesHibernate.Fabricantes;
import ClasesHibernate.HibernateUtil;

public class Ej2_1_args {

	public static void main(String[] args) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();
		Transaction t = s.beginTransaction();
		
		//Parametros recividos por argumentos
		if (args.length != 3) {
			System.out.println("PROPOCIONA TRES ARGUMENTOS: \n"
					+ "Nombre para el Fabricante\n"
					+ "Pais\n"
					+ "Codigo (FAB+nº)");
		}
		
		String n = args[0];
		String p = args[1];
		String c = args[2];
		
		Fabricantes f = new Fabricantes();
		
		System.out.println("Nombre: ");
		f.setNombre(n);
		System.out.println("Pais: ");
		f.setPais(p);
		System.out.println("Codigo: ");
		f.setCodFab(c);
		
		try {
			s.save(f);
			t.commit();
			System.out.println("AÑADIDO CORRECTAMENTE Y SESION FINALIZADA");
			
			
		} catch (DataException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		

	}

}
