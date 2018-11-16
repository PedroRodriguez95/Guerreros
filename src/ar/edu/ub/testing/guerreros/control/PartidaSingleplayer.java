package ar.edu.ub.testing.guerreros.control;

import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateSingleplayer;
import ar.edu.ub.testing.guerreros.vista.VistaTiendaYEvolucion;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class PartidaSingleplayer extends Partida{
	
	private int turnoEnemigo = 0;
	private VistaCombateSingleplayer vista;

	public PartidaSingleplayer(EntidadesJuego entidadesExternas) {
		super(entidadesExternas);
		vista = new VistaCombateSingleplayer(entidadesExternas);
		print();
		Jugar();
	}

	@Override
	public boolean checkearCondicionesDeVictoria() {
		if(this.getEntidades().checkJugadorUnoMuerto()) {
			this.victoriaEnemigos();
			return true;
		}
		if(this.getEntidades().checkEnemigosMuertos()) {
			this.victoriaJugadorUno();
			return true;
		}
		return false;
		
	}

	@Override
	public void victoriaJugadorUno() {
		desactivarPasivos();
		vista.mostrarMensajeEnConsola(" Ganador: " + this.getEntidades().getJugador().getAtributos().getNombre());
		vista.mostrarMensajeEnConsola(" Comenzando nivel: " + (this.getEntidades().getRound() + 1));
		print();
		wait(5);
		entidades.siguienteRound();
		vista = new VistaCombateSingleplayer(entidades);
		turnoEnemigo = 0;
		checkearCondicionesDeVictoria();
		System.out.println(entidades.getJugador().getPuntos());
		entidades.getJugador().setPuntos(entidades.getJugador().getPuntos() + 3);
		System.out.println(entidades.getJugador().getPuntos());
		new VistaTiendaYEvolucion(entidades.getJugador(), entidades);
		Jugar();
	}

	@Override
	public void victoriaJugadorDos() {
	}

	@Override
	public void victoriaEnemigos() {
		vista.mostrarMensajeEnConsola(" Jugador derrotado por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		new Juego();

	}
	@Override
	public void Jugar() {
		activarPasivos();
		turnoJugador();
		}

	@Override
	public void turnoJugador() {
		checkearCondicionesDeVictoria();
		print();
		new ControladorHumano(entidades.getJugador(), entidades, vista);
		if(!checkearCondicionesDeVictoria()) {
			turnoEnemigo();
		}
	}

	@Override
	public void turnoEnemigo() {
		print();
		checkearCondicionesDeVictoria();
		wait(2);
		turnoEnemigo =  buscarSiguienteEnemigoNoMuerto(turnoEnemigo);
		atacar(entidades.getGuerrerosEnemigos()[turnoEnemigo],entidades.getJugador());
		turnoEnemigo ++;
		turnoJugador();
	}
	
	public void print() {
		vista.print(entidades);
	}
	
	private int buscarSiguienteEnemigoNoMuerto(int turno) {
		if (turno > 3) {
			turno = 0;
		}
		int siguienteTurno = turno;
			while (entidades.getGuerrerosEnemigos()[siguienteTurno].checkEnemigoNoDisponible()) {
				
				if(entidades.getGuerrerosEnemigos()[siguienteTurno].checkNocked()) {
					vista.mostrarMensajeEnConsola(" " + entidades.getGuerrerosEnemigos()[siguienteTurno].getAtributos().getNombre() + " se encuentra incapacitado por " + entidades.getGuerrerosEnemigos()[siguienteTurno].getContTurnosPausados() + " turnos ");
				}
				
				if (siguienteTurno == 3) {
					siguienteTurno = 0;
					
				}else {
					
					siguienteTurno++;
					
				}
			}
		return siguienteTurno;
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
	}
	

	@Override
	public void terminarPartida() {
		
	}

	@Override
	public void record() {
		
	}
	
	public void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void verAtributos() {
		entidades.getJugador().printAtributos();
		System.out.println("Guerreros Enemigos: ");
		for (GuerreroEnemigo g : entidades.getGuerrerosEnemigos()) {
			g.printAtributos();
		}
		UtilidadesConsola.apretarEnterParaContinuar();
		turnoJugador();
	}
	
}


