package cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.modelo.Camion;
import app.modelo.Coche;
import app.utilidades.MiInterceptor;

public class Main {

    public static void main(String[] args) {
    	Configuration configuration = new Configuration().configure();
    	configuration.setInterceptor(new MiInterceptor());
		StandardServiceRegistryBuilder builder = 
	                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		Session session = sf.openSession();
        Transaction tx = session.getTransaction();
        
        // Crear objetos => NEW
        Coche co1 = new Coche("FORD MONDEO", 205F, 130, 4, 4.20F);
        Coche co2 = new Coche("SEAT LEON", 220.0F, 150, 5, 4.0F);
        Coche co3 = new Coche("MERCEDES CLK", 247F, 280, 3, 4.0F);
        Camion ca1 = new Camion("IBECO 300", 150F, 300, 3000, 14000);
        Camion ca2 = new Camion("RENAULT F2000", 140F, 250, 4000, 9000);


        try{
            tx.begin();
            session.save(co1);
            session.save(co2);
            session.save(co3);
            session.save(ca1);
            session.save(ca2);
            tx.commit();

        }catch(Exception ex){
            tx.rollback();
            ex.printStackTrace();
        }finally{
        	session.close();
            sf.close();
        }
    }

}
