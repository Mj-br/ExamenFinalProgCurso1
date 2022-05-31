package models;

import java.util.ArrayList;

public class Equipo {

	private Naciones nombreNacion;
	private int partidosGanados;
	private ArrayList<Jugador> plantillaJugadores = new ArrayList<Jugador>();
	private ArrayList<Entrenador> plantillaEntrenadores = new ArrayList<Entrenador>();
	private ArrayList<Jugador> alineacion = new ArrayList<Jugador>();
	private int partidosEmpatados;
	private int partidoPerdidos;
	private int puntosPartido;

	public Equipo(Naciones nombreNacion) {
		this.nombreNacion = nombreNacion;
	}

	public ArrayList<Jugador> getPlantilla() {
		return plantillaJugadores;
	}

	public void a�adirJugador(Jugador jugador) {
		plantillaJugadores.add(jugador);
	}
	
	public void a�adirEntrenador(Entrenador entrenador) {
		plantillaEntrenadores.add(entrenador);
	}

	
	public Naciones getNombreNacion() {
		return nombreNacion;
	}
	
	public ArrayList<Jugador> getPlantillaJugadores() {
		return plantillaJugadores;
	}

	public ArrayList<Entrenador> getPlantillaEntrenadores() {
		return plantillaEntrenadores;
	}

	@Override
	public String toString() {
		return "\n\tEquipo [nombreNacion=" + nombreNacion + ", partidosGanados=" + partidosGanados + ", plantillaJugadores="
				+ plantillaJugadores + " plantillaEntrenadores=" + plantillaEntrenadores + ", alineacion=" + alineacion
				+ ", partidosEmpatados=" + partidosEmpatados + ", partidoPerdidos=" + partidoPerdidos
				+ ", puntosPartido=" + puntosPartido + "]";
	}

}