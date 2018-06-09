package ar.edu.ub.testing.guerreros.vision;

import java.awt.Color;

import javax.swing.JPanel;


public class PanelDeCombate extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelDeCombate() {
		this.generarPanelDeCombate();
	}
	
	
	public void generarPanelDeCombate(){
		this.setSize(1000, 600);
		setBackground(Color.WHITE);
	}
}


