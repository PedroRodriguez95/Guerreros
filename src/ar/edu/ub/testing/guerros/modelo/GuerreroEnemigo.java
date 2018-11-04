package ar.edu.ub.testing.guerros.modelo;

public class GuerreroEnemigo extends Guerrero {
	
	public GuerreroEnemigo() {
		super();
	}
	
	public void atacar(Guerrero enemigo) {
		enemigo.restarVida(this.getAtributos().getAtaque() - enemigo.getAtributos().getDefensa());

	}


}
