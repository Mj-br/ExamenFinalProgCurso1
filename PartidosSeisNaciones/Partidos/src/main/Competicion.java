package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;


import models.Arbitro;
import models.Entrenador;
import models.Equipo;
import models.Estadio;
import models.Jugador;
import models.Naciones;
import models.Partido;


public class Competicion
{
	static List<Jugador> jugadores = new ArrayList<Jugador>();
	static List<Entrenador> entrenadores = new ArrayList<Entrenador>();
	static List<Equipo> equipos = new ArrayList<Equipo>();
	static List<Arbitro> arbitros = new ArrayList<Arbitro>();
	static ArrayList<Partido> partidos = new ArrayList<>();
	private static Estadio estadio = new Estadio();
	

	
	public static void main (String[] args)
	{
		Random random = new Random();
		
		
		
		// Crear jugadores
		crearJugadores(random, jugadores);
		
		// Crear Entrenadores
		crearEntrenadores(random, entrenadores);
		
		// Crear Equipos
		Equipo escocia = new Equipo(Naciones.ESCOCIA);
		Equipo francia = new Equipo(Naciones.FRANCIA);
		Equipo gales = new Equipo(Naciones.GALES);
		Equipo inglaterra = new Equipo(Naciones.INGLATERRA);
		Equipo irlanda = new Equipo(Naciones.IRLANDA);
		Equipo italia = new Equipo(Naciones.ITALIA);
		
		// A�adimos 30 jugadores a cada equipo de forma aleatoria
		a�adirJugadoresAEquipos(random, jugadores, escocia);
		a�adirJugadoresAEquipos(random, jugadores, francia);
		a�adirJugadoresAEquipos(random, jugadores, gales);
		a�adirJugadoresAEquipos(random, jugadores, inglaterra);
		a�adirJugadoresAEquipos(random, jugadores, irlanda);
		a�adirJugadoresAEquipos(random, jugadores, italia);
		
		// A�adimos 3 entrenadores a cada equipo
		a�adirEntrenadoresAEquipos(random, entrenadores, escocia);
		a�adirEntrenadoresAEquipos(random, entrenadores, francia);
		a�adirEntrenadoresAEquipos(random, entrenadores, gales);
		a�adirEntrenadoresAEquipos(random, entrenadores, inglaterra);
		a�adirEntrenadoresAEquipos(random, entrenadores, irlanda);
		a�adirEntrenadoresAEquipos(random, entrenadores, italia);
		
		// A�adimos los equipos a una lista
		equipos.add(escocia);
		equipos.add(francia);
		equipos.add(gales);
		equipos.add(inglaterra);
		equipos.add(irlanda);
		equipos.add(italia);
		
		// Creamos los arbitros
		
		crearArbitros(random, arbitros);
		
		// Hacemos que un entrenador coja la alineaci�n principal de sus jugadores.
		
		crearAlineacion(francia);
		
		crearAlineacion(gales);
		
		crearAlineacion(inglaterra);
		
		crearAlineacion(irlanda);
		
		crearAlineacion(italia);
		
		crearAlineacion(escocia);
		
		

	
		
		//System.out.println("\n");
		
		competir();
		
		
		System.out.println(partidos);
		
	
	}





	
	

	// M�todos para el programa
	
	
	
	//A�adir entrenadores y jugadores
	
	private static void a�adirEntrenadoresAEquipos(Random random, List<Entrenador> entrenadores, Equipo equipo) {
		for(int i = 0; i<3 ; i++) {
			int entrenadorRandom = random.nextInt(entrenadores.size());
			Entrenador entrenador = entrenadores.get(entrenadorRandom);
			equipo.a�adirEntrenador(entrenador);
			entrenador.setEquipo(equipo);
			entrenadores.remove(entrenadorRandom);
		}
	}

	private static void a�adirJugadoresAEquipos(Random random, List<Jugador> jugadores, Equipo equipo) {
		for(int i = 0; i<30 ; i++) {
			int jugadorRandom = random.nextInt(jugadores.size());
			Jugador jugador = jugadores.get(jugadorRandom);
			equipo.a�adirJugador(jugador);
			jugador.setEquipo(equipo);
			jugadores.remove(jugadorRandom);
		}
	}
	
	private static void crearEntrenadores(Random random, List<Entrenador> entrenadores) {
		for( int i=0; i<18; i++) {
			
			int minDay = (int) LocalDate.of(1993, 1, 1).toEpochDay();
			int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);
			
			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
			
			entrenadores.add(new Entrenador("Entrenador "+i, randomBirthDate, random.nextInt(90-60)+60, random.nextInt(30)));
		}
	}

	private static void crearJugadores(Random random, List<Jugador> jugadores) {
		
		
		for( int i=0; i<180; i++) {
			int minDay = (int) LocalDate.of(1993, 1, 1).toEpochDay();
			int maxDay = (int) LocalDate.of(2015, 1, 1).toEpochDay();
			long randomDay = minDay + random.nextInt(maxDay - minDay);
			
			LocalDate randomBirthDate = LocalDate.ofEpochDay(randomDay);
			jugadores.add(new Jugador("Jugador "+i, randomBirthDate, random.nextInt(90-60)+60, random.nextInt(100), random.nextInt(100), random.nextInt(100)));
			
		}
	}
	
	private static void crearArbitros(Random random, List<Arbitro> arbitros) {
		for(int i = 0; i<5; i++) {
			
			arbitros.add(new Arbitro("Arbitro "+i, null, random.nextInt(90-60)+60, random.nextInt(100)));
			
		}
		
	}
	
	//crear alineaci�n
	
	private static void crearAlineacion(Equipo equipo) {
		equipo.setAlineacion(equipo.getPlantillaEntrenadores().get(0).crearAlineacion(equipo.getPlantillaJugadores()));
	}
	
	// El m�todo competir
	
	public static void competir() {
		
		if (equipos.size() <= 0) {
			System.out.println("\n No hay equipos para competir");
		} else {
			Collections.shuffle(equipos);

			for (int i = 0; i < equipos.size(); i++) {
				for (int j = i + 1; j < equipos.size(); j++) {
					ArrayList<Arbitro> arbitroCancha = new ArrayList<>();
					arbitroCancha.add(arbitros.get(1));
					arbitroCancha.add(arbitros.get(2));
					arbitroCancha.add(arbitros.get(3));
					Collections.shuffle(arbitros);
					partidos.add(new Partido(equipos.get(i), equipos.get(j), new Date(), arbitroCancha));
				}
			}

			Collections.shuffle(partidos);

			for (Partido partido : partidos) {
				partido.jugar(estadio);
			}
		}
	}

}