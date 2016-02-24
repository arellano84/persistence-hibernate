package app.modelo;

import java.io.Serializable;

public class Facturacion implements Serializable{

	private Long id;
	private int sueldo;
	private int publicidad;
	private Piloto piloto;
	
	public Facturacion() {
	}
	
	public Facturacion(int sueldo, int publicidad) {
		this.sueldo = sueldo;
		this.publicidad = publicidad;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getSueldo() {
		return sueldo;
	}

	public void setSueldo(int sueldo) {
		this.sueldo = sueldo;
	}

	public int getPublicidad() {
		return publicidad;
	}

	public void setPublicidad(int publicidad) {
		this.publicidad = publicidad;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
        return "Facturacion{" + " sueldo= " + sueldo + " publicidad= " + publicidad + '}';
    }



}
