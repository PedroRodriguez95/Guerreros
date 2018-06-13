package ar.edu.ub.testing.guerros.modelo;

public abstract class Guerrero {
	

	private Atributos atributos;
	private Cuerpo    cuerpo;
	

	public Guerrero() {
		this.atributos = new Atributos();
		this.cuerpo = new Cuerpo();
	}
	
	public void atacar(Guerrero enemigo) {
		enemigo.restarVida(this.getAtributos().getAtaque() - enemigo.getAtributos().getDefensa());

	}

	private void restarVida(int restaVida){
		
		this.getAtributos().setVida(this.getAtributos().getVida() - restaVida);
		
	}
	public Atributos getAtributos() {
		return atributos;
	}
	public Cuerpo getCuerpo() {
		return cuerpo;
	}
	
}
