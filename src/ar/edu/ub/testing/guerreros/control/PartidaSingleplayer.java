package ar.edu.ub.testing.guerreros.control;

import java.util.Scanner;
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
		print();
	}

	@Override
	public void VictoriaJugadorDos() {
	}

	@Override
	public void VictoriaEnemigos() {
		vista.mostrarMensajeEnConsola(" Ganador: Enemigos");
		print();

	}
	@Override
	public void jugar() {
		turnoJugador();
		}

	@Override
	public void turnoJugador() {
		checkearCondicionesDeVictoria();
		controladorHumano();
		print();
		if(!checkearCondicionesDeVictoria()) {
			turnoEnemigo();
		}
	}

	@Override
	public void turnoEnemigo() {
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		turnoEnemigo++;
		turnoEnemigo =  buscarSiguienteEnemigoNoMuerto(turnoEnemigo);
		atacar(entidades.getGuerrerosEnemigos()[turnoEnemigo],entidades.getJugador());
		print();
		if(!checkearCondicionesDeVictoria()) {
			turnoJugador();
		}
	}
	
	public void print() {
		vista.print(entidades);
	}
	
	private int buscarSiguienteEnemigoNoMuerto(int turno) {
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
		int daño = atacante.getAtributos().getAtaque()-atacado.getAtributos().getDefensa();
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
		case 2:
			//break;
		case 3:
			//break;
		case 4:
			//break;
		case 5:
			//break;
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void record() {
		
	}
	
}


