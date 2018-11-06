package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.vista.Combate;
import ar.edu.ub.testing.guerreros.vista.VistaCombate;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public class PartidaSingleplayer extends Partida implements IPartida{
	
	private int turnoEnemigo = 0;
	private VistaCombate vista;

	public PartidaSingleplayer(EntidadesJuego entidadesExternas) {
		super(entidadesExternas);
		vista = new VistaCombate(entidadesExternas);
		print();
	}

	@Override
	public void checkearCondicionesDeVictoria() {
		if(this.getEntidades().checkJugadorUnoMuerto()) {
			this.VictoriaEnemigos();
		}
		if(this.getEntidades().checkEnemigosMuertos()) {
			this.VictoriaJugadorUno();
		}
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
	public void jugar() {
		
		}

	@Override
	public void turnoJugador() {
		checkearCondicionesDeVictoria();
	}

	@Override
	public void turnoEnemigo() {
		checkearCondicionesDeVictoria();
		
	}
	
	public void print() {
		vista.print();
	}
	
}


