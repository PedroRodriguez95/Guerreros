package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public interface IHabilidadPasiva extends IHabilidad{
	
	public boolean probar();
	
	public void ejecutar(Guerrero jugador, Guerrero enemigo);
	
}
