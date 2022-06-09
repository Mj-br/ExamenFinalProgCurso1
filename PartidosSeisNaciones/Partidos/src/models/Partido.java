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
	        
					// System.out.println("\n" + this.toString());
					if (equipoVencedor == this.getEquipoLocal()) {
						
						this.getEquipoLocal().addGanado();
						this.getEquipoVisitante().addPerdido();
						
						golesLocal= randomInt(0,10);
						golesVisitante= randomInt(0,15);
						
						// System.out.println("Ha ganado " + this.getEquipoLocal());
					} else if (equipoVencedor == this.getEquipoVisitante()) {
						
						this.getEquipoVisitante().addGanado();
						
						this.getEquipoLocal().addPerdido();
						
						golesLocal=randomInt(0,20);
						golesVisitante=randomInt(10,40);
						
						// System.out.println("Ha ganado " + this.getEquipoVisitante());
					} else {
						this.getEquipoLocal().addEmpatado();
						this.getEquipoVisitante().addEmpatado();
						int auxGoles = randomInt(0,40);
						
						golesLocal=auxGoles;
						golesVisitante=auxGoles;
						// System.out.println("Empate");
					}
					
					arbitros.get(0).finalizarPartido(this);
					
					arbitros.get(0).escribirActa(this);


	  }
	@Override
	public String toString() {
		return "\n\nPartido [\n\nequipoLocal=" + equipoLocal + ", \n\nequipoVisitante=" + equipoVisitante + ", fecha= " + fecha
				+ "]";
	}








	 
	 

}