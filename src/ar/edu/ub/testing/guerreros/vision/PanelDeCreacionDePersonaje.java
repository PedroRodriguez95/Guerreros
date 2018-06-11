package ar.edu.ub.testing.guerreros.vision;


import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

public class PanelDeCreacionDePersonaje extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	public PanelDeCreacionDePersonaje(){
		
		JPanel     imagenGuerrero        = new JPanel();
		JPanel     panelDeAsignacion     = new JPanel();
		JPanel     panelDeItems          = new JPanel();
		JTextField nombre                = new JTextField();
		JLabel     fuerza                = new JLabel();
		/*
		JButton fuerzaMasCinco = new JButton("+1");
		JButton fuerzaMasUno = new JButton("+5");
		JButton energiaMasUno = new JButton("+1");
		JButton energiaMasCinco = new JButton("+5");
		JButton presicionMasUno = new JButton("+1");
		JButton presicionMascinco = new JButton("+5");
		JButton vidaMasuno = new JButton("+1");
		JButton vidaMascinco = new JButton("+5");
		JButton defensaMasuno = new JButton("+1");
		JButton defensaMascinco = new JButton("+5");
		*/
		
		this.setLayout(null);
		imagenGuerrero.setBackground(Color.BLACK);
		imagenGuerrero.setForeground(Color.WHITE);
		imagenGuerrero.setBounds(0, 0, 400,600);
		this.setBackground(Color.DARK_GRAY);
		imagenGuerrero.setVisible(true);
		this.add(imagenGuerrero);
	}
	
	
	
}
