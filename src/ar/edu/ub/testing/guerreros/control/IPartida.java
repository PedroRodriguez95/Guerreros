package ar.edu.ub.testing.guerreros.control;

public interface IPartida {
	
	public boolean checkearCondicionesDeVictoria();
	public void VictoriaJugadorUno();
	public void VictoriaJugadorDos();
	public void VictoriaEnemigos();
	public void jugar();
	public void turnoJugador();
	public void turnoEnemigo();
	public void terminarPartida();
	public void record();
	

}
