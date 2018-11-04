package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public class Partida {
	
	EntidadesJuego entidades;
	
	
	public Partida(EntidadesJuego entidadesExternas) {
		
		this.entidades = entidadesExternas;
		
	}
	
	public EntidadesJuego getEntidades() {
		return this.entidades;
	}
	
}
