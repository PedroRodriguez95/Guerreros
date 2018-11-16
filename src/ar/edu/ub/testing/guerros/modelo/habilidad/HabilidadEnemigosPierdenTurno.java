package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class HabilidadEnemigosPierdenTurno extends HabilidadActiva{

	@Override
	public Integer consumeEnergia() {
		return 10;
	}


	@Override
	public String descripcion() {
		return "Enemigos pierden un turno !";
	}


	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		
		for(GuerreroEnemigo enemigo: enemigos) {
			ejecutar(enemigo);
		}
			
	}

	public void ejecutar(GuerreroEnemigo enemigo) {
		enemigo.nockear(1);
	}

}
