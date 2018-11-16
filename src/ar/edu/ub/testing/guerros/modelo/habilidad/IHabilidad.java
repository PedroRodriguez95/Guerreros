package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public interface IHabilidad {
		
	public void ejecutar(Guerrero jugador, Guerrero enemigo);
	
	public String descripcion();

}
