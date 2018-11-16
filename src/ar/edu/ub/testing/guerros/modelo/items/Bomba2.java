package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class Bomba2 extends ItemActivo{
	
	private Guerrero jugador;

	public Bomba2(Guerrero jugador) {
		this.setEnergiaNecesaria(6);
		this.setNombre("Gran Bomba" + "(" + this.getEnergiaNecesaria() +  ")");
		this.setDescripcion("Reduce el ataque en -7 pero ataca a 4 enemigos");
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
		atacarEnemigosCercanos(entidades,objetivo);
		return " " + jugador.getAtributos().getNombre() + " lanza una bomba";
	}
	
	public void atacarEnemigosCercanos(EntidadesJuego entidades, int objetivo) {
		int ataques = 3;
		for (int i = 0; i < entidades.getGuerrerosEnemigos().length; i++) {
			if(ataques > 0 && entidades.getGuerrerosEnemigos()[i] != entidades.getGuerrerosEnemigos()[objetivo] && !(entidades.getGuerrerosEnemigos()[i].murio()) ) {
				jugador.atacar(entidades.getGuerrerosEnemigos()[i]);
				ataques--;
			}
		}
	}
	
}
