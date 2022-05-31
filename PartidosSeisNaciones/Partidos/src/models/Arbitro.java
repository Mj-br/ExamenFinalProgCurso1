package models;

import java.sql.Date;

public class Arbitro extends Persona {
	
	private int precision;

	public Arbitro(String nombreCompleto, Date fechaNacimiento, int peso, int precision) {
		super(nombreCompleto, fechaNacimiento, peso);
		this.precision=precision;
	}

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}
	public void empezarPartido() {}
	
	public void finalizarrPartido() {}

	@Override
	public String toString() {
		return super.toString() + "\nArbitro [precision=" + precision + "]";
	}
	
	
}
