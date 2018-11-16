package ar.edu.ub.testing.guerros.modelo.habilidad;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class Habilidad20PorcEvadirAtaque extends HabilidadPasiva{
	
	@Override
	public String descripcion() {
		
		return "Ataque Evadido!";
	}
	
	@Override
	public void ejecutar(Guerrero jugador, Guerrero enemigo) {
		
		jugador.getAtributos().setVida( jugador.getAtributos().getVida() +  enemigo.getAtributos().getAtaque() );
	}
	
	@Override
	public boolean probar() {
		return probar(5,1);
	}
	public Habilidad20PorcEvadirAtaque() {
		super();
	}

}
