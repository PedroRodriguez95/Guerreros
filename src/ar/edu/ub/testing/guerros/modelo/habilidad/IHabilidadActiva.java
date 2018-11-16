package ar.edu.ub.testing.guerros.modelo.habilidad;



import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public interface IHabilidadActiva extends IHabilidad{
	
	public Integer consumeEnergia();
	
	public void ejecutar(Guerrero jugador, GuerreroEnemigo[] enemigos);

}
