package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class GuantesDeAtaque1 extends ItemActivo{
	
	private Guerrero jugador;

	public GuantesDeAtaque1(Guerrero jugador) {
		this.setEnergiaNecesaria(3);
		this.setNombre("Guantes de Ataque + 3"  + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Aumenta el ataque en +3");
		this.setPrecio(10);
		this.jugador = jugador;
	}
	
	
	
	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(jugador.getAtributos().getAtaque());
		jugador.getAtributos().setAtaque(jugador.getAtributos().getAtaque() + 3);
		jugador.atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		desactivarAccion();
		return " " + jugador.getAtributos().getNombre() + " aumenta su daño en +3 con guantes de ataque";
	}

	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setAtaque(this.getAtributoOriginal());
	}




}
