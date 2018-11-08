package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;

public class VistaCombate{
	
	Combate combate;
	Consola consola;
	Cabezera cabezera;
	
	public VistaCombate(EntidadesJuego entidades) {
		combate = new Combate(entidades);
		consola = new Consola();
		cabezera = new CabezeraSingleplayer(entidades);
	}
	
	public void mostrarMensajeEnConsola(String mensaje) {
		consola.actualizarConsola(mensaje);
	}

	public void print(EntidadesJuego entidades) {
		UtilidadesConsola.limpiarConsola();
		actualizarEntidades(entidades);
		cabezera.print();
		combate.print();
		consola.print();
		
	}
	
	public void actualizarEntidades(EntidadesJuego entidades) {
	combate = new Combate(entidades);
	cabezera = new CabezeraSingleplayer(entidades);
	}
}
