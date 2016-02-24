package app.modelo;

import java.io.Serializable;

public class Coche extends Vehiculo implements Serializable {
	
    private static final long serialVersionUID = 1L;
	private int puertas;
	private float longitud;

    public Coche() {
    }
	public Coche(String modelo, float velocidad, int potencia, int puertas, float longitud) {
		super(modelo, velocidad, potencia);
		this.puertas=puertas;
		this.longitud=longitud;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}
	
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coche other = (Coche) obj;
        if (this.puertas != other.puertas) {
            return false;
        }
        if (Float.floatToIntBits(this.longitud) != Float.floatToIntBits(other.longitud)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.puertas;
        hash = 13 * hash + Float.floatToIntBits(this.longitud);
        return hash;
    }

    @Override
    public String toString() {
        return "Coche{" + "puertas=" + puertas + "longitud=" + longitud + '}';
    }
    
}
