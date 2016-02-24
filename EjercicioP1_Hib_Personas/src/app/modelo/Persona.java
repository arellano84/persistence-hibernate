package app.modelo;

import java.io.Serializable;

public class Persona implements Serializable{
	
	private Long codigo;
	private String nombre;
	private String dni;
	
	public Persona() {
	}
	
	public Persona(Long codigo, String nombre, String dni) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.dni = dni;
	}
	
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@Override
	public String toString() {
		return "Persona [codigo=" + codigo + ", nombre=" + nombre + ", dni="
				+ dni + "]";
	}
	
}
