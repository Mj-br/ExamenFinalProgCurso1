package models;

import java.util.ArrayList;
import java.util.List;

public class Equipo {

	private Naciones nombreNacion;
	private ArrayList<Jugador> plantillaJugadores = new ArrayList<Jugador>();
	private ArrayList<Entrenador> plantillaEntrenadores = new ArrayList<Entrenador>();
	private List<Jugador> alineacion = new ArrayList<Jugador>();
	private int partidosEmpatados;
	private int partidosPerdidos;
	private int partidosGanados;
	private int partidosJugados;
	private int mediaTeam;
	private int puntosTotales;
	
	//Constructores
	
	
	public Equipo(int partidosGanados, int partidosJugados, int partidosPerdidos, int partidosEmpatados,
	            ArrayList<Jugador> jugadores, ArrayList<Entrenador> entrenadores) {
	        this.partidosGanados = partidosGanados;
	        this.partidosJugados = partidosJugados;
	        this.partidosPerdidos = partidosPerdidos;
	        this.partidosEmpatados = partidosEmpatados;
	        this.plantillaJugadores = jugadores;
	        this.plantillaEntrenadores = entrenadores;
    }
	
	public Equipo(Naciones nombreNacion) {
		this.nombreNacion = nombreNacion;
		partidosEmpatados = 0;
		partidosGanados = 0;
		partidosPerdidos = 0;
		partidosJugados = 0;
	}
	
	//Setter y getter de la alineacion
	
	private void calcularPuntos() {
		
		int puntos = 0;
		puntos += this.partidosGanados*3;
		puntos += this.partidosEmpatados;
		puntosTotales = puntos;
		
	}
	
	public int getPuntos () {
		
		calcularPuntos();
		
		return puntosTotales;
	}
	
	public void setAlineacion(List<Jugador> alineacion) {
		this.alineacion = alineacion;
	}

	public List<Jugador> getAlineacion() {
		return alineacion;
	}

	// getter y setters de las variables
	
	public Naciones getNombreNacion() {
		return nombreNacion;
	}
	
	// media para el calculo de los puntos del equipo
	
	 public int dameMedia() {
	        for (int i = 0; i < alineacion.size(); i++) {
	            mediaTeam = alineacion.get(i).getMediaPuntos();
	        }
	        return mediaTeam;
	    }
	 
	public int getPartidosJugados() {
		
		partidosJugados = this.partidosGanados + this.partidosEmpatados + this.partidosPerdidos;
		
		return partidosJugados;
	}


	// añade jugador y entrenador

	public void añadirJugador(Jugador jugador) {
		plantillaJugadores.add(jugador);
	}
	
	public void añadirEntrenador(Entrenador entrenador) {
		plantillaEntrenadores.add(entrenador);
	}
	
	//getter y setters de las plantillas

	public ArrayList<Jugador> getPlantilla() {
		return plantillaJugadores;
	}
	
	public ArrayList<Jugador> getPlantillaJugadores() {
		return plantillaJugadores;
	}

	public ArrayList<Entrenador> getPlantillaEntrenadores() {
		return plantillaEntrenadores;
	}
	
	// Añade el historial del equipo
	
	public void addEmpatado() {
        partidosEmpatados++;
    }

    public void addGanado() {
        partidosGanados++;
    }

    public void addPartido() {
        partidosJugados++;
    }

    public void addPerdido() {
        partidosPerdidos++;
    }
	
    
    
	public int getPartidosEmpatados() {
		return partidosEmpatados;
	}

	public void setPartidosEmpatados(int partidosEmpatados) {
		this.partidosEmpatados = partidosEmpatados;
	}

	public int getPartidosPerdidos() {
		return partidosPerdidos;
	}

	public void setPartidosPerdidos(int partidosPerdidos) {
		this.partidosPerdidos = partidosPerdidos;
	}

	public int getPartidosGanados() {
		return partidosGanados;
	}

	public void setPartidosGanados(int partidosGanados) {
		this.partidosGanados = partidosGanados;
	}

	@Override
	public String toString() {
		return "\nEquipo de: " + nombreNacion + ", Plantilla Total="
				+ plantillaJugadores + "\nEntrenadores=" + plantillaEntrenadores + "\nAlineacion Estrella=" + alineacion
				+ "\nSCORE: partidosEmpatados=" + partidosEmpatados + ", partidosPerdidos=" + partidosPerdidos + ", partidosGanados=" + partidosGanados + "";
	}

}