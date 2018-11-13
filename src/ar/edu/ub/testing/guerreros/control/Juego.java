package ar.edu.ub.testing.guerreros.control;




import java.util.Scanner;

import ar.edu.ub.testing.guerreros.vista.MenuConsola;
import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class Juego {
	
	private static Scanner scan = new Scanner(System.in);
	private EntidadesJuego entidades;
	private Partida partida;
	

	public Juego() {
		entidades = new EntidadesJuego();
		menuPrincipal();
	}
	
	
	//AL SELECCIONAR UN NUEVO JUEGO
	public void newSinglePlayer() {
		Modo_Juego.UN_JUGADOR.generarEntidades(entidades);
		this.partida = new PartidaSingleplayer(entidades);
	}
	
	public void newMultiCoop() {
		Modo_Juego.MULTI_COOP.generarEntidades(entidades);
		this.partida = new PartidaMultiplayerCoop(entidades);
	}
	
	public void newMultiVersus() {
		Modo_Juego.MULTI_VS.generarEntidades(entidades);
		this.partida = new PartidaMultiplayerVersus(entidades);
	}
	
	public void printEntidades() {
		entidades.getJugador().printAtributos();
		System.out.println("Guerreros Enemigos: ");
		for (GuerreroEnemigo g : entidades.getGuerrerosEnemigos()) {
			g.printAtributos();
		}
	}
	
	public void menuPrincipal() {
		UtilidadesConsola.limpiarConsola();
		MenuConsola.printMenuPrincipal();
		int eleccion = scan.nextInt();
		while(!(1<= eleccion && eleccion <= 4)) {
			MenuConsola.printMenuPrincipal();
			eleccion = scan.nextInt();
		}
		switch(eleccion) {
		case 1:
			menuSeleccionJuego();
			break;
		case 2:
			System.out.println("A implementar");
			break;
		case 3: 
			System.out.println("A implementar");
			break;
		case 4:
			break;
		}
			
		
	}
	
	public void menuSeleccionJuego() {
		UtilidadesConsola.limpiarConsola();
		MenuConsola.printMenuSeleccionJuego();
		int eleccion = scan.nextInt();
		while(!(1<= eleccion && eleccion <= 4)) {
			MenuConsola.printMenuPrincipal();
			eleccion = scan.nextInt();
		}
		switch(eleccion) {
		case 1:
			newSinglePlayer();
			menuPrincipal();
			break;
		case 2:
			newMultiCoop();
			break;
		case 3: 
			newMultiVersus();
			break;
		case 4:
			menuPrincipal();
		}
		
	}
	

}