package models;

import java.util.Date;
import java.util.ArrayList;

public class Partido {
	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Date fecha;
	private Estadio estadio;
	private int golesLocal;
	private int golesVisitante;
	
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



	public int getGolesLocal() {
		return golesLocal;
	}



	public void setGolesLocal(int golesLocal) {
		this.golesLocal = golesLocal;
	}



	public int getGolesVisitante() {
		return golesVisitante;
	}



	public void setGolesVisitante(int golesVisitante) {
		this.golesVisitante = golesVisitante;
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
	
	  private int randomInt(int min, int max) {
	        return (int) Math.floor((Math.random() * (max - min + 1)) + min);
	    }
	
	 
	  public void jugar(Estadio estadio) {
	       
		  	estadio.setPartido(this);
	        
	        Equipo equipoVencedor = this.calculaVencedor();
	        
				
					if (equipoVencedor == this.getEquipoLocal()) {
						
						this.getEquipoLocal().addGanado();
						this.getEquipoVisitante().addPerdido();
						
						golesLocal= randomInt(20,30);
						golesVisitante= randomInt(0,15);
						
						
					} else if (equipoVencedor == this.getEquipoVisitante()) {
						
						this.getEquipoVisitante().addGanado();
						
						this.getEquipoLocal().addPerdido();
						
						golesLocal=randomInt(0,19);
						golesVisitante=randomInt(20,40);
						
					
					} else {
						this.getEquipoLocal().addEmpatado();
						this.getEquipoVisitante().addEmpatado();
						int auxGoles = randomInt(0,40);
						
						golesLocal=auxGoles;
						golesVisitante=auxGoles;
						
					}
					
					arbitros.get(0).finalizarPartido(this);
					
					arbitros.get(0).escribirActa(this);


	  }
	@Override
	public String toString() {
		return "\n\nPartido [\n\nequipoLocal=" + equipoLocal + ", \n\nequipoVisitante=" + equipoVisitante + ", \t\nfecha del partido= " + fecha + "\nGoles Local: " 
				+ golesLocal + "\nGoles Visitante: " + golesVisitante + "\n]";
	}








	 
	 

}