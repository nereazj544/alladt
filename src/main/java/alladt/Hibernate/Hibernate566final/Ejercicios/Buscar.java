package alladt.Hibernate.Hibernate566final.Ejercicios;

import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.mysql.cj.Query;

import alladt.Hibernate.Hibernate566final.Conf.*;

public class Buscar {

    public static void main(String[] args) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session s = sf.openSession();

        if (args.length != 1) {
            System.out.println("> El sistema detecto que no se ha introducido un nombre.");
            System.exit(0);
        }

        String nombre = args[0];

        String q = "FROM Personajes where nombre like '" + nombre + "'";
        List<Personajes> p = s.createQuery(q).list();

        System.out.println(
                "> El sistema esta comprobando el(los) personaje(s) registrado(s) con el nombre de: '" + nombre + "'.");

        if (p.isEmpty()) {
            System.out.println("> El sistema ha detectado que no hay ningun personaje con ese nombre.");
        } else {
            for (Personajes personajes : p) {
                System.out.println("> El sistema ha encontrado el nombre: '" + nombre + "', mostando resultados: ");
                System.out.println("> Id: " + personajes.getId());
                System.out.println("> Nombre: " + personajes.getNombre());
                System.out.println("> Juego: " + personajes.getJuego());
                Empresa e = personajes.getEmpresa();
                System.out.println("> Datos de la empresa");
                if (e != null) {
                    System.out.println("> Nombre de la empresa: " + e.getNombre());
                    System.out.println("> ID de la empresa: " + e.getId());
                } else {
                    System.out.println("> El sistema ha detectado ninguna empresa asociada a ese personaje.");
                }
            }

            s.close();
            System.out.println("> El sistema ha finalizado la sesion");
        }

    }

}
