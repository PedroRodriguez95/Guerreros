package ar.edu.ub.testing.guerreros.funciones;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import ar.edu.ub.testing.guerreros.vision.PanelDeCombate;
import ar.edu.ub.testing.guerreros.vision.PanelDeCreacionDePersonaje;
import ar.edu.ub.testing.guerreros.vision.PanelMenuPrincipal;
import ar.edu.ub.testing.guerros.data.EntidadesJuego;

public class Juego {
	EntidadesJuego entidades           ;
	JFrame ventana                     = new JFrame();
	JPanel contenedorDePaneles         = new JPanel();
	CardLayout controlDePaneles        = new CardLayout();
	JPanel panelDeCombate              = new PanelDeCombate();
	JPanel panelDeCreacionDePersonaje  = new PanelDeCreacionDePersonaje();
	JPanel panelMenuPrincipal          = new PanelMenuPrincipal(contenedorDePaneles,controlDePaneles);

	public Juego() {
		configurarBarra();
		configurarVentana();
	}
	
	public void configurarVentana() {
		contenedorDePaneles.setLayout(controlDePaneles);
		contenedorDePaneles.add(panelDeCombate, "1");
		contenedorDePaneles.add(panelDeCreacionDePersonaje, "2");
		contenedorDePaneles.add(panelMenuPrincipal, "3");
		controlDePaneles.show(contenedorDePaneles, "3");
		ventana.setTitle("Guerreros v1.0");
		ventana.getContentPane().setLayout(new BorderLayout());
		ventana.setSize(1000, 600);
		ventana.setResizable(false);
		ventana.setLocationRelativeTo(null);
		ventana.add(contenedorDePaneles);
		ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		ventana.setVisible(true);
	}
	
	public void configurarBarra() {
		JMenuBar barra=new JMenuBar();
		JMenu archivo=new JMenu("Juego");
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem cargar=new JMenuItem("Ir a menu");
		JMenuItem guardar=new JMenuItem("Guardar");
		cargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				controlDePaneles.show(contenedorDePaneles, "3");
				;
			}

        });
		salir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}

        });
		barra.add(archivo);
		archivo.add(cargar);
		archivo.add(guardar);
		archivo.add(salir);
		ventana.setJMenuBar(barra);
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Juego();
			}
		});
	}

}