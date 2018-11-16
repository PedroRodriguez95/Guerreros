package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class AnilloDeAtaque extends ItemPasivo{
	
	private Guerrero jugador;
	
	public AnilloDeAtaque(Guerrero jugador) {
		this.setNombre("Anillo de Ataque");
		this.setDescripcion("Aumenta el ataque en un 5%");
		this.setPrecio(10);
		this.jugador = jugador;
		
	}

	@Override
	public void ejecutarAccionPasiva() {
		this.setAtributoOriginal(jugador.getAtributos().getAtaque());
		this.jugador.getAtributos().setAtaque(this.jugador.getAtributos().getAtaque() + this.calcularAumento(jugador.getAtributos().getAtaque(), 5));
	}

	@Override
	public void desactivarAccionPasiva() {
		jugador.getAtributos().setAtaque(this.getAtributoOriginal());
		
	}

}
