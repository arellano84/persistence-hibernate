package cliente;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.modelo.Libro;

public class MainLeer {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure("leerhibernate.cfg.xml");
		StandardServiceRegistryBuilder builder = 
	                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		
		Session session = sf.openSession();
        Transaction tx = session.getTransaction();
        
        try{
        	System.out.println("HQL Consulta todos los libros---------------------------------");
    		List<Libro> list = session.createQuery("from Libro l order by l.libropk.titulo asc").list();
            for(Libro p : list)
            	System.out.println(p);
        	
        	System.out.println("HQL consultando un libro---------------------------------");
            Query query2 = session.createQuery("select l from Libro l where l.libropk.titulo = :titulo ");
            query2.setParameter("titulo", "Azteca");
            List<Libro> list2 = query2.list();
            for(Libro p2 : list2)
            	System.out.println(p2);
            
            System.out.println("HQL Eliminando un libro---------------------------------");
        	Query query5 = session.createQuery("delete Libro l where l.libropk.titulo in (:titulo)");
    		query5.setParameter("titulo", "Spring");
    		session.getTransaction().begin();
    		query5.executeUpdate();
            session.getTransaction().commit();
    		
            System.out.println("HQL Update un libro---------------------------------");
        	Query query3 = session.createQuery("update Libro l set l.resumen = :resumen where l.libropk.titulo = :titulo");
    		query3.setParameter("resumen", "La historia es en America Prehispanica..xxx.");
    		query3.setParameter("titulo", "Azteca");
    		session.getTransaction().begin();
    		query3.executeUpdate();
            session.getTransaction().commit();
            
        }catch(Exception e){
        	tx.rollback();
        	e.printStackTrace();
        }finally{
        	session.close();
        	sf.close();
        }
        
	}

}
