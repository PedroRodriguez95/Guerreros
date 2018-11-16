package ar.edu.ub.testing.guerros.modelo.items;

public abstract class ItemActivo extends Item{
	
	private int energiaNecesaria;
	
	public abstract void ejecutarAccionActiva();
	public abstract void desactivarAccionActiva();
	
	
	public int getEnergiaNecesaria() {
		return energiaNecesaria;
	}
	protected void setEnergiaNecesaria(int energiaNecesaria) {
		this.energiaNecesaria = energiaNecesaria;
	}
}
