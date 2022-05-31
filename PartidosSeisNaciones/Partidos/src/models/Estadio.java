package models;

public class Estadio {

	private Partido[] registroPartidos;
	
	private int capacidad;
	
	private String nombre;

	public Estadio(int capacidad, String nombre) {
		this.capacidad = capacidad;
		this.nombre = nombre;
	}

	public Partido[] getRegistroPartidos() {
		return registroPartidos;
	}

	public void setRegistroPartidos(Partido[] registroPartidos) {
		this.registroPartidos = registroPartidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
      
	
}
