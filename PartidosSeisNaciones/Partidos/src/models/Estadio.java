package models;

import java.util.ArrayList;

public class Estadio {

	private ArrayList <Partido> partidos;
	private int capacidad;
	private String nombre;
	
	public Estadio () {
		partidos = new ArrayList<>();
		capacidad = 0;
		nombre = "";
	}

	public Estadio(ArrayList<Partido> partidos, int capacidad, String nombre) {
		this.capacidad = capacidad;
		this.nombre = nombre;
		this.partidos = partidos;
	}

	public ArrayList<Partido> getPartidos() {
		return partidos;
	}

	public void setPartidos(ArrayList<Partido> partidos) {
		this.partidos = partidos;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	// Añade el partido a la lista de la clase Estadio
	
	public void setPartido (Partido partido) {
		partidos.add(partido);
	}

	// To String
	
	@Override
	public String toString() {
		return "Estadio [partidos=" + partidos + ", capacidad=" + capacidad + ", nombre=" + nombre + "]";
	}
	
	
	
      
	
}