package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;

public class AiSingleplayer extends Ai{
	
	private GuerreroEnemigo bot;
	private GuerreroJugador objetivo;
	
	public AiSingleplayer(EntidadesJuego entidades) {
		this.setObjectivo(objetivo);
	}
	
	
	public void setObjectivo(GuerreroJugador objetivoHumano){
		
		this.objetivo = objetivoHumano;
	
	}
	
	public void setBot(GuerreroEnemigo botEnemigo) {
		
		this.bot = botEnemigo;
		
	}
	}
