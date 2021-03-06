package models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;


public class Competicion
{
	static List<Jugador> jugadores = new ArrayList<Jugador>();
	static List<Entrenador> entrenadores = new ArrayList<Entrenador>();
	static List<Equipo> equipos = new ArrayList<Equipo>();
	static List<Arbitro> arbitros = new ArrayList<Arbitro>();
	static ArrayList<Partido> partidos = new ArrayList<>();
	private static Estadio estadio = new Estadio();
	
	static Scanner sc = new Scanner(System.in);
	

	public void Menu() {
		
		Random random = new Random();
		
		int opcion;
		do {
			System.out.println(" Partido de las SEIS NACIONES ");
			System.out.println("1. Generar los Equipos y sus integrantes.");
			System.out.println("2. Simular Competicion.");
			System.out.println("3. Mostrar Equipos.");
			System.out.println("4. Mostrar Calificacion.");
			System.out.println("5. Comprueba actas de arbitro por consola.");
			System.out.println("6. Salir.");
			opcion = sc.nextInt();
			switch (opcion) {

				case 1:
		
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
					
					// A?adimos 30 jugadores a cada equipo de forma aleatoria
					a?adirJugadoresAEquipos(random, jugadores, escocia);
					a?adirJugadoresAEquipos(random, jugadores, francia);
					a?adirJugadoresAEquipos(random, jugadores, gales);
					a?adirJugadoresAEquipos(random, jugadores, inglaterra);
					a?adirJugadoresAEquipos(random, jugadores, irlanda);
					a?adirJugadoresAEquipos(random, jugadores, italia);
					
					// A?adimos 3 entrenadores a cada equipo
					a?adirEntrenadoresAEquipos(random, entrenadores, escocia);
					a?adirEntrenadoresAEquipos(random, entrenadores, francia);
					a?adirEntrenadoresAEquipos(random, entrenadores, gales);
					a?adirEntrenadoresAEquipos(random, entrenadores, inglaterra);
					a?adirEntrenadoresAEquipos(random, entrenadores, irlanda);
					a?adirEntrenadoresAEquipos(random, entrenadores, italia);
					
					// A?adimos los equipos a una lista
					equipos.add(escocia);
					equipos.add(francia);
					equipos.add(gales);
					equipos.add(inglaterra);
					equipos.add(irlanda);
					equipos.add(italia);
					
					// Creamos los arbitros
					
					crearArbitros(random, arbitros);
					
					// Hacemos que un entrenador coja la alineaci?n principal de sus jugadores.
					
					crearAlineacion(francia);
					
					crearAlineacion(gales);
					
					crearAlineacion(inglaterra);
					
					crearAlineacion(irlanda);
					
					crearAlineacion(italia);
					
					crearAlineacion(escocia);
					

					System.out.println("Ya tenemos a todos los equipos listos para competir.\n");
					break;
					
					case 2:
					this.competir();
					break;
		
					
				case 3: try {
					
					Torneo();
					
				}catch(Exception e) {
					System.out.println(e);
				}
				break;
					
				case 4:
					try {
						
						tablas();
						
					}catch(Exception e) {
						System.out.println(e);
					}
					break;
					
				case 5:
					Actas();
					System.out.println("\n Gracias por jugar");
					break;
					
				case 6:
					System.out.println("\n Gracias por jugar");
					break;
					
					
				
				default:
					System.out.println("\n Valor introducido incorrecto.");
					break;
			}
		} while (opcion != 6);
		sc.close();
	}

	
	

	// M?todos para el programa
	
	
	
	//A?adir entrenadores y jugadores
	
	private static void a?adirEntrenadoresAEquipos(Random random, List<Entrenador> entrenadores, Equipo equipo) {
		for(int i = 0; i<3 ; i++) {
			int entrenadorRandom = random.nextInt(entrenadores.size());
			Entrenador entrenador = entrenadores.get(entrenadorRandom);
			equipo.a?adirEntrenador(entrenador);
			entrenador.setEquipo(equipo);
			entrenadores.remove(entrenadorRandom);
		}
	}

	private static void a?adirJugadoresAEquipos(Random random, List<Jugador> jugadores, Equipo equipo) {
		for(int i = 0; i<30 ; i++) {
			int jugadorRandom = random.nextInt(jugadores.size());
			Jugador jugador = jugadores.get(jugadorRandom);
			equipo.a?adirJugador(jugador);
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
	
	//crear alineaci?n
	
	private static void crearAlineacion(Equipo equipo) {
		equipo.setAlineacion(equipo.getPlantillaEntrenadores().get(0).crearAlineacion(equipo.getPlantillaJugadores()));
	}
	
	// El m?todo competir
	
	public void competir() {
		
		if (equipos.size() <= 0) {
			System.out.println("\n No hay equipos para competir.\n");
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

	// M?todo para ver las actas
	
	public void Actas() {
		if (equipos.size() <= 0) {
			System.out.println("\n No hay equipos, por favor crear los datos primero.\n");
		} else {
			System.out.println(arbitros.get(0).getActas() + "\n Las Actas de los partidos han sido creadas");
		}
	}
	
	// M?todo para los ficheros
	
	private static void Torneo() throws IOException {
		
		if (equipos.size() <= 0) {
			System.out.println("\n A?n no hay equipos inscritos en el torneo..\n");
		} else {
		
		
		
		File fichero;
		FileReader leerArchivo;
		
		File f1 = new File("Naciones.txt");
		
		FileWriter escribirArchivo = new FileWriter(f1);
		
		try {

			escribirArchivo.write("LISTA DE ENTRENADORES\n");
			for (int i = 0; i < equipos.size(); i++) {
				escribirArchivo.write("" + equipos.get(i).getPlantillaEntrenadores() + "\n");
			}

			escribirArchivo.write("LISTA DE JUGADORES\n");
			for (int i = 0; i < equipos.size(); i++) {
				escribirArchivo.write("" + equipos.get(i).getPlantillaJugadores() + "\n");
			}


			escribirArchivo.write("LISTA DE ARBITROS\n");
			for (int i = 0; i < arbitros.size(); i++) {
				escribirArchivo.write("" + arbitros.get(i).toString() + "\n");
			}

			escribirArchivo.write("JUGADORES POR EQUIPO\n");
			for (int i = 0; i < 6; i++) {
				escribirArchivo.write("EQUIPO " + equipos.get(i).getNombreNacion() + "\n");
				escribirArchivo.write("" + equipos.get(i).getPlantillaJugadores() + "\n");

				escribirArchivo.write("\n");
			}

			escribirArchivo.close();
			
			fichero = new File("Naciones.txt");
			leerArchivo = new FileReader(fichero);
			BufferedReader br = new BufferedReader(leerArchivo);
			String l = "";
			String aux = "";
			while (true) {
				aux = br.readLine();
				if (aux != null)
					l = l + aux + "\n";
				else
					break;
			}
			br.close();
			leerArchivo.close();
			System.out.println(l);

		} catch (Exception e) {

		}
		
		}

	}
	
	// crear la tabla en el fichero txt
	
	private static void tablas() throws IOException {
		
		if (equipos.size() <= 0) {
			System.out.println("\n El toreno a?n no se ha ejecutado..\n");
		} else {
		
		
		
		File f1 = new File("tabla_clasificacion.txt");
		
		FileWriter escribirArchivo = new FileWriter(f1);
		
		

		try {

			escribirArchivo.write("PARTIDOS SEIS NACIONES");
			System.out.println("\n");
			for (int i = 0; i < equipos.size(); i++) {
				escribirArchivo.write("\n EQUIPO: "  + equipos.get(i).getNombreNacion() + ", PARTIDOS JUGADOS: " + equipos.get(i).getPartidosJugados() + ", VICTORIAS: " + equipos.get(i).getPartidosGanados() + ", DERROTAS: " + equipos.get(i).getPartidosPerdidos() + ", EMPATES: " + equipos.get(i).getPartidosEmpatados() + ", PUNTOS: " + equipos.get(i).getPuntos());
				
			}
			escribirArchivo.close();
			
	   f1 = new File("tabla_clasificacion.txt");
			FileReader lectorArchivo = new FileReader(f1);
			BufferedReader br = new BufferedReader(lectorArchivo);
			String l1 = "";
			String aux1 = "";
			while (true) {
				aux1 = br.readLine();
				if (aux1 != null)
					l1 = l1 + aux1 + "\n";
				else
					break;
			}
			br.close();
			lectorArchivo.close();
			System.out.println(l1);
	
		} catch (Exception e) {
		}
		}
	}
}