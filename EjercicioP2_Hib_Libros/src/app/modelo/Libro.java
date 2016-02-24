package app.modelo;

import java.io.Serializable;

public class Libro implements Serializable{

	LibroPK libropk;
	String descripcion;
	String resumen;
	
	public Libro() {
	}

	public Libro(LibroPK libropk, String descripcion, String resumen) {
		this.libropk = libropk;
		this.descripcion = descripcion;
		this.resumen = resumen;
	}

	public LibroPK getLibropk() {
		return libropk;
	}

	public void setLibropk(LibroPK libropk) {
		this.libropk = libropk;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getResumen() {
		return resumen;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}

	@Override
	public String toString() {
		return "Libro [libropk=" + libropk + ", descripcion=" + descripcion
				+ ", resumen=" + resumen + "]";
	}
	
}
