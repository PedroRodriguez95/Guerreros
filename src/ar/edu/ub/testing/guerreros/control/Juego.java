package ar.edu.ub.testing.guerreros.control;




import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import ar.edu.ub.testing.guerreros.vista.MenuConsola;
import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerros.modelo.habilidad.IHabilidadActiva;
import ar.edu.ub.testing.guerros.modelo.habilidad.IHabilidadPasiva;

public class Juego {
	
	private static Scanner scan = new Scanner(System.in);
	private EntidadesJuego entidades;
	private Partida partida;
	private Map<Integer,Modo_Juego> modoJuego;
	private Map<Integer,IHabilidadActiva> habildadesActivas;
	private Map<Integer,IHabilidadPasiva> habildadesPasivas;
	

	public Juego() {
		entidades = new EntidadesJuego();
 
		crearPartidas();
		
		setModoJuego(new HashMap<>());
		
		crearModos();
		
		menuPrincipal();
	}
	
	
	private void crearModos() {
		getModoJuego().put(Modo_Juego.UN_JUGADOR.key(), Modo_Juego.UN_JUGADOR);
		getModoJuego().put(Modo_Juego.MULTI_COOP.key(), Modo_Juego.MULTI_COOP);
		getModoJuego().put(Modo_Juego.MULTI_VS.key(), Modo_Juego.MULTI_VS);
	}


	private void crearPartidas() {
	}


	//AL SELECCIONAR UN NUEVO JUEGO
	public void newSinglePlayer() {
		
		this.setPartida(new PartidaSingleplayer(entidades));
	}
	
	public void newMultiCoop() {
		
		this.setPartida(new PartidaMultiplayerCoop(entidades));
	}
	
	public void newMultiVersus() {
		
		this.setPartida(new PartidaMultiplayerVersus(entidades));
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
 
		getModoJuego().get( eleccion ).generarEntidades(entidades);
		
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


	public Partida getPartida() {
		return partida;
	}


	public void setPartida(Partida partida) {
		this.partida = partida;
	}


	public Map<Integer,Modo_Juego> getModoJuego() {
		return modoJuego;
	}


	public void setModoJuego(Map<Integer,Modo_Juego> modoJuego) {
		this.modoJuego = modoJuego;
	}


	public Map<Integer,IHabilidadActiva> getHabildadesActivas() {
		return habildadesActivas;
	}


	public void setHabildadesActivas(Map<Integer,IHabilidadActiva> habildadesActivas) {
		this.habildadesActivas = habildadesActivas;
	}


	public Map<Integer,IHabilidadPasiva> getHabildadesPasivas() {
		return habildadesPasivas;
	}


	public void setHabildadesPasivas(Map<Integer,IHabilidadPasiva> habildadesPasivas) {
		this.habildadesPasivas = habildadesPasivas;
	}


 


 
	

}