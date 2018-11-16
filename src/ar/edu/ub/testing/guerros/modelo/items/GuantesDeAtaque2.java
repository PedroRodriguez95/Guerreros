package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class GuantesDeAtaque2 extends ItemActivo{
	
	private Guerrero jugador;

	public GuantesDeAtaque2(Guerrero jugador) {
		this.setEnergiaNecesaria(5);
		this.setNombre("Guantes de Ataque +5"  + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Aumenta el ataque en +5");
		this.setPrecio(15);
		this.jugador = jugador;
	}
	
	
	
	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(jugador.getAtributos().getAtaque());
		jugador.getAtributos().setAtaque(jugador.getAtributos().getAtaque() + 5);
		jugador.atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		desactivarAccion();
		return " " + jugador.getAtributos().getNombre() + " aumenta su da�o en +5 con guantes de ataque";
	}

	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setAtaque(this.getAtributoOriginal());
	}



}
