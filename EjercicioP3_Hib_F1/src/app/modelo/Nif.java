package app.modelo;

import java.io.Serializable;

public class Nif implements Serializable{

	private Long id;
	private char letra;
	private long numero;
	Piloto p;
	
	public Nif() {
	}
	
	public Nif(char letra, long numero) {
		this.letra = letra;
		this.numero = numero;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public char getLetra() {
		return letra;
	}

	public void setLetra(char letra) {
		this.letra = letra;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}
	

    public Piloto getP() {
        return p;
    }

    public void setP(Piloto p) {
        this.p = p;
    }


	@Override
	public String toString() {
        return "Nif{" + " letra= " + letra + " numero= " + numero + '}';
	}
	
	
}
