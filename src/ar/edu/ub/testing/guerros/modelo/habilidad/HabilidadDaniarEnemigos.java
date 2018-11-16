package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class HabilidadDaniarEnemigos extends HabilidadActiva{

	@Override
	public Integer consumeEnergia() {
		return 6;
	}

	@Override
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		for(GuerreroEnemigo enemigo: enemigos)
			enemigo.getAtributos().setVida(enemigo.getAtributos().getVida()-3);
	}

	@Override
	public String descripcion() {
		return "Enemigos Daniados !";
	}

}
