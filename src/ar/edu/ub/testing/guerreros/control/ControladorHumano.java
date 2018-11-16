package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerreros.vista.Consola;
import ar.edu.ub.testing.guerreros.vista.Vista;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public class ControladorHumano {
	
	private Guerrero humano;
	private EntidadesJuego entidades;
	private Vista vista;
	
	public ControladorHumano(Guerrero jugador,EntidadesJuego entidades, Vista vista) {
		this.humano = jugador;
		this.entidades = entidades;
		this.vista = vista;
		menuPrincipal();
	}
	
	public void printOpcionesHumano() {
		printCabezera();
		System.out.println("X  1)Atacar 2)Defender 3)Especial 4)Usar Item 5)Ver Atributos  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void printCabezera() {
		String datos = "X Turno: " + humano.getAtributos().getNombre() + "              Energia: " + humano.getAtributos().getEnergia();
		int cantidadEspacios = 64 - datos.length();
		for (int i = 0; i < cantidadEspacios-2; i++) {
			datos += " ";
		}
		datos += " X";
		System.out.println(datos);
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void printPanelAtacar() {
		printCabezera();
		System.out.println("X  Seleccione objetivo                                         X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void menuPrincipal() {
		printOpcionesHumano();
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
			break;
		case 5:
			break;
		}
	}
	
	
	
	public void menuAtacar(Guerrero jugador, GuerreroEnemigo[] enemigos) {
		printPanelAtacar();
		int eleccion = Consola.pedirNumero(1, enemigos.length);
		atacar(jugador, enemigos[eleccion - 1]);
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
