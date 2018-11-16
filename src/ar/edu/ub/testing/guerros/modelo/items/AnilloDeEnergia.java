package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class AnilloDeEnergia extends ItemPasivo {
	
	private Guerrero jugador;
	
	public AnilloDeEnergia(Guerrero jugador) {
		this.setNombre("Anillo de Energia");
		this.setDescripcion("Aumenta la Energia en un 10%");
		this.setPrecio(10);
		this.jugador = jugador;
		
	}

	@Override
	public void ejecutarAccionPasiva() {
		this.setAtributoOriginal(jugador.getAtributos().getEnergia());
		this.jugador.getAtributos().setEnergia(this.jugador.getAtributos().getEnergia() + this.calcularAumento(jugador.getAtributos().getEnergia(), 10));
	}

	@Override
	public void desactivarAccionPasiva() {
		jugador.getAtributos().setEnergia(this.getAtributoOriginal());
		
	}
}
