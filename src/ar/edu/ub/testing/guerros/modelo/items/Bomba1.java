package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class Bomba1 extends ItemActivo{

	private Guerrero jugador;

	public Bomba1(Guerrero jugador) {
		this.setEnergiaNecesaria(5);
		this.setNombre("Bomba" + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Reduce el ataque en -5 pero ataca a 2 enemigos");
		this.setPrecio(15);
		this.jugador = jugador;
	}
	
	@Override
	public void desactivarAccion() {
		jugador.getAtributos().setAtaque(this.getAtributoOriginal());
	}



	@Override
	public String ejecutarAccionActiva(EntidadesJuego entidades, int objetivo) {
		this.setAtributoOriginal(jugador.getAtributos().getAtaque());
		this.jugador.getAtributos().setAtaque(jugador.getAtributos().getAtaque() - 5);
		this.jugador.atacar(entidades.getGuerrerosEnemigos()[objetivo]);
		return " " + jugador.getAtributos().getNombre() + " lanza una bomba";
	}
	
	public void atacarEnemigosCercanos(EntidadesJuego entidades, int objetivo) {
		int ataques = 1;
		for (int i = 0; i < entidades.getGuerrerosEnemigos().length; i++) {
			if(ataques > 0 && entidades.getGuerrerosEnemigos()[i] != entidades.getGuerrerosEnemigos()[objetivo] && !(entidades.getGuerrerosEnemigos()[i].murio()) ) {
				jugador.atacar(entidades.getGuerrerosEnemigos()[i]);
				ataques--;
			}
		}
	}
	

}
