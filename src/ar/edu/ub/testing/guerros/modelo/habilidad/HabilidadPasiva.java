package ar.edu.ub.testing.guerros.modelo.habilidad;

import java.util.Random;

public abstract class HabilidadPasiva implements IHabilidadPasiva{
	
 
	private Random  rand;
	
	public HabilidadPasiva( ){
 
		this.setRand(new Random());
	}
	
	public boolean probar(Integer max ) {
		return 1==getRand().nextInt((max - 1) + 1);
	}
 

	private Random getRand() {
		return rand;
	}

	private void setRand(Random rand) {
		this.rand = rand;
	}
	
}
