package cliente;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import app.modelo.Escuderia;
import app.modelo.Facturacion;
import app.modelo.Nif;
import app.modelo.Piloto;
import app.modelo.Telefono;
import app.modelo.Temporada;

public class Main {

	public static void main(String[] args) {
		
		Configuration configuration = new Configuration().configure();
		StandardServiceRegistryBuilder builder = 
	                new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sf = configuration.buildSessionFactory(builder.build());
		
		Session session = sf.openSession();
        Transaction tx = session.getTransaction();
        
        Escuderia e1 = new Escuderia("Renault", "Francia");
        Escuderia e2 = new Escuderia("Ferrari", "Italia");

        Facturacion f1 = new Facturacion(3600000, 5200000);
        Facturacion f2 = new Facturacion(5600000, 1200000);
        Facturacion f3 = new Facturacion(4600000, 2200000);
        Facturacion f4 = new Facturacion(5600000, 3200000);

        Telefono t1 = new Telefono(656111111L);
        Telefono t2 = new Telefono(656111222L);
        Telefono t3 = new Telefono(656111333L);
        Telefono t4 = new Telefono(656111444L);

        Temporada te1 = new Temporada(2011, 2012);
        Temporada te2 = new Temporada(2010, 2011);
        Temporada te3 = new Temporada(2009, 2010);

        Nif n1 = new Nif('A',1111111);
        Nif n2 = new Nif('B',2222222);
        Nif n3 = new Nif('C',3333333);
        Nif n4 = new Nif('D',4444444);

        Piloto p1 = new Piloto("Alonso", 28, n1);
        Piloto p2 = new Piloto("Massa", 32, n2);
        Piloto p3 = new Piloto("Hamilton", 26, n3);
        Piloto p4 = new Piloto("Schuimacher", 34, n4);

        p1.addTelefono(t1);
        p1.addTelefono(t2);
        p2.addTelefono(t3);
        p3.addTelefono(t4);

        p1.addTemporada(te1);
        p1.addTemporada(te2);
        p1.addTemporada(te3);

        p2.addTemporada(te1);
        p2.addTemporada(te2);
        p2.addTemporada(te3);

        p3.addTemporada(te1);
        p3.addTemporada(te2);

        p4.addTemporada(te2);
        p4.addTemporada(te3);

        p1.addFacturacion(f1);
        p2.addFacturacion(f2);
        p3.addFacturacion(f3);
        p4.addFacturacion(f4);

        e1.addPiloto(p1);
        e1.addPiloto(p2);
        e2.addPiloto(p3);
        e2.addPiloto(p4);

        try{
            tx.begin();

            session.save(p1);
            session.save(p2);
            session.save(p3);
            session.save(p4);

            tx.commit();

            System.out.println(p1);
            System.out.println(p2);
            System.out.println(p3);
            System.out.println(p4);
        }catch(Exception ex){
            tx.rollback();
            ex.printStackTrace();
        }finally{
            session.close();
            sf.close();
        }
	}

}
