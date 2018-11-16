package ar.edu.ub.testing.guerreros.control;

import java.util.ArrayList;

import ar.edu.ub.testing.guerreros.vista.Consola;
import ar.edu.ub.testing.guerreros.vista.OpcionesHumano;
import ar.edu.ub.testing.guerreros.vista.Vista;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerros.modelo.items.ItemActivo;

public class ControladorHumano {
	
	private Guerrero humano;
	private EntidadesJuego entidades;
	private Vista vista;
	private OpcionesHumano opciones;
	
	public ControladorHumano(Guerrero jugador,EntidadesJuego entidades, Vista vista) {
		this.humano = jugador;
		this.entidades = entidades;
		this.vista = vista;
		this.opciones = new OpcionesHumano(jugador);
		menuPrincipal();
	}

	public void menuPrincipal() {
		opciones.printOpcionesHumano();
		int eleccion = Consola.pedirNumero(1, 5);
		switch(eleccion) {
		case 1:
			vista.print(entidades);
			menuAtacar(this.humano,entidades.getGuerrerosEnemigos());
			break;
		case 2:
			 break;
		case 3:
			break;
		case 4:
			vista.print(entidades);
			break;
		case 5:
			break;
		}
	}
	
	
	
	public void menuAtacar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		opciones.printPanelAtacar();
		int eleccion = Consola.pedirNumero(1, enemigos.length);
		atacar(jugador, enemigos[eleccion - 1]);
	}
	
	public void menuUsaritems(Guerrero jugador, EntidadesJuego entidades) {
		ArrayList<ItemActivo> items = new ArrayList<>();
	}
	
	public void atacar(Guerrero atacante, Guerrero atacado){
		int daño = atacante.getAtributos().getAtaque() - (atacado.getAtributos().getDefensa()/2);
		if (daño < 0) {
			daño = 0;
		}
		atacante.atacar(atacado);
		vista.mostrarMensajeEnConsola(" " + atacante.getAtributos().getNombre() + " ataco a " + atacado.getAtributos().getNombre() + " por " + daño + " puntos de daño");
		
	}
	
}
