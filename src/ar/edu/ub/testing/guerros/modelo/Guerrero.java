package ar.edu.ub.testing.guerros.modelo;


public abstract class Guerrero {
	

	private Atributos atributos;
	private Cuerpo    cuerpo;
	

	public Guerrero() {
		this.atributos = new Atributos();
		this.cuerpo = new Cuerpo();
	}

	public void dañar(int daño) {
		if (daño > 0) {
			this.getAtributos().setVida(this.getAtributos().getVida() - daño);
		}
	}
	public Atributos getAtributos() {
		return atributos;
	}
	public Cuerpo getCuerpo() {
		return cuerpo;
	}
	
	public void printAtributos() {
		System.out.println("-------------------------------");
		System.out.println(this.getAtributos().getNombre());
		System.out.println("-------------------------------");
		System.out.println("Atauqe = " + this.getAtributos().getAtaque());
		System.out.println("Defensa = " + this.getAtributos().getDefensa());
		System.out.println("Energia = " + this.getAtributos().getEnergia());
		System.out.println("Precision = " + this.getAtributos().getPresicion());
		System.out.println("Vida = "  + this.getAtributos().getVida());
	}
	
	//PARA RAPIDA CONSTRUCCION EN CASOS DE PRUEBA
	public void setAtributosSimple(int ataque,int defensa,int energia,int presicion, int vida) {
		
		this.getAtributos().setAtaque(ataque);
		this.getAtributos().setDefensa(defensa);
		this.getAtributos().setEnergia(energia);
		this.getAtributos().setPresicion(presicion);
		this.getAtributos().setVida(vida);
	}
	
	
	public boolean murio() {
		if (this.getAtributos().getVida() <= 0) {
			this.getCuerpo().setCuerpoMuerto();
			this.getAtributos().setVida(0);
			return true;
		}else{
			this.cuerpo = new Cuerpo();
			return false;
		}
	}
	public void atacar(Guerrero enemigo) {
		enemigo.dañar(this.getAtributos().getAtaque() - (enemigo.getAtributos().getDefensa()/2));		
	}
}

