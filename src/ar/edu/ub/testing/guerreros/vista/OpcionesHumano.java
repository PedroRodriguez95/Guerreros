package ar.edu.ub.testing.guerreros.vista;

import ar.edu.ub.testing.guerros.modelo.Guerrero;

public class OpcionesHumano {
	
	private Guerrero humano;
	
	public OpcionesHumano(Guerrero humano) {
		this.humano = humano;
	}
	
	public void printOpcionesHumano() {
		printCabezera(humano);
		System.out.println("X  1)Atacar 2)Defender 3)Especial 4)Usar Item 5)Ver Atributos  X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}
	
	public void printCabezera(Guerrero humano) {
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
		printCabezera(humano);
		System.out.println("X  Seleccione objetivo                                         X");
		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
	}

}
