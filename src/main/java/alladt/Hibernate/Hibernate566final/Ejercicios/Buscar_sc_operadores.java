package alladt.Hibernate.Hibernate566final.Ejercicios;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import alladt.Hibernate.Hibernate566final.Conf.*;

public class Buscar_sc_operadores {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("> El sistema te pide que escribas el nombre del personaje: ");
		String n = sc.nextLine().toLowerCase(); //Nombre
		System.out.println("> El sistema te pide que escribas el operador logico ('OR' o 'AND'): ");
		String o = sc.nextLine().toUpperCase(); //Operador (se convierte en mayusculas)
		
		if (!o.equalsIgnoreCase("AND") && !o.equalsIgnoreCase("OR")) {
			System.out.println("> El sistema detecto que no se ha introducido un operador logico valido.");
			System.exit(0);
		}
		
		System.out.println("> El sistema te pide que escribas el nombre del juego ('Genshin Impact', 'Wuthering Waves', 'Honkai Star Rail' o 'Inazuma Eleven'): ");
		String j = sc.nextLine().toLowerCase();
		
		
		if (!j.equalsIgnoreCase("Wuthering Waves") && !j.equalsIgnoreCase("Genshin Impact")  && !j.equalsIgnoreCase("Honkai Star Rail") && !j.equalsIgnoreCase("Inazuma Eleven") ) {
			System.out.println("> El sistema detecto que no se ha introducido un nombre de juego valido.");
			System.exit(0);
			
		}
		
		System.out.println("> El sistema se encuentra analizado lo introducido: \n> Nombre: <<" + n + ">>, Operador Logico: " + o + " y el nombre del juego: <<" + j + ">>");
		

		String q = "FROM Personajes where nombre LIKE '" + n + "' " + o + " juego like '" + j + "'";
		List<Personajes> p = s.createQuery(q).list();
		
//		Query<Personajes> query = s.createQuery(q);
//		query.setParameter("nombre", n);
//		query.setParameter("juego", j);
//		
//		List<Personajes> p = query.list();
		
		
		System.out.println("> El sistema ha encontrado resultados: ");
		System.out.println("======================");
		System.out.println("> DATOS DEL PERSONAJE:  " + n);
		for (Personajes personajes : p) {
			System.out.println("> ID del personaje: " + personajes.getId());
			System.out.println("> Nombre del personaje: " + personajes.getNombre());
			System.out.println("> Juego asociado: " + personajes.getJuego());
		}
		System.out.println("======================");
		
		System.out.println("> DATOS DEL JUEGO:  " + j);
		for (Personajes personajes : p) {
			System.out.println("> ID del juego: " + personajes.getId());
			System.out.println("> Nombre del juego: " + personajes.getJuego());
			System.out.println("> Personajes asociados al juego del personaje: " + personajes.getNombre());
		}

        
	}
}
