package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class Habilidad25PorcDobleDaño extends HabilidadPasiva{

	
	
	public Habilidad25PorcDobleDaño(IHabilidad habilidad) {
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
