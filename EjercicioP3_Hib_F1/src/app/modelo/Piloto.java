package app.modelo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Piloto implements Serializable{

	private Long id;
	private String nombre;
	private int edad;
	private Facturacion facturacion;
	private Nif nif;
	private Escuderia escuderia;
	private Set<Telefono> telefonos = new HashSet<Telefono>();
	private Set<Temporada> temporadas = new HashSet<Temporada>();
	
	public Piloto() {
	}
	
    public Piloto(String nombre, int edad, Nif nif) {
        this.nombre = nombre;
        this.edad = edad;
        this.nif = nif;
    }
	
	public void addTelefono(Telefono t){
		telefonos.add(t);
		t.setPiloto(this);
	}
	
	public void addTemporada(Temporada t){
		temporadas.add(t);
		t.getPilotos().add(this);
	}
	
	public void addFacturacion(Facturacion f){
        setFacturacion(f);
        f.setPiloto(this);
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

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Facturacion getFacturacion() {
		return facturacion;
	}

	public void setFacturacion(Facturacion facturacion) {
		this.facturacion = facturacion;
	}

	public Nif getNif() {
		return nif;
	}

	public void setNif(Nif nif) {
		this.nif = nif;
	}

	public Escuderia getEscuderia() {
		return escuderia;
	}

	public void setEscuderia(Escuderia escuderia) {
		this.escuderia = escuderia;
	}

	public Set<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(Set<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public Set<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(Set<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	@Override
	public String toString() {
        return "Piloto{" + " id= " + id +
                " nombre= " + nombre +
                " edad= " + edad +
                " facturacion= " + facturacion +
                " nif= " + nif +
                " escuderia= " + escuderia +
                " telefonos= " + telefonos +
                " temporadas= " + temporadas + '}';
	}
	
	
}
