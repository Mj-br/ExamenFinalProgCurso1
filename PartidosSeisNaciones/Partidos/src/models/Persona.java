package models;

import java.sql.Date;

public abstract class Persona {
	
	private String nombreCompleto;
	private Date fechaNacimiento;
	private int peso;		

	public Persona(String nombreCompleto, Date fechaNacimiento, int peso) {
		this.nombreCompleto = nombreCompleto;
		this.fechaNacimiento = fechaNacimiento;
		this.peso = peso;
	}
	
	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
	
	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

	@Override
	public String toString() {
		return "\n\tPersona [nombreCompleto=" + nombreCompleto + ", fechaNacimiento=" + fechaNacimiento + ", peso=" + peso
				+ "]";
	}
}
