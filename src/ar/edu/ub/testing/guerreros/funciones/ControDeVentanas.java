package ar.edu.ub.testing.guerreros.funciones;

import ar.edu.ub.testing.guerreros.vision.PanelDeCombate;
import ar.edu.ub.testing.guerreros.vision.VentanaPrincipal;
import ar.edu.ub.testing.guerros.data.Modo_Juego;

public interface ControDeVentanas {
	
	public void generarVentana(VentanaPrincipal ventana,Modo_Juego modo);
	public void generarVentana(PanelDeCombate panel,Modo_Juego modo);
}

