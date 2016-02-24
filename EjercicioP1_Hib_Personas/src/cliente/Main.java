package cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.modelo.Persona;

public class Main {
	
	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
        StandardServiceRegistryBuilder builder = 
                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
        SessionFactory sf = configuration.buildSessionFactory(builder.build());
        
        Session session = sf.openSession();
        Transaction tx = session.getTransaction();
        
        Persona p = new Persona(1L,"Luis","00092V");
        
        try{
        	tx.begin();
        	
        	session.save(p);
        	
        	tx.commit();
        }catch(Exception e){
        	tx.rollback();
        	e.printStackTrace();
        }finally{
        	session.close();
        	sf.close();
        }
	}

}
