package app.modelo;

import java.io.Serializable;
public class Vehiculo implements Serializable {

    private Long id;
    private String modelo;
    private float velocidad;
    private int potencia;

    public Vehiculo() {
    }

	public Vehiculo(String modelo, float velocidad, int potencia) {
		this.modelo = modelo;
		this.velocidad = velocidad;
		this.potencia = potencia;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public float getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(float velocidad) {
		this.velocidad = velocidad;
	}

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}

	@Override
	public String toString() {
		return "Vehiculo [modelo=" + modelo + ", velocidad=" + velocidad
				+ ", potencia=" + potencia + "]";
	}
    
}
