package app.utilidades;

import app.modelo.Camion;
import app.modelo.Coche;
import java.io.Serializable;

import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

public class MiInterceptor extends EmptyInterceptor implements Serializable{

	 @Override
    public boolean onSave(Object entity, // entidad a persistir
                          Serializable id, // PK
                          Object[] state, // valores a persistir
                          String[] propertyNames, // nombres de propiedades
                          Type[] types)  { // tipos de las propiedades

        if (entity instanceof Coche)
            System.out.println("REALIZANDO ACTUALIZACIÃ“N EN BBDD DE COCHE");
        else if (entity instanceof Camion)
            System.out.println("REALIZANDO ACTUALIZACIÃ“N EN BBDD DE CAMIÃ“N");
        else
            System.out.println("REALIZANDO ACTUALIZACIÃ“N EN BBDD DE VEHICULO");

        return true;
    }
	 
	 /*• afterTransactionBegin; Se invoca al iniciar la transacción
	 • afterTransactionCompletion; se ejecuta al efectuar el commit o rollback de la
	 transacción.
	 • beforeTransactionCompletion; se invoca antes de efectuar el commit, no el
	 rollback.
	 • onDelete; se invoca antes de eliminar la instancia
	 • onSave; antes de persistir la entidad
	 • onLoad; antes de recuperar la entidad.*/

}
