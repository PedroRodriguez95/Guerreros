package ar.edu.ub.testing.guerreros.vista;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;

import ar.edu.ub.testing.guerreros.control.Juego;

public class VentanaDeCombate extends JFrame{
	private static final long serialVersionUID = 1L;
	
	
	private PanelCombateJugadores 	panelCombateJugadores;
	private PanelCombateBatalla 	panelCombateBatalla;
	private PanelCombateEnemigos	panelCombateEnemigos;
	private PanelCombateControles	panelCombateControles;
	
	private Juego juego;

	
	public VentanaDeCombate(Juego juego) {
		
		setJuego(juego);
		generarCampoDeCombate();
		
	}
	private  void configurarCampoDeCombate() {
		
		
		setTitle("Guerreros v1.0 - Campo de Batalla");
		getContentPane().setLayout(new BorderLayout());
		setSize(1200, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		
		setLayout( new GridLayout(1,5) );
		
		add( getPanelCombateJugadores() );
		add( getPanelCombateBatalla() );
		add( getPanelCombateEnemigos() );
		add( getPanelCombateControles() );
		
		setVisible(true);
		
	}


	public void generarCampoDeCombate(  ) {
		
		
		
		setPanelCombateBatalla	( new PanelCombateBatalla  () );
		setPanelCombateEnemigos	( new PanelCombateEnemigos () );
		setPanelCombateControles( new PanelCombateControles() );
		setPanelCombateJugadores( new PanelCombateJugadores() );
		
		configurarCampoDeCombate();
		
		setVisible(true);
		
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


