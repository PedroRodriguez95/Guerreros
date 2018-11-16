package ar.edu.ub.testing.guerros.modelo.habilidad;



import ar.edu.ub.testing.guerros.modelo.Guerrero;

public interface IHabilidadActiva extends IHabilidad{
	
	public Integer consumeEstamina();
	
	public void ejecutar(Guerrero jugador, Guerrero[] enemigo);

}
