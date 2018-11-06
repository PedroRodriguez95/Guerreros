package ar.edu.ub.testing.guerreros.control;

import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.VistaCombate;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class PartidaSingleplayer extends Partida implements IPartida{
	
	private int turnoEnemigo = 0;
	private VistaCombate vista;

	public PartidaSingleplayer(EntidadesJuego entidadesExternas) {
		super(entidadesExternas);
		vista = new VistaCombate(entidadesExternas);
		print();
		jugar();
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
		turnoJugador();
		}

	@Override
	public void turnoJugador() {
		checkearCondicionesDeVictoria();
		atacar(entidades.getJugador(),entidades.getGuerrerosEnemigos()[0]);
		vista.print();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		turnoEnemigo();
	}

	@Override
	public void turnoEnemigo() {
		checkearCondicionesDeVictoria();
		atacar(entidades.getGuerrerosEnemigos()[turnoEnemigo],entidades.getJugador());
		if(turnoEnemigo == 3){
			turnoEnemigo = 0;
		}else{
			turnoEnemigo++;
		}
		vista.print();
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		turnoJugador();
		
	}
	
	public void print() {
		vista.print();
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque()-atacado.getAtributos().getDefensa();
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
	}
}


