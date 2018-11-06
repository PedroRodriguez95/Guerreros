package ar.edu.ub.testing.guerros.modelo;

import ar.edu.ub.testing.guerreros.control.Ai;

public class EntidadesJuego {
	
	private Ai                inteligenciaBot;
	private GuerreroEnemigo[] guerrerosEnemigos;
	private GuerreroJugador   jugador1;
	private GuerreroJugador   jugador2;

	public GuerreroEnemigo[] getGuerrerosEnemigos() {
		return guerrerosEnemigos;
	}
	
	public void setGuerrerosEnemigos(GuerreroEnemigo[] guerrerosEnemigos) {
		this.guerrerosEnemigos = guerrerosEnemigos;
	}
	
	public GuerreroJugador getJugador() {
		return jugador1;
	}
	
	public void setJugador(GuerreroJugador jugador) {
		this.jugador1 = jugador;
	}

	public static void limpiarConsola() {
		for (int i = 1; i < 70; i++) {
			System.out.println(" ");
		}
	}

	public Guerrero getJugador2() {
		return jugador2;
	}

	public void setJugador2(GuerreroJugador jugador2) {
		this.jugador2 = jugador2;
	}
	
	public boolean checkJugadorUnoMuerto() {
		return jugador1.murio();
	}
	
	public boolean checkJugadorDosMuerto() {
		return jugador2.murio();
	}
	public boolean checkEnemigosMuertos() {
		
		boolean resultado = true;
		
		for(GuerreroEnemigo g : this.getGuerrerosEnemigos()) {
			if(!g.murio()) {
				resultado = false;
			}
		}
		
		return resultado;
	}

	public Ai getInteligenciaBot() {
		return inteligenciaBot;
	}

	public void setInteligenciaBot(Ai inteligenciaBot) {
		this.inteligenciaBot = inteligenciaBot;
	}
}
