package ar.edu.ub.testing.guerros.modelo.items;

public abstract class ItemPasivo extends Item{
	
	public abstract void ejecutarAccionPasiva();
	public abstract void desactivarAccionPasiva();
	
	public int calcularAumento(float actual,float aumento) {
		float resultado = (actual * aumento)/100;
		return (int) Math.round(resultado);
	}

}
