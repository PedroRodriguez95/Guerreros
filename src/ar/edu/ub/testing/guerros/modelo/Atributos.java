package ar.edu.ub.testing.guerros.modelo;

public class Atributos {
	
	private String  nombre;
	private int     ataque;
	private int     defensa;
	private int     presicion;
	private int     vidaAux;
	private int     vida;
	private int     energia;
	
	public Atributos() {
		
		this.ataque = 1;
		this.defensa = 1;
		this.presicion = 1;
		this.vidaAux = 1;
		this.vida = 1;
		this.energia = 1;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAtaque() {
		return ataque;
	}
	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}
	public int getDefensa() {
		return defensa;
	}
	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}
	public int getPresicion() {
		return presicion;
	}
	public void setPresicion(int presicion) {
		this.presicion = presicion;
	}
	public int getVida() {
		return vida;
	}
	public void setVida(int vida) {
		if (vida >= this.vidaAux) {
			this.vidaAux = vida;
		}
		this.vida = vida;
	}
	public int getEnergia() {
		return energia;
	}
	
	public int getVidaAux() {
		return this.vidaAux;
	}
	public void setEnergia(int energia) {
		this.energia = energia;
	}
	
	public void resetVida() {
		this.vida = this.vidaAux;
	}
	

}
