package ar.edu.ub.testing.guerros.modelo;

public class GuerreroJugador extends Guerrero {
	
	private int oro;
	
	public GuerreroJugador() {
		super();
		this.setOro(0);
	}

	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}
	
	public void atacar(GuerreroEnemigo enemigo) {
		
			enemigo.restarVida(this.getAtributos().getAtaque() - enemigo.getAtributos().getDefensa());

		}
}
	
	


