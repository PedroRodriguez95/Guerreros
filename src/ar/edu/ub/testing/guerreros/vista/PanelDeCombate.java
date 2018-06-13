package ar.edu.ub.testing.guerreros.vista;

import javax.swing.JPanel;

import ar.edu.ub.testing.guerreros.control.Juego;

public class PanelDeCombate extends JPanel{
	private static final long serialVersionUID = 1L;
	
	
	private PanelCombateJugadores 	panelCombateJugadores;
	private PanelCombateBatalla 	panelCombateBatalla;
	private PanelCombateEnemigos	panelCombateEnemigos;
	private PanelCombateControles	panelCombateControles;
	
	private Juego juego;

	private static void configurarCampoDeCombate() {
		
		
	}


	public static void generarCampoDeCombate( Juego juego ) {
		
		//GENERAR TODO LO NECESARIO
		
		
		configurarCampoDeCombate();
	}


	public PanelCombateJugadores getPanelCombateJugadores() {
		return panelCombateJugadores;
	}


	public void setPanelCombateJugadores(PanelCombateJugadores panelCombateJugadores) {
		this.panelCombateJugadores = panelCombateJugadores;
	}


	public PanelCombateBatalla getPanelCombateBatalla() {
		return panelCombateBatalla;
	}


	public void setPanelCombateBatalla(PanelCombateBatalla panelCombateBatalla) {
		this.panelCombateBatalla = panelCombateBatalla;
	}


	public PanelCombateEnemigos getPanelCombateEnemigos() {
		return panelCombateEnemigos;
	}


	public void setPanelCombateEnemigos(PanelCombateEnemigos panelCombateEnemigos) {
		this.panelCombateEnemigos = panelCombateEnemigos;
	}


	public PanelCombateControles getPanelCombateControles() {
		return panelCombateControles;
	}


	public void setPanelCombateControles(PanelCombateControles panelCombateControles) {
		this.panelCombateControles = panelCombateControles;
	}


	public Juego getJuego() {
		return juego;
	}


	public void setJuego(Juego juego) {
		this.juego = juego;
	}






}


