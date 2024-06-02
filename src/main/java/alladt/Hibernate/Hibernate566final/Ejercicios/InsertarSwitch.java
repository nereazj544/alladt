package alladt.Hibernate.Hibernate566final.Ejercicios;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

import alladt.Hibernate.Hibernate566final.Conf.*;

public class InsertarSwitch {

	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();

		Scanner sc = new Scanner(System.in);
		System.out.println("> El sistema solicita una opcion: 'Empresa' o 'Personaje'");
		String r = sc.nextLine();

		switch (r) {
			case "Empresa":
				Empresa(sc, s, t);
				break;
			case "Personaje":
				Personaje(sc, s, t);
				break;

			default:
				System.out.println("No has introducido 'Empresa' o 'Personaje'");
				break;
		}
		// Main
	}

	private static void Empresa(Scanner sc, Session s, Transaction t) {

		Empresa e = new Empresa();

		System.out.println("> Introduce el nombre de la nueva empresa: ");
		e.setNombre(sc.nextLine());

		if (e.getNombre().isBlank()) {
			System.out.println("Se ha introducido un nombre de personaje vacio");
			System.exit(0);
		}
		try {
			s.save(e);
			t.commit();
			sc.close();
			System.out.println("> Se han guardado los datos añadidos. ");

		} catch (DataException e2) {
			System.out.println("> El sistema no ha encontrado lo expecificado.");
		} catch (ConstraintViolationException e2) {
			System.out.println("> El sistema a detectado que se ha introducido algo ya existente");
		}
	}

	private static void Personaje(Scanner sc, Session s, Transaction t) {
		Personajes p = new Personajes();
		System.out.println("> Introducce un nombre de un personaje");
		p.setNombre(sc.nextLine());
		if (p.getNombre().isBlank()) {
			System.out.println("Se ha introducido un nombre de personaje vacio");
			System.exit(0);
		}

		System.out.println("Introduce el nombre del juego");
		p.setJuego(sc.nextLine());
		System.out.println("> Introduce el numero de la empresa");
		int id_emp = sc.nextInt();

		Empresa e = buscar(id_emp, s);
		// TODO: Esto se usa para buscar el numero de la empresa, es decir, si existe 1
		// o 2
		if (e != null) {
			p.setEmpresa(e);
		} else {
			System.out.println("> Empresa no encontrada");
			System.exit(0);
		}

		try {
			s.save(p);
			t.commit();
			sc.close();
			System.out.println("> Se han guardado los datos añadidos. ");

		} catch (DataException e2) {
			System.out.println("> El sistema no ha encontrado lo expecificado.");
		} catch (ConstraintViolationException e2) {
			System.out.println("> El sistema a detectado que se ha introducido algo ya existente");
		}
	}
	private static Empresa buscar(int id_emp, Session s) {
		return s.get(Empresa.class, id_emp);
	}
}
