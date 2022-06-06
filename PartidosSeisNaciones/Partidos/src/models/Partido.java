package models;

import java.util.Date;
import java.util.ArrayList;

public class Partido {
	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Date fecha;
	private Estadio estadio;
	
	private ArrayList<Arbitro> arbitros = new ArrayList <>();
    private ArrayList<Entrenador> entrenadores = new ArrayList <>();
	
   
    public Partido() {
        equipoLocal = null;
        equipoVisitante = null;
        fecha = new Date();
        estadio = null;
    }
    
    
    
    public Partido(Equipo equipoLocal, Equipo equipoVisitante, Date fecha, ArrayList <Arbitro> arbitros) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.arbitros= arbitros;
	}



	public Equipo getEquipoLocal() {
		return equipoLocal;
	}



	public void setEquipoLocal(Equipo equipoLocal) {
		this.equipoLocal = equipoLocal;
	}



	public Equipo getEquipoVisitante() {
		return equipoVisitante;
	}



	public void setEquipoVisitante(Equipo equipoVisitante) {
		this.equipoVisitante = equipoVisitante;
	}



	public Date getFechaPartido() {
		return fecha;
	}



	public void setFechaPartido(Date fecha) {
		this.fecha = fecha;
	}



	public Estadio getEstadio() {
		return estadio;
	}



	public void setEstadio(Estadio estadio) {
		this.estadio = estadio;
	}



	public ArrayList<Arbitro> getArbitros() {
		return arbitros;
	}



	public void setArbitros(ArrayList<Arbitro> arbitros) {
		this.arbitros = arbitros;
	}



	public ArrayList<Entrenador> getEntrenadores() {
		return entrenadores;
	}



	public void setEntrenadores(ArrayList<Entrenador> entrenadores) {
		this.entrenadores = entrenadores;
	}
	
	// El calculo del partido
	
	public Equipo calculaVencedor() {
        if (equipoLocal.dameMedia() > equipoVisitante.dameMedia()) {
            return equipoLocal;
        } else if (equipoLocal.dameMedia() < equipoVisitante.dameMedia()) {
            return equipoVisitante;
        } else {
            return null;
        }
    }
	
	// El metodo de empezar el partido
	
	 public void jugar(Estadio estadio) {
	        
		 	estadio.setPartido(this);
	        
		 	this.setEstadio(estadio);
	        
	        Equipo equipoVencedor = this.calculaVencedor();
	         System.out.println("\n" + this.toString());
	        if (equipoVencedor == this.getEquipoLocal()) {
	        	
	        	this.getEquipoVisitante().addPerdido();
	            this.getEquipoLocal().addGanado();
	           
	             System.out.println("Ha ganado " + this.getEquipoLocal());
	        } else if (equipoVencedor == this.getEquipoVisitante()) {
	            
	        	this.getEquipoLocal().addPerdido();
	           
	        	this.getEquipoVisitante().addGanado();
	             System.out.println("Ha ganado " + this.getEquipoVisitante());
	        } else {
	        	
	        	this.getEquipoVisitante().addEmpatado();
	            this.getEquipoLocal().addEmpatado();
	             System.out.println("Empate");
	        }
	        System.out.println("\nEl partido ha finalizado, ya tenemos los resultados." + "\n");
	    }








	 
	 

}