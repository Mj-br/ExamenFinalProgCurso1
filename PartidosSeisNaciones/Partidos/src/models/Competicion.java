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
			System.out.println("3. Mostrar Calificacion.");
			System.out.println("4. Salir.");
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
					
					// Hacemos que un entrenador coja la alineación principal de sus jugadores.
					
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
			

				case 3:
					competir();
					break;

				case 4:
					System.out.println("\n Gracias por jugar");
					break;
				default:
					System.out.println("\n Valor introducido incorrecto.");
					break;
			}
		} while (opcion != 4);
		sc.close();
	}

	
	

	// Métodos para el programa
	
	
	
	//Añadir entrenadores y jugadores
	
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
	
	//crear alineación
	
	private static void crearAlineacion(Equipo equipo) {
		equipo.setAlineacion(equipo.getPlantillaEntrenadores().get(0).crearAlineacion(equipo.getPlantillaJugadores()));
	}
	
	// El método competir
	
	public void competir() {
		
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

	
	// Método para los ficheros
	
	private static void confi() throws IOException {
		File fichero;
		FileReader leerArchivo;
		try {
			FileWriter filew = new FileWriter("C:\\practico\\naciones.txt");

			filew.write("LISTA DE ENTRENADORES\n");
			for (int i = 0; i < entrenadores.size(); i++) {
				filew.write("" + entrenadores.get(i) + "\n");
			}

			filew.write("LISTA DE JUGADORES\n");
			for (int i = 0; i < jugadores.size(); i++) {
				filew.write("" + jugadores.get(i) + "\n");
			}


			filew.write("LISTA DE ARBITROS\n");
			for (int i = 0; i < arbitros.size(); i++) {
				filew.write("" + arbitros.get(i) + "\n");
			}

			filew.write("JUGADORES POR EQUIPO\n");
			for (int i = 0; i < 6; i++) {
				filew.write("" + equipos.get(i) + "\n");
				filew.write("" + equipos.get(i).getPlantillaJugadores() + "\n");

				// fw.write(""+equipos.get(2)+"\n");

				filew.write("\n");
				filew.write("EQUIPO" + i + "\n");
			}

			filew.close();
			
			fichero = new File("C:\\practico1\\practico1.txt");
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
	
	private static void tablas() throws IOException {
		File f1;
		FileReader lectorArchivo;

		try {
			FileWriter filew1 = new FileWriter("C:\\practica1\\tabla_clasificacion.txt");

			filew1.write("Partidos");
			for (int i = 0; i < partidos.size(); i++) {
				filew1.write("\n" + partidos.get(i));
				filew1.write("\n");
			}
			filew1.close();
			f1 = new File("C:\\practica1\\tabla_clasificacion.txt");
			lectorArchivo = new FileReader(f1);
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