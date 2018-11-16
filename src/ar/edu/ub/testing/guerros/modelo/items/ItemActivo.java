package ar.edu.ub.testing.guerros.modelo.items;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public abstract class ItemActivo extends Item{
	
	private int energiaNecesaria;
	
	
	public abstract String ejecutarAccionActiva(EntidadesJuego entidades,int objetivo);
	public abstract void desactivarAccion();
	
	
	public int getEnergiaNecesaria() {
		return energiaNecesaria;
	}
	protected void setEnergiaNecesaria(int energiaNecesaria) {
		this.energiaNecesaria = energiaNecesaria;
	}
}
