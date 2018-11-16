package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class HabilidadEnemigoFallaAtaque extends HabilidadActiva{

	@Override
	public Integer consumeEnergia() {
		return 3;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		
	}

	@Override
	public String descripcion() {
		return "Enemigo Falla Ataque! ";
	}

}
