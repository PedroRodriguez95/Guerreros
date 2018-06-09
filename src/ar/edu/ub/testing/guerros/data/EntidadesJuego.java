package ar.edu.ub.testing.guerros.data;

public class EntidadesJuego {
	
	private GuerreroEnemigo[] guerrerosEnemigos;
	private GuerreroJugador   jugador1;
	private GuerreroJugador   jugador2;
	
	public EntidadesJuego(Modo_Juego modo) {
		modo.generarEntidades(this);
	}
		
	public GuerreroEnemigo[] getGuerrerosEnemigos() {
		return guerrerosEnemigos;
	}
	
	public void setGuerrerosEnemigos(GuerreroEnemigo[] guerrerosEnemigos) {
		this.guerrerosEnemigos = guerrerosEnemigos;
	}
	
	public Guerrero getJugador() {
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
}
