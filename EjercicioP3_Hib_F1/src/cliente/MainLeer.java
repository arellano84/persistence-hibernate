package cliente;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.modelo.Escuderia;
import app.modelo.Piloto;
import app.modelo.Telefono;
import app.modelo.Temporada;

public class MainLeer {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure("leerhibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = 
	                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		
		Session session = sf.openSession();
        Transaction tx = session.getTransaction();
        
        try{
        	System.out.println("1=============================================");
        // 1.- Mostrar los pilotos que pertenecen a una determinada temporada
            Query q1 = session.createQuery("select t from Temporada t "
                    + " where t.inicio = :inicio AND t.fin = :fin");
            q1.setParameter("inicio", 2010);
            q1.setParameter("fin", 2011);

            Temporada temporada = (Temporada) q1.uniqueResult();
            for (Piloto p : temporada.getPilotos()) {
                System.out.println(p);
            }
            System.out.println("2=============================================");
        // 2.- Mostrar los pilotos de una escuderia
            Query q2 = session.createQuery("select e from Escuderia e "
                    + " where e.nombre = :nombre");
            q2.setParameter("nombre", "Renault");

            Escuderia escuderia = (Escuderia) q2.uniqueResult();
            for (Piloto p : escuderia.getPilotos()) {
                System.out.println(p);
            }
            System.out.println("3=============================================");
        // 3.- Mostrar los pilotos con un sueldo superior a una cifra
            Query q3 = session.createQuery("select p from Piloto p "
                    + " where p.facturacion.sueldo > :sueldo");
            q3.setParameter("sueldo", 5000000);

            List<Piloto> pilotos = q3.list();
            for (Piloto p : pilotos) {
                System.out.println(p);
            }
            System.out.println("4=============================================");
        // 4.- Mostrar los pilotos que cobren por publicidad entre 2 valores
            Query q4 = session.createQuery("select p from Piloto p "
                    + " where p.facturacion.publicidad BETWEEN :menor AND :mayor");
            q4.setParameter("menor", 2000000);
            q4.setParameter("mayor", 4000000);

            List<Piloto> pilotos4 = q4.list();
            for (Piloto p : pilotos4) {
                System.out.println(p);
            }
            System.out.println("5=============================================");
        // 5.- Mostrar los pilotos que no sean de la escuderia italiana
            Query q5 = session.createQuery("select p from Piloto p "
                    + " where p.escuderia.pais NOT IN (:pais)");
            q5.setParameter("pais", "Italia");

            List<Piloto> pilotos5 = q5.list();
            for (Piloto p : pilotos5) {
                System.out.println(p);
            }
            System.out.println("6=============================================");
        // 6.- Mostrar todos los telefonos de Alonso
            Query q6 = session.createQuery("select t from Telefono t "
                    + " where t.piloto.nombre = :nombre");
            q6.setParameter("nombre", "Alonso");
            List<Telefono> telefonos = q6.list();
            for (Telefono t : telefonos) {
                System.out.println(t);
            }
            System.out.println("=============================================");
            
        }catch(Exception e){
        	tx.rollback();
        	e.printStackTrace();
        }finally{
        	session.close();
        	sf.close();
        }
        
	}

}
