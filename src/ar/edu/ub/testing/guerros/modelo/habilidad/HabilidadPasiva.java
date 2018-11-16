package ar.edu.ub.testing.guerros.modelo.habilidad;

import java.util.Random;

public abstract class HabilidadPasiva implements IHabilidadPasiva{
	
	private IHabilidad habilidad;
	private Random  rand;
	
	public HabilidadPasiva(IHabilidad habilidad){
		this.setHabilidad(habilidad);
		this.setRand(new Random());
	}
	
	public boolean probar(Integer max ) {
		return 1==getRand().nextInt((max - 1) + 1);
	}

	public IHabilidad getHabilidad() {
		return habilidad;
	}

	private void setHabilidad(IHabilidad habilidad) {
		this.habilidad = habilidad;
	}

	private Random getRand() {
		return rand;
	}

	private void setRand(Random rand) {
		this.rand = rand;
	}
	
}
