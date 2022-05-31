package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import models.Arbitro;
import models.Entrenador;
import models.Equipo;
import models.Jugador;
import models.Naciones;


public class Main
{
	
	public static void main (String[] args)
	{
		Random random = new Random();
		
		List<Jugador> jugadores = new ArrayList<Jugador>();
		List<Entrenador> entrenadores = new ArrayList<Entrenador>();
		List<Equipo> equipos = new ArrayList<Equipo>();
		List<Arbitro> arbitros = new ArrayList<Arbitro>();
		
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
		
		// Añadimos 30 jugadores a cada equipo de forma aleatoria
		añadirJugadoresAEquipos(random, jugadores, escocia);
		añadirJugadoresAEquipos(random, jugadores, francia);
		añadirJugadoresAEquipos(random, jugadores, gales);
		añadirJugadoresAEquipos(random, jugadores, inglaterra);
		añadirJugadoresAEquipos(random, jugadores, irlanda);
		añadirJugadoresAEquipos(random, jugadores, italia);
		
		// Añadimos 3 entrenadores a cada equipo
		añadirEntrenadoresAEquipos(random, entrenadores, escocia);
		añadirEntrenadoresAEquipos(random, entrenadores, francia);
		añadirEntrenadoresAEquipos(random, entrenadores, gales);
		añadirEntrenadoresAEquipos(random, entrenadores, inglaterra);
		añadirEntrenadoresAEquipos(random, entrenadores, irlanda);
		añadirEntrenadoresAEquipos(random, entrenadores, italia);
		
		// Añadimos los equipos a una lista
		equipos.add(escocia);
		equipos.add(francia);
		equipos.add(gales);
		equipos.add(inglaterra);
		equipos.add(irlanda);
		equipos.add(italia);
		
		// Creamos los arbitros
		
		crearArbitros(random, arbitros);
		
		// El entrenador0 de escocia va a crear una alineación
		System.out.println(escocia.getPlantillaEntrenadores().get(0).crearAlineacion(escocia.getPlantillaJugadores()));
			
	}
	

	private static void añadirEntrenadoresAEquipos(Random random, List<Entrenador> entrenadores, Equipo equipo) {
		for(int i = 0; i<3 ; i++) {
			int entrenadorRandom = random.nextInt(entrenadores.size());
			Entrenador entrenador = entrenadores.get(entrenadorRandom);
			equipo.añadirEntrenador(entrenador);
			entrenador.setEquipo(equipo);
			entrenadores.remove(entrenadorRandom);
		}
	}

	private static void añadirJugadoresAEquipos(Random random, List<Jugador> jugadores, Equipo equipo) {
		for(int i = 0; i<30 ; i++) {
			int jugadorRandom = random.nextInt(jugadores.size());
			Jugador jugador = jugadores.get(jugadorRandom);
			equipo.añadirJugador(jugador);
			jugador.setEquipo(equipo);
			jugadores.remove(jugadorRandom);
		}
	}
	
	private static void crearEntrenadores(Random random, List<Entrenador> entrenadores) {
		for( int i=0; i<18; i++) {
			entrenadores.add(new Entrenador("Entrenador "+i, null, random.nextInt(90-60)+60, random.nextInt(30)));
		}
	}

	private static void crearJugadores(Random random, List<Jugador> jugadores) {
		for( int i=0; i<180; i++) {
			jugadores.add(new Jugador("Jugador "+i, null, random.nextInt(90-60)+60, random.nextInt(100), random.nextInt(100), random.nextInt(100)));
		}
	}
	
	private static void crearArbitros(Random random, List<Arbitro> arbitros) {
		for(int i = 0; i<5; i++) {
			
			arbitros.add(new Arbitro("Arbitro "+i, null, random.nextInt(90-60)+60, random.nextInt(100)));
			
		}
		
	}
	

}
