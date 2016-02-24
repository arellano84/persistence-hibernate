package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Escuderia implements Serializable{
	
	private Long id;
	private String nombre;
	private String pais;
	private Set<Piloto> pilotos = new HashSet<Piloto>();
	
	public Escuderia() {
	}
	
	public Escuderia(String nombre, String pais) {
		this.nombre = nombre;
		this.pais = pais;
	}
	
	public void addPiloto(Piloto p){
		pilotos.add(p);
		p.setEscuderia(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<Piloto> getPilotos() {
		return pilotos;
	}

	public void setPilotos(Set<Piloto> pilotos) {
		this.pilotos = pilotos;
	}
	
	@Override
	public String toString() {
        return "Escuderia{" + " nombre= " + nombre + " pais= " + pais + '}';
    }



}
