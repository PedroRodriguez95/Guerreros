package ar.edu.ub.testing.guerreros.vision;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import ar.edu.ub.testing.guerros.data.Modo_Juego;

public class PanelMenuPrincipal extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	private JButton    singlePlayer = new JButton("Un jugador");
	private JButton    multiCoop    = new JButton("1 vs 1");
	private JButton    multiVs      = new JButton("2 vs COM");
	private JButton    cargar       = new JButton();
	private JButton    records      = new JButton();
	private JButton    salir        = new JButton();	

	public PanelMenuPrincipal(VentanaPrincipal ventanaPrincipal) {
		setBackground(Color.DARK_GRAY);
		this.setLayout(null);
		this.singlePlayer.setBounds(350, 100, 300, 100);
		this.multiCoop.setBounds(350, 200, 300, 100);
		this.multiVs.setBounds(350, 300, 300, 100);
		
		configurarBotones();
		
		this.singlePlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setModo(Modo_Juego.UN_JUGADOR);
				ventanaPrincipal.getMenuPrincipal().setVisible(false);
				ventanaPrincipal.panelDeCreacionDePersonaje();
			}

        });
		this.multiCoop.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setModo(Modo_Juego.MULTI_COOP);
				ventanaPrincipal.getMenuPrincipal().setVisible(false);
				ventanaPrincipal.panelDeCreacionDePersonaje();
			}

        });
		this.multiVs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setModo(Modo_Juego.MULTI_VS);
				ventanaPrincipal.getMenuPrincipal().setVisible(false);
				ventanaPrincipal.panelDeCreacionDePersonaje();
			}

        });
		this.cargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}

        });
		this.records.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}

        });
		this.salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}

        });
		this.add(singlePlayer);
		this.add(multiCoop);
		this.add(multiVs);
	}

	private void configurarBotones() {
		
		//CONFIGURO COLORES DE LOS BOTONES
		singlePlayer.setBackground(Color.BLACK);
		multiCoop.setBackground(Color.BLACK);
		multiVs.setBackground(Color.BLACK);
		
		//CONFIGURO LOS COLORES DE LAS FUENTES DE LOS BOTONES
		singlePlayer.setForeground(Color.WHITE);
		multiCoop.setForeground(Color.WHITE);
		multiVs.setForeground(Color.WHITE);
		
		//CONFIGURO LAS FUENTES DE LOS BOTONES
		//PENDIENTE
		
	}

}
