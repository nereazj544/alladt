package alladt.Examenes.DelasEvaluaciones.Hibernate;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import alladt.Examenes.DelasEvaluaciones.Hibernate.*;


public class Pregunta4 {
	public static void main(String[] args) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		
		//Se introduce un código, si no fuese valido saltaria exception
		int codigo = 0; 
		if (args.length >= 1) {
			try {
			codigo = Integer.parseInt(args[0]);
			} catch (NumberFormatException nfe) {
				System.out.println("No se ha introducido un código válido");
				System.exit(0);
			}
		} else {
			System.out.println("No se ha introducido un código válido");
			System.exit(0);
		}
		
		//Se recoge el jugador, si no existe se imprime eso, si existe se impimen sus datos
		System.out.println("COMPROBANDO JUGADORES...");
		Jugadores jugador = session.load(Jugadores.class, codigo);
		if (jugador == null)
			System.out.println("NO EXISTE UN JUGADOR CON ESE CODIGO");
		else {
			System.out.println("-------------------------------------");
			System.out.println("Nombre: " + jugador.getNombre());
			System.out.println("Código: " + jugador.getCodigo());
			System.out.println("Equipo: " + jugador.getEquipos().getNombre());
			System.out.println("Procedencia: " + jugador.getProcedencia());
			System.out.println("Altura: " + jugador.getAltura());
			System.out.println("Peso: " + jugador.getPeso());
			System.out.println("Posición: " + jugador.getPosicion());
			System.out.println("-------------------------------------");
			
			//Se imprimen las estadisiticas del jugador
			System.out.println("Estadísticas: ");
			Set<Estadisticas> set = jugador.getEstadisticases();
			if (set.size() == 0) 
				System.out.println("No hay estadísticas de este jugador");
			set.forEach(e -> {
				System.out.println("Temporada: " + e.getId().getTemporada());
				System.out.println("\tPuntos por partido: " + e.getPuntosPorPartido());
				System.out.println("\tAsistencias por partido: " + e.getAsistenciasPorPartido());
				System.out.println("\tTapones por partido: " + e.getTaponesPorPartido());
				System.out.println("\tRebotes por partido: " + e.getTaponesPorPartido());
			});
		}
		
		//Se cierra la sesion
		session.close();
	}
}
