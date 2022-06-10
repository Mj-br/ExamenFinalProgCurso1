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
		
		System.out.println("El arbitro finaliza el partido, gracias por jugar\n ");
		
	}
	
	// El método de escribir el acta
	
	public void escribirActa(Partido partido) {
          
                
        actas.put(partido, partido.toString() );
        
    }
	
	

	public HashMap<Partido, String>  getActas() {
		
		return actas;
	}


	@Override
	public String toString() {
		return super.toString() + "\nArbitro [precision=" + precision + "]";
	}


	
	
}