package models;

import java.time.LocalDate;
import java.util.HashMap;

public class Arbitro extends Persona {
	
	private int precision;
	
	private HashMap <Partido, String> actas;
 	

	public Arbitro(String nombreCompleto, LocalDate fechaNacimiento, int peso, int precision) {
		super(nombreCompleto, fechaNacimiento, peso);
		this.precision=precision;
		 actas = new HashMap <Partido, String>();
	}
	

	public int getPrecision() {
		return precision;
	}

	public void setPrecision(int precision) {
		this.precision = precision;
	}

	public void empezarPartido(Partido partido) {
		System.out.println("El arbitro empieza el partido");
	}
	
	public void finalizarPartido(Partido partido) {
		
		System.out.println("El arbitro finaliza el partido, gracias por jugar\n");
	}
	
	// El método de escribir el acta
	
	public void escribirActa(Partido partido) {
           /*	HashMap<Partido, String> copia = new HashMap <>(actas);
           	Set<Partido>setPartidos = Partido.keySet();
           	Partido partidoMax = null;
           	String act ="/nHISTORIAL DE ACTAS";
           	act += "\n acta: V - D - E" + jugar();
           	
           	if (copia.containsValue(0)) {
           		System.out.println("El primer arbitro escribe las actas");
           	}
           	*/
                
        actas.put(partido, partido.toString() );
        
    }

	@Override
	public String toString() {
		return super.toString() + "\nArbitro [precision=" + precision + "]";
	}


	
	
}