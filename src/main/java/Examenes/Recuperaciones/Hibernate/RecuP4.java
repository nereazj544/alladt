package Examenes.Recuperaciones.Hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import RecuP1.HibernateUtil;

public class RecuP4 {

	public static void main(String[] args) {
		SessionFactory sessionF = HibernateUtil.getSessionFactory();
		Session session = sessionF.openSession();
		
		String cod = "";
		if (args.length >= 1) {
			cod = args[0];
		} else {
			System.err.println("No se ha introducido un codigo valido.");
			System.exit(0);		
		}
		
		cod += "%";
		
		
		
		
		
		
		session.close();
	}

}
