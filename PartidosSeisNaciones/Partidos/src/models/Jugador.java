package models;

import java.time.LocalDate;

public class Jugador extends Persona {

	private Equipo equipo;

	private int velocidad;

	private int fuerza;

	private int resistencia;
	
	private int mediaPuntos;

	public Jugador(String nombreCompleto, LocalDate randomBirthDate, int peso, int velocidad, int fuerza, int resistencia) {
		super(nombreCompleto, randomBirthDate, peso);
		this.velocidad = velocidad;
		this.fuerza = fuerza;
		this.resistencia = resistencia;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getFuerza() {
		return fuerza;
	}

	public void setFuerza(int fuerza) {
		this.fuerza = fuerza;
	}

	public int getResistencia() {
		return resistencia;
	}

	public void setResistencia(int resistencia) {
		this.resistencia = resistencia;
	}
	
	public int getMediaPuntos() {
		this.mediaPuntos = this.velocidad+this.fuerza+this.resistencia;
		
		return mediaPuntos;
	}
	

	@Override
	public String toString() {
		return super.toString() + " Jugador [equipo=" + equipo.getNombreNacion() + ", velocidad=" + velocidad + ", fuerza=" + fuerza
				+ ", resistencia=" + resistencia + "]    " + mediaPuntos;
	}

}