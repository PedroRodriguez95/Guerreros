package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class Habilidad25PorcDobleDanio extends HabilidadPasiva{

	
	
	public Habilidad25PorcDobleDanio() {
		super();

	}

	@Override
	public void ejecutar(Guerrero jugador, Guerrero enemigo) {
		jugador.atacar(enemigo);
	}

	@Override
	public String descripcion() {
		
		return "Doble Danio!";
	}

	@Override
	public boolean probar() {
		return probar(4,1);
	}

}
