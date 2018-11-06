package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public class VistaCombate implements IVista{
	
	Combate combate;
	Consola consola;
	
	public VistaCombate(EntidadesJuego entidades) {
		combate = new Combate(entidades);
		consola = new Consola();
	}
	
	public void mostrarMensajeEnConsola(String mensaje) {
		consola.actualizarConsola(mensaje);
	}
	
	@Override
	public void print() {
		combate.print();
		consola.print();
		
	}


	

}
