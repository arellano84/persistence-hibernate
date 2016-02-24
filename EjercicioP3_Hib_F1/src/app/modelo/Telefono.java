package app.modelo;

import java.io.Serializable;

public class Telefono implements Serializable{

	private Long id;
	private long numero;
	private Piloto piloto;
	
	public Telefono() {
	}
	
	public Telefono(long numero) {
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public Piloto getPiloto() {
		return piloto;
	}

	public void setPiloto(Piloto piloto) {
		this.piloto = piloto;
	}

	@Override
	public String toString() {
        return "Telefono{" + " numero= " + numero + '}';
	}
	
	

}
