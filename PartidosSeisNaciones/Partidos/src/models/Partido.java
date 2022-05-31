package models;

import java.sql.Date;

public class Partido {
	
	private Equipo equipoLocal;
	private Equipo equipoVisitante;
	private Date fecha;
	private int golesLocal;
	private int golesVisitante;
	private Arbitro arbitro;
	
	public Partido(Equipo equipoLocal, Equipo equipoVisitante, Date fecha, Arbitro arbitro) {
		this.equipoLocal = equipoLocal;
		this.equipoVisitante = equipoVisitante;
		this.fecha = fecha;
		this.arbitro = arbitro;
	}

}
