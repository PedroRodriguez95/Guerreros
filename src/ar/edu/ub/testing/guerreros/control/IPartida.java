package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public interface IPartida {
	
	public boolean checkearCondicionesDeVictoria(EntidadesJuego entidades);
	public void VictoriaJugadorUno();
	public void VictoriaJugadorDos();
	public void VictoriaEnemigos();
	public void turnoEnemigo(EntidadesJuego entidades);
	public void turnoJugador(EntidadesJuego entidades);
	public void jugar(EntidadesJuego entidades);
	

}
