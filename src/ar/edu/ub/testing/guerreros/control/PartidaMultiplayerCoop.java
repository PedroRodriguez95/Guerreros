package ar.edu.ub.testing.guerreros.control;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombateMultiplayerCoop;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class PartidaMultiplayerCoop extends Partida {
	
	private int turnoEnemigo = 0;
	private int turnoJugador = 1;
	private VistaCombateMultiplayerCoop vista;

	public PartidaMultiplayerCoop(EntidadesJuego entidadesExternas) {
		super(entidadesExternas);
		vista = new VistaCombateMultiplayerCoop(entidades);
		print();
		Jugar();
	}

	@Override
	public boolean checkearCondicionesDeVictoria() {
		if (this.entidades.checkJugadorUnoMuerto() && this.entidades.checkJugadorDosMuerto()) {
			this.victoriaEnemigos();
			return true;
		}
		if(this.entidades.checkEnemigosMuertos()) {
			this.victoriaJugadores();
			return true;
		}
		return false;
	}
	
	public void victoriaJugadores() {
		vista.mostrarMensajeEnConsola("Ganadores: " + this.getEntidades().getJugador().getAtributos().getNombre() + " " + this.getEntidades().getJugador2().getAtributos().getNombre());
		vista.mostrarMensajeEnConsola(" Comenzando nivel: " + (this.getEntidades().getRound() + 1));
		print();
		wait(5);
		entidades.siguienteRound();
		vista = new VistaCombateMultiplayerCoop(entidades);
		turnoEnemigo = 0;
		checkearCondicionesDeVictoria();
		Jugar();
	}

	@Override
	public void victoriaJugadorUno() {
	}

	@Override
	public void victoriaJugadorDos() {	
	}

	@Override
	public void victoriaEnemigos() {
		vista.mostrarMensajeEnConsola("Jugadores derrotados por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		new Juego();
	}

	@Override
	public void Jugar() {
		turnoJugador();
		}

	@Override
	public void turnoJugador() {
		print();
		checkearCondicionesDeVictoria();
		if(this.turnoJugador == 1) {
			controladorHumano(this.getEntidades().getJugador());
		}
		if (this.turnoJugador == 2) {
			controladorHumano(this.getEntidades().getJugador2());
		}
		this.turnoJugador++;
		if(this.turnoJugador > 2) {
			this.turnoJugador = 1;
		}
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

	@Override
	public void terminarPartida() {

		
	}

	@Override
	public void record() {
		
	}
	
	private int buscarSiguienteEnemigoNoMuerto(int turno) {
		if (turno >= 7) {
			turno = 0;
		}
		int siguienteTurno = turno;
			while (entidades.getGuerrerosEnemigos()[siguienteTurno].murio()) {
				
				if (siguienteTurno == 7) {
					siguienteTurno = 0;
					
				}else {
					
					siguienteTurno++;
					
				}
			}
		return siguienteTurno;
	}
	
	public void controladorHumano(Guerrero guerrero) {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while( esEleccionValida(eleccion) ) {
			eleccion = scan.nextInt();
		}
		switch(eleccion) {
		case 1:
			humanoAtaca(entidades,guerrero);	
			break;
		case 2:
			 break;
		case 3:
			break;
		case 4:
			break;
		case 5:
			verAtributos();
			break;
		}
	}
	
	private boolean esEleccionValida(int eleccion) {
		return !(1<= eleccion && eleccion <= 5);
	}

	public void humanoAtaca(EntidadesJuego entidades,Guerrero guerrero) {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while(!(1<= eleccion && eleccion <= entidades.getGuerrerosEnemigos().length)) {
			eleccion = scan.nextInt();
		}
		atacar(guerrero,entidades.getGuerrerosEnemigos()[eleccion-1]);
	}
	public void print() {
		vista.print(entidades);
	}
	
	public void wait(int segundos) {
		try {
			TimeUnit.SECONDS.sleep(segundos);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
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
