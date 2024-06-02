package alladt.Hibernate.Hibernate566final.Ejercicios;


import java.util.Scanner;

import org.hibernate.*;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

import alladt.Hibernate.Hibernate566final.Conf.*;

public class Insertar {
	public static void main(String[] args) {
		//Se abre la sesion con el hibernate
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session s = sf.openSession();
		Transaction t = s.beginTransaction();
		
		Scanner sc = new Scanner(System.in);
		
		Personajes p = new Personajes();
		System.out.println("> Introducce un nombre de un personaje");
		p.setNombre(sc.nextLine());
		if (p.getNombre().isBlank()) {
			System.out.println("Se ha introducido un nombre de personaje vacio");
			System.exit(0);
		}
		
		System.out.println("Introduel el nombre del juego");
		p.setJuego(sc.nextLine());
		System.out.println("> Introduce el numero de la empresa (1 o 2)");
		int id_emp = sc.nextInt();
		
		Empresa e = buscar(id_emp, s);
		//TODO: Esto se usa para buscar el numero de la empresa, es decir, si existe 1 o 2 
		if (e != null) {
			p.setEmpresa(e);
		}else {
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
		}catch (ConstraintViolationException e2) {
			System.out.println("> El sistema a detectado que se ha introducido algo ya existente");
		}
	}

	private static Empresa buscar(int id_emp, Session s) {
		return s.get(Empresa.class, id_emp);
	}
}
