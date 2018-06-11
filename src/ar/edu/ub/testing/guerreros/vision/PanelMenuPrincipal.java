package ar.edu.ub.testing.guerreros.vision;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelMenuPrincipal extends JPanel{
	private static final long serialVersionUID = 1L;
	
	public PanelMenuPrincipal(JPanel contenedorDePaneles, CardLayout controlDePaneles) {
		
		JButton singleplayer               = new JButton("Un Jugador");
		JButton multiCoop                  = new JButton("2 VS PC");
		JButton multiVs                    = new JButton("1 Vs 1");
		
		singleplayer.setBounds(350, 100, 300, 100);
		multiCoop.setBounds(350, 200, 300, 100);
		multiVs.setBounds(350, 300, 300, 100);
		
		singleplayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlDePaneles.show(contenedorDePaneles, "2");
			}
		});
		multiCoop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlDePaneles.show(contenedorDePaneles, "2");
			}
		});
		multiVs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				controlDePaneles.show(contenedorDePaneles, "2");
			}
		});
		this.setBackground(Color.BLACK);
		this.setLayout(null);
		configurarBotones(singleplayer,multiCoop,multiVs);
		this.add(singleplayer);
		this.add(multiCoop);
		this.add(multiVs);
		
		
		
	}
	private void configurarBotones(JButton singleplayer,JButton multiCoop, JButton multiVs){
		
		//CONFIGURO COLORES DE LOS BOTONES
		singleplayer.setBackground(Color.BLACK);
		multiCoop.setBackground(Color.BLACK);
		multiVs.setBackground(Color.BLACK);
		
		//CONFIGURO LOS COLORES DE LAS FUENTES DE LOS BOTONES
		singleplayer.setForeground(Color.WHITE);
		multiCoop.setForeground(Color.WHITE);
		multiVs.setForeground(Color.WHITE);
		
		//CONFIGURO LAS FUENTES DE LOS BOTONES
		//PENDIENTE
		
	}

}
