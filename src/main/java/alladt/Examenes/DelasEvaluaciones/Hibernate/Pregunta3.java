package alladt.Examenes.DelasEvaluaciones.Hibernate;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import alladt.Examenes.DelasEvaluaciones.Hibernate.*;

public class Pregunta3 {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		//Se introduce un nombre y se añade un "%" para poder llevar a cabo la consulta
		String nombre = ""; 
		if (args.length >= 1) {
			nombre = args[0];
		} else {
			System.out.println("No se ha introducido un nombre");
			System.exit(0);
		}
		nombre += "%";
		
		//Creación y ejecución de la query, recogida de datos
		String qString = "FROM Jugadores jug where jug.nombre like '" + nombre + "'";
		Query q = session.createQuery(qString, Jugadores.class);
		List<Jugadores> jugadores = q.list();
		
		System.out.println("COMPROBANDO JUGADORES...");
		if (jugadores.size() < 1) { //si no hubiese jugadores se imprimiria esto
			System.out.println("NO HAY JUGADORES");
		} else { //si hay, se dan su nombre, equipo y ciudad
			System.out.println("Numero de jugadores que contienen ese nombre: " + jugadores.size());
			jugadores.forEach(j -> {
				System.out.println("-----------------------------------------------------------------------");
				System.out.println("Jugador: " + j.getNombre() + " -- Equipo al que pertenece: " + j.getEquipos().getNombre() + " de " + j.getEquipos().getCiudad()
						);
			});
			System.out.println("-----------------------------------------------------------------------");
		}

		session.close();
	}
}
