package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public class PartidaSingleplayer extends Partida implements IPartida{
	
	private int turnoEnemigo = 0;

	public PartidaSingleplayer(EntidadesJuego entidadesExternas) {
		super(entidadesExternas);
	}

	@Override
	public boolean checkearCondicionesDeVictoria(EntidadesJuego entidades) {
		if(this.getEntidades().checkJugadorUnoMuerto()) {
			this.VictoriaEnemigos();
			return true;
		}
		if(this.getEntidades().checkEnemigosMuertos()) {
			this.VictoriaJugadorUno();
			return true;
		}
		return false;
	}

	@Override
	public void VictoriaJugadorUno() {
		this.getEntidades().getJugador().setOro(this.getEntidades().getJugador().getOro() + 300);
	}

	@Override
	public void VictoriaJugadorDos() {
	}

	@Override
	public void VictoriaEnemigos() {
	}

	@Override
	public void turnoEnemigo(EntidadesJuego entidades) {
		checkearCondicionesDeVictoria(entidades);
		if (turnoEnemigo == 3) {
			turnoEnemigo = 0;
		}
		entidades.getInteligenciaBot().setBot(entidades.getGuerrerosEnemigos()[turnoEnemigo]);
		entidades.getInteligenciaBot().atacar();	
		turnoJugador(entidades);
			
	}
		
	@Override
	public void turnoJugador(EntidadesJuego entidades) {
		checkearCondicionesDeVictoria(entidades);
		}

	@Override
	public void jugar(EntidadesJuego entidades) {
		
		}
	
}


