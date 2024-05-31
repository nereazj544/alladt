package Versiones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import ClasesHibernate.Fabricantes;
import ClasesHibernate.HibernateUtil;

//TODO: NO CARRURA  Seguir mirando a ver que pasa :)
public class Ej2_2_File_NOCARRULA {
	public static void main(String[] args) throws IOException {
		SessionFactory sFactory = HibernateUtil.getSessionFactory();
		Session s = sFactory.openSession();
		Transaction t = s.beginTransaction();

		System.out.println("Introducce una ruta al archivo a leer");
		Scanner sc = new Scanner(System.in);

		// ! Alternativa del Scanner
		// String r = "[METE LA RUTA AQUI]";

		String ruta = sc.nextLine();
		File file = new File(ruta);

		Fabricantes f = new Fabricantes();

		try {
			BufferedReader br = new BufferedReader(new FileReader(file));

			String n = br.readLine();
			String p = br.readLine();
			String c = br.readLine();

			f.setCodFab(c);
			f.setNombre(n);
			f.setPais(p);

			s.save(f);
			t.commit();
			br.close();
			System.out.println("DATOS GUARDADOS");

		} catch (FileNotFoundException e) {
			System.out.println("NO SE ENCUENTRA EL ARCHIVO");
		}

	}
}
