package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public class VistaCombateMultiplayerCoop extends Vista{
	
	private CombateMultiplayerCoop combate;
	private ConsolaJuego consola;
	private Cabezera cabezera;

	public VistaCombateMultiplayerCoop(EntidadesJuego entidades) {
		combate = new CombateMultiplayerCoop(entidades);
		consola = new ConsolaJuego();
		cabezera = new CabezeraMultiplayerCoop(entidades);
	}
	
	@Override
	public void mostrarMensajeEnConsola(String mensaje) {
		consola.actualizarConsola(mensaje);
	}
	
	public void limpiarConsola() {
		consola.limpiarConsola();
	}
	
	@Override
	public void print(EntidadesJuego entidades) {
		UtilidadesConsola.limpiarConsola();
		actualizarEntidades(entidades);
		cabezera.print();
		combate.print();
		consola.print();
		
	}
	
	public void actualizarEntidades(EntidadesJuego entidades) {
	combate = new CombateMultiplayerCoop(entidades);
	cabezera = new CabezeraMultiplayerCoop(entidades);
	}


}
