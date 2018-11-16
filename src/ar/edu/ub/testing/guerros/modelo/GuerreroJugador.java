package ar.edu.ub.testing.guerros.modelo;

import ar.edu.ub.testing.guerros.modelo.items.Bomba1;
import ar.edu.ub.testing.guerros.modelo.items.Bomba2;

public class GuerreroJugador extends Guerrero {
	
	private int puntos;
	
	public GuerreroJugador() {
		super();
		this.setPuntos(45);
		this.getItems()[0] = new Bomba1(this);
		this.getItems()[1] = new Bomba2(this);
	}

	public int getPuntos() {
		return puntos;
	}

	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}

}
	
	


