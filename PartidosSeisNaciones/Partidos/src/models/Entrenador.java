package models;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Entrenador extends Persona {
	
	private int experiencia;
	private Equipo equipo;
	private ArrayList<Equipo> alineacion=new ArrayList <Equipo>();
	private int mediaPuntos;

	public Entrenador(String nombreCompleto, Date fechaNacimiento, int peso, int experiencia) {
		super(nombreCompleto, fechaNacimiento, peso);
		this.experiencia = experiencia;
	}
	
	public int getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(int experiencia) {
		this.experiencia = experiencia;
	}

	public Equipo getEquipo() {
		return equipo;
	}

	public void setEquipo(Equipo equipo) {
		this.equipo = equipo;
	}

	@Override
	public String toString() {
		return super.toString() + "Entrenador [experiencia=" + experiencia + ", equipo=" + equipo.getNombreNacion() + "]";
	}
	
	// Creamos la alineación de los 15 mejores de cada equipo
	
	public List<Jugador> crearAlineacion(List<Jugador> plantillaJugadores) {
		
		List<Jugador> plantillaOrdenadaPorMedia = plantillaJugadores.stream()
				.sorted(Comparator.comparingInt(Jugador::getMediaPuntos).reversed())
				.collect(Collectors.toList());
		
		List<Jugador> alineacion = new ArrayList<Jugador>();
		
		for (int i = 0; i<15; i++) {
			alineacion.add(plantillaOrdenadaPorMedia.get(i));
		}
		
		return alineacion;
	}

}
