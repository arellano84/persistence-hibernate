package app.modelo;

import java.io.Serializable;

public class Camion extends Vehiculo implements Serializable {

    private static final long serialVersionUID = 1L;
	private int tara;
	private int pma;
    public Camion() {
    }
	public Camion(String modelo, float velocidad, int potencia, int tara, int pma) {
		super(modelo, velocidad, potencia);
		this.tara=tara;
		this.pma=pma;
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	public int getPma() {
		return pma;
	}

	public void setPma(int pma) {
		this.pma = pma;
	}
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Camion other = (Camion) obj;
        if (this.tara != other.tara) {
            return false;
        }
        if (this.pma != other.pma) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.tara;
        hash = 97 * hash + this.pma;
        return hash;
    }
    

    @Override
    public String toString() {
        return "Camion{" + "tara=" + tara + "pma=" + pma + '}';
    }
    
}
