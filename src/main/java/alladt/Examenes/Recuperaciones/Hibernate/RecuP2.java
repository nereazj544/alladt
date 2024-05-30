package alladt.Examenes.Recuperaciones.Hibernate;


import java.util.Scanner;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.exception.DataException;
import RecuP1.Fabricantes;
import RecuP1.HibernateUtil;
import jakarta.transaction.Transaction;

//RECORDATORIO: USAR LA CLASE FABRICANTE
public class RecuP2 {
public static void main(String[] args) throws Exception {
	//Abrir sesion
	SessionFactory sessionF = HibernateUtil.getSessionFactory();
	Session session = sessionF.openSession();
	Transaction t = (Transaction) session.beginTransaction();
	
	//Introducir los datos del Fabricante
	Scanner sc = new Scanner(System.in);
	Fabricantes fabricantes = new Fabricantes();
	
	System.out.println("Introduce el nombre del fabricante");
	fabricantes.setNombre(sc.nextLine());
	if (fabricantes.getNombre().isBlank()) {
		System.out.println("Se ha introducido el nombre");
		System.exit(0);
	}
	System.out.println("Introduce el pais del fabricante");
	fabricantes.setPais(sc.nextLine());
	System.out.println("introduce el codigo del fabricante");
	fabricantes.setCodFab(sc.nextLine());
	
	try {
		session.save(fabricantes);
		t.commit();
		System.out.println("Todo Ok");
	} catch (DataException e) {
		System.err.println("Errore en el formato de los datos que se ha introduccido");
	} catch (ConstraintViolationException f) {
		System.err.println("Se ha introducido un fabricante ya esta registrado");
	}
	
	session.close();
	
	//Cerrar la sesion
	
	
}
}
