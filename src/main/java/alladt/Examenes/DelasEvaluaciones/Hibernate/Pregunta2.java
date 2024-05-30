package alladt.Examenes.DelasEvaluaciones.Hibernate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;

import alladt.Examenes.DelasEvaluaciones.Hibernate.*;

public class Pregunta2 {
	public static void main(String[] args) throws IOException {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction t = session.beginTransaction();
		//crear session factory y abrir transaccion
		
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); //leer datos que introduzca el usuario
		Equipos equipo = new Equipos();
		
		//meter datos para crear el equipo
		System.out.println("Introduce el nombre del equipo");
		equipo.setNombre(bf.readLine());
		if (equipo.getNombre().isBlank()) { //no se puede meter un equipo de nombre vacio de esta manera
			System.out.println("Se ha introducido un nombre de equipo vacío.");
			System.exit(0);
		}
		System.out.println("Introduce la ciudad del equipo");
		equipo.setCiudad(bf.readLine());
		System.out.println("Introduce la conferencia del equipo");
		equipo.setConferencia(bf.readLine());
		System.out.println("Introduce la división del equipo");
		equipo.setDivision(bf.readLine());
		
		try { //se intenta guardar el equipo, si salta alguna exception se imprime
			session.save(equipo); 
			t.commit();
			System.out.println("Se ha guardado el equipo.");
		} catch (DataException de) {
			System.out.println("El formato de los datos introducidos es incorrecto");
		} catch (ConstraintViolationException cve) {
			System.out.println("Se ha introducido un equipo ya existente");
		}
		//Se cierra la sesión
		session.close();
	}
}
