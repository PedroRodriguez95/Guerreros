package ar.edu.ub.testing.guerros.modelo;

public abstract class Guerrero {
	

	private Atributos atributos;
	private Cuerpo    cuerpo;
	private int oro;
	

	public Guerrero() {
		this.atributos = new Atributos();
		this.cuerpo = new Cuerpo();
	}

	protected void restarVida(int restaVida){
		
		this.getAtributos().setVida(this.getAtributos().getVida() - restaVida);
		
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
	
	public void setAtributosSimple(int ataque,int defensa,int energia,int presicion, int vida) {
		
		this.getAtributos().setAtaque(ataque);
		this.getAtributos().setDefensa(defensa);
		this.getAtributos().setEnergia(energia);
		this.getAtributos().setPresicion(presicion);
		this.getAtributos().setVida(vida);
	}
	public int getOro() {
		return oro;
	}

	public void setOro(int oro) {
		this.oro = oro;
	}
}
