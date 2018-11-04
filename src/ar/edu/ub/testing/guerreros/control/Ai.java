package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;

public class Ai {
	
	private GuerreroEnemigo bot;
	private GuerreroJugador objetivo;
	
	
	public void setObjectivo(GuerreroJugador objetivoHumano){
		
		this.objetivo = objetivoHumano;
	
	}
	
	public void setBot(GuerreroEnemigo botEnemigo) {
		
		this.bot = botEnemigo;
		
	}
	
	public GuerreroEnemigo getBot() {
		return this.bot;
	}
	
	public void atacar() {
		this.bot.atacar(this.objetivo);
	}
	
}
