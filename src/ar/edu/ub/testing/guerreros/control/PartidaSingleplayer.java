package ar.edu.ub.testing.guerreros.control;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import ar.edu.ub.testing.guerreros.vista.UtilidadesConsola;
import ar.edu.ub.testing.guerreros.vista.VistaCombate;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

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
	public boolean checkearCondicionesDeVictoria() {
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
		vista.mostrarMensajeEnConsola(" Ganador: " + this.getEntidades().getJugador().getAtributos().getNombre());
		vista.mostrarMensajeEnConsola(" Comenzando nivel: " + (this.getEntidades().getRound() + 1));
		print();
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		entidades.siguienteRound();
		vista = new VistaCombate(entidades);
		turnoEnemigo = 0;
		checkearCondicionesDeVictoria();
		jugar();
	}

	@Override
	public void VictoriaJugadorDos() {
	}

	@Override
	public void VictoriaEnemigos() {
		vista.mostrarMensajeEnConsola("Jugador derrotado por generacion #" + this.getEntidades().getRound());
		print();
		wait(5);
		new Juego();

	}
	@Override
	public void jugar() {
		turnoJugador();
		}

	@Override
	public void turnoJugador() {
		print();
		checkearCondicionesDeVictoria();
		controladorHumano();
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
		if (turno >= 3) {
			turno = 0;
		}
		int siguienteTurno = turno;
			while (entidades.getGuerrerosEnemigos()[siguienteTurno].murio()) {
				
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
	
	public void controladorHumano() {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while(!(1<= eleccion && eleccion <= 5)) {
			eleccion = scan.nextInt();
		}
		switch(eleccion) {
		case 1:
			humanoAtaca(entidades);	
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
	
	public void humanoAtaca(EntidadesJuego entidades) {
		Scanner scan = new Scanner(System.in);
		int eleccion = scan.nextInt();
		while(!(1<= eleccion && eleccion <= entidades.getGuerrerosEnemigos().length)) {
			eleccion = scan.nextInt();
		}
		atacar(entidades.getJugador(),entidades.getGuerrerosEnemigos()[eleccion-1]);
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


