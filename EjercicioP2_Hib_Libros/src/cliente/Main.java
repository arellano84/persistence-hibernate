package cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.modelo.Libro;
import app.modelo.LibroPK;

public class Main {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = 
	                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		
		Session session = sf.openSession();
        Transaction tx = session.getTransaction();
        
        Libro libro = new Libro(new LibroPK("Hibernate","Juan"),"Hibernet es","Trata da...");
        Libro libro2 = new Libro(new LibroPK("Spring","Jose"),"Spring es", null);
        
		Libro libro3 = new Libro();
		libro3.setLibropk(new LibroPK("Azteca","Autor 1"));
		libro3.setDescripcion("Novela historica");
		libro3.setResumen("Resumen 1...");
    		
        
        try{
        	tx.begin();
        	
        	session.save(libro);
        	session.save(libro2);
    		session.save(libro3);
    		
        	tx.commit();
        	
        	
//        	System.out.println("Criteria consultando libro---------------------------------");
//        	Criteria consulta = session.createCriteria(Libro.class);
//            List<Libro> todas = consulta.list();
//            for(Libro p : todas)
//                System.out.println(p);
            
        }catch(Exception e){
        	tx.rollback();
        	e.printStackTrace();
        }finally{
        	session.close();
        	sf.close();
        }
	}

}
