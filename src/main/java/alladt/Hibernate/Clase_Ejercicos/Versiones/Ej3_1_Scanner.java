package alladt.Hibernate.Clase_Ejercicos.Versiones;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.DataException;
import org.hibernate.query.Query;

import ClasesHibernate.HibernateUtil;
import ClasesHibernate.Programas;

public class Ej3_1_Scanner {

	public static void main(String[] args) {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Proporciona lo siguiente: Nombre del Programa: ");
		String n = sc.nextLine();
		
		System.out.println("Operador ('AND' o 'OR')");
		String o = sc.nextLine();
		System.out.println("Version del programa");
		String v = sc.nextLine();
		
		if (!o.equalsIgnoreCase("AND") && !o.equalsIgnoreCase("OR")) {
			System.out.println("Tiene que ser: 'and' o 'or'.");
		}
		
		String sql = "From Programas Where nombre like '" + n + "' " + o + " ver like '" + v + "'";
		Query<Programas> p = s.createQuery(sql, Programas.class);
		List<Programas> plist = p.list();
		
System.out.println("MOSTRANDO LOS RESULTADOS DE LA CONSULTA: " + sql);
		
		for (Programas programas : plist) {
			System.out.println("Codigo: " + programas.getCodPro() 
			+ "\nNombre: " + programas.getNombre() + 
			"\nVersion: " + programas.getVer());
		}
		
		try {
			s.close();
			System.out.println("SESION FINALIZADA");
		} catch (DataException e) {
			System.err.println("ERROR EN EL FORMATO DE LOS DATOS INTRODUCIDOS");
		}


	}

}
