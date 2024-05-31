package alladt.Hibernate.Clase_Ejercicos;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

import ClasesHibernate.Fabricantes;
import ClasesHibernate.HibernateUtil;

/*
 * Realiza un programa java que inserta un Fabricante. Se han de controlar de manera correcta las exception que se puedan producir, así como las acciones pertinentes con respecto a las transacciones. La sesión de ha de cerrar sea cual sea la situación
 */

public class Ej2 {

	public static void main(String[] args) {
		// Sesion con Hibernate
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		// Hacemos referecncia a la clase ⤴️ HibernateUtil
		Session s = sFactory.openSession();

		// Esto es para hacer los Commit
		Transaction t = s.beginTransaction();

		// Introduciremos los datos por teclado
		Scanner sc = new Scanner(System.in);

		// Invocamso a la clase donde vamos a añadir las cosas.
		Fabricantes f = new Fabricantes();

		// Mostramos las indicaciones a seguir e vamos introduciendo los datos que se
		// pasan por teclado
		System.out.println("=========================");
		System.out.println("NOMBRE DEL FABRICANTE HA AÑADIR: ");
		f.setNombre(sc.nextLine());
		if (f.getNombre().isBlank()) {
			System.exit(0);
		}
		System.out.println("NOMBRE EL PAIS DEL FABRICANTE HA AÑADIR: ");
		f.setPais(sc.nextLine());
		System.out.println("NOMBRE EL CODIGO DEL FABRICANTE HA AÑADIR: ");
		f.setCodFab(sc.nextLine());
		System.out.println("=========================");

		try {
			// s.save(f);
			s.persist(f);
			// El metodo Save esta obseleto (usando las versiones viejas no sele tachado), se debe de usar persist
			
			t.commit(); //Almacenar en la DB
			
			System.out.println("SESION FINALIZADA");
			System.out.println("=========================");
			System.out.println("\nSE HA AÑADIDO CORRECTAMENTE");
		} catch (DataException e) {
			System.err.println("Error en el formato de los datos que se ha introducido \n");
//			e.printStackTrace();
		} catch (ConstraintViolationException e) {
			System.err.println("FABRICANTE YA REGISTRADO\n");
//			e.printStackTrace();
		}

		// Cerramos la sesion
		s.close();

	}

}
