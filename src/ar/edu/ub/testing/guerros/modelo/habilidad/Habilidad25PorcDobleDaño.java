package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class Habilidad25PorcDobleDa�o extends HabilidadPasiva{

	
	
	public Habilidad25PorcDobleDa�o(IHabilidad habilidad) {
		super(habilidad);

	}

	@Override
	public void ejecutar(Guerrero jugador, Guerrero enemigo) {
		
		
	}

	@Override
	public String descripcion() {
		
		return "Doble Danio!";
	}

	@Override
	public boolean probar() {
		return probar(4);
	}

}
