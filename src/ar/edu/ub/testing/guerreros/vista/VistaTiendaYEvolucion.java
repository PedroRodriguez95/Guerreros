package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerreros.control.LaboratorioGuerreros;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerros.modelo.items.AnilloDeAtaque;
import ar.edu.ub.testing.guerros.modelo.items.AnilloDeDefensa;
import ar.edu.ub.testing.guerros.modelo.items.AnilloDeEnergia;
import ar.edu.ub.testing.guerros.modelo.items.AnilloDePresicion;
import ar.edu.ub.testing.guerros.modelo.items.Bomba1;
import ar.edu.ub.testing.guerros.modelo.items.Bomba2;
import ar.edu.ub.testing.guerros.modelo.items.GuantesDeAtaque1;
import ar.edu.ub.testing.guerros.modelo.items.GuantesDeAtaque2;
import ar.edu.ub.testing.guerros.modelo.items.Item;

public class VistaTiendaYEvolucion {
	
	private GuerreroJugador guerrero;
	private EntidadesJuego entidades;
	
	public VistaTiendaYEvolucion(GuerreroJugador guerrero, EntidadesJuego entidades) {
		this.entidades = entidades;
		this.guerrero = guerrero;
		menuPrincipal();
	}
	
	private void printMenuPrincipal() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero());
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Tienda Items                   X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Tienda Habilidades             X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Asignar Puntos                 X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreNivel());
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	private String printNombreNivel() {
		String s  ="X 4) Continuar al nivel: " + entidades.getRound();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
		
	}
	
	private String printNombreGuerrero() {
		String s  ="X " + guerrero.getAtributos().getNombre().toUpperCase() + "    Puntos: " + guerrero.getPuntos();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-2;i++) {
			s += " ";
		}
		s += " X";
		return s;
		
	}
	
	private void menuPrincipal() {
		UtilidadesConsola.limpiarConsola();
		printMenuPrincipal();
		int eleccion = Consola.pedirNumero(1, 4);
		switch(eleccion) {
		case 1:
			menuTiendaItems();
			break;
		case 2:
			 break;
		case 3:
			LaboratorioGuerreros.mutarGuerreroManual(guerrero.getPuntos(), guerrero, entidades);
			break;
		case 4:
			break;
	}
	}
	private void printMenuTiendaItems() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero());
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Items Activos                  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Items Pasivos                  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	private void menuTiendaItems() {
		UtilidadesConsola.limpiarConsola();
		printMenuTiendaItems();
		int eleccion = Consola.pedirNumero(1, 3);
		switch(eleccion) {
		case 1:
			menuTiendaActivos();
			break;
		case 2:
			menuTiendaPasivos();
			break;
		case 3:
			menuPrincipal();
			break;
		}
	}
	
	private void printMenuActivos() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero());
		if (guerrero.getItems()[0] == null) {
			System.out.println("X Slot 1) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(0));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(1));
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1) Guantes de Ataque +3       10P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2) Guantes de Ataque +5       15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3) Bomba                      10P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4) Gran Bomba                 15P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 5) Atras                          X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	private String printNombreItem(int item) {
		
		String s  ="X" + (item+1) + ")" + guerrero.getItems()[item].getNombre();
		int cantidadEspacios = 37 - s.length();
		for(int i = 0; i<cantidadEspacios-3;i++) {
			s += " ";
		}
		s += " X";
		return s;
	}
	
	private void menuTiendaActivos() {
		UtilidadesConsola.limpiarConsola();
		printMenuActivos();
		int eleccion = Consola.pedirNumero(1, 5);
		switch(eleccion) {
		case 1:
			if(guerrero.getPuntos() >= 10) {
				guerrero.setPuntos(guerrero.getPuntos() - 10 );
				GuantesDeAtaque1 item = new GuantesDeAtaque1(guerrero);
				menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 2:
			if(guerrero.getPuntos() >= 15) {
				guerrero.setPuntos(guerrero.getPuntos() - 15 );
				GuantesDeAtaque2 item = new GuantesDeAtaque2(guerrero);
				menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 3:
			if(guerrero.getPuntos() >= 10) {
				guerrero.setPuntos(guerrero.getPuntos() - 10 );
				Bomba1 item = new Bomba1(guerrero);
				menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 4:
			if(guerrero.getPuntos() >= 15) {
				guerrero.setPuntos(guerrero.getPuntos() - 15 );
				Bomba2 item = new Bomba2(guerrero);
				menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 5:
			menuTiendaItems();
			break;
		}
	}
	
	private void printMenuPasivos() {
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero());
		if (guerrero.getItems()[0] == null) {
			System.out.println("X Slot 1) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(0));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println(this.printNombreItem(1));
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 1)    Anillo de Ataque         5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 2)    Anillo de Defensa        5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 3)    Anillo de Presicion      5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 4)    Anillo de Energia        5P X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X 5)         Atras                  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	private void menuTiendaPasivos() {
		UtilidadesConsola.limpiarConsola();
		printMenuPasivos();
		int eleccion = Consola.pedirNumero(1, 5);
		switch(eleccion) {
		case 1:
			if(guerrero.getPuntos() >= 5) {
				guerrero.setPuntos(guerrero.getPuntos() - 5 );
			AnilloDeAtaque item = new AnilloDeAtaque(guerrero);
			menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 2:
			if(guerrero.getPuntos() >= 5) {
				guerrero.setPuntos(guerrero.getPuntos() - 5 );
			AnilloDeDefensa item = new AnilloDeDefensa(guerrero);
			menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 3:
			if(guerrero.getPuntos() >= 5) {
				guerrero.setPuntos(guerrero.getPuntos() - 5 );
			AnilloDePresicion item = new AnilloDePresicion(guerrero);
			menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 4:
			if(guerrero.getPuntos() >= 5) {
				guerrero.setPuntos(guerrero.getPuntos() - 5 );
			AnilloDeEnergia item = new AnilloDeEnergia(guerrero);
			menuAsignarItem(item);
			}else {
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
				System.out.println("X       Puntos insuficientes        X");
				System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
			}
			menuPrincipal();
			break;
		case 5:
			menuTiendaItems();
			break;
		}
	}
	
	private void menuAsignarItem(Item item) {
		UtilidadesConsola.limpiarConsola();
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println(printNombreGuerrero());
		if (guerrero.getItems()[0] == null) {
			System.out.println("X Slot 1) Vacio                     X");
		}else {
			System.out.println("X 1)" + this.printNombreItem(0));
		}
		
		if (guerrero.getItems()[1] == null) {
			System.out.println("X Slot 2) Vacio                     X");
		}else {
			System.out.println("X 2)" + this.printNombreItem(1));
		}
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		System.out.println("X        Seleccionar Slot           X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
		int eleccion = Consola.pedirNumero(1, 2);
		if(eleccion == 1) {
			guerrero.getItems()[0] = item;
		}else {
			guerrero.getItems()[1] = item;
		}
	}
	
}
