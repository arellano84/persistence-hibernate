package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Temporada implements Serializable{

	private Long id;
	private int inicio;
	private int fin;
	private Set<Piloto> pilotos = new HashSet<Piloto>();
	
	public Temporada() {
	}
	
	public Temporada(int inicio, int fin) {
		this.inicio = inicio;
		this.fin = fin;
	}
	
	public void addPiloto(Piloto p){
		pilotos.add(p);
		p.getTemporadas().add(this);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getInicio() {
		return inicio;
	}

	public void setInicio(int inicio) {
		this.inicio = inicio;
	}

	public int getFin() {
		return fin;
	}

	public void setFin(int fin) {
		this.fin = fin;
	}

	public Set<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(Set<Piloto> pilotos) {
		this.pilotos = pilotos;
	}

	@Override
	public String toString() {
        return "Temporada{" + " inicio= " + inicio + " fin= " + fin + '}';
	}
	
	

}
