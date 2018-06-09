package ar.edu.ub.testing.guerreros.vision;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import ar.edu.ub.testing.guerros.data.EntidadesJuego;
import ar.edu.ub.testing.guerros.data.Modo_Juego;

public class VentanaPrincipal extends JFrame{
	
	private PanelDeCombate             panelDeCombate;
	private PanelDeCreacionDePersonaje panelDeCreacionDePersonaje;
	private PanelMenuPrincipal         menuPrincipal;
	private EntidadesJuego             entidades;
	private Modo_Juego                 modo;
	
	private static final long serialVersionUID = 1L;
	
	public VentanaPrincipal() {
		
		configurarVentana();
		generarComponentes(this);
		setVisible(true);
		
	}
	
	private void configurarVentana() {
		
		setTitle("Guerreros v1.0");
		getContentPane().setLayout(new BorderLayout());
		setSize(1000, 600);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	public void generarComponentes(VentanaPrincipal ventana) {
		JMenuBar barra=new JMenuBar();
		JMenu archivo=new JMenu("Juego");
		JMenuItem salir=new JMenuItem("Salir");
		JMenuItem cargar=new JMenuItem("Ir a menu");
		JMenuItem guardar=new JMenuItem("Guardar");
		cargar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ventana.MenuPrincipal(ventana);
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
		this.setJMenuBar(barra);
		this.setPanelDeCombate(new PanelDeCombate());
		this.setPanelDeCreacionDePersonaje(new PanelDeCreacionDePersonaje());
		this.setMenuPrincipal(new PanelMenuPrincipal(this));
		this.add(this.getPanelDeCombate());
		this.add(this.getPanelDeCreacionDePersonaje());
		this.add(this.getMenuPrincipal());

	}
	
	
	public void panelDeCombate() {
		
		this.getPanelDeCreacionDePersonaje().setVisible(false);
		this.getPanelDeCombate().setVisible(true);
		System.out.println("panel de combate");
		
	}
	
	public void panelDeCreacionDePersonaje() {
		
		this.getPanelDeCombate().setVisible(false);
		this.getPanelDeCreacionDePersonaje().setVisible(true);
		System.out.println("panel de creacion");
	}
	
	public void MenuPrincipal(VentanaPrincipal ventana) {
		this.getPanelDeCombate().setVisible(false);
		this.getPanelDeCreacionDePersonaje().setVisible(false);
		this.getMenuPrincipal().setVisible(true);
		System.out.println("Panel de menu");
	}

	public PanelDeCombate getPanelDeCombate() {
		return panelDeCombate;
	}

	public void setPanelDeCombate(PanelDeCombate panelDeCombate) {
		this.panelDeCombate = panelDeCombate;
	}

	public PanelDeCreacionDePersonaje getPanelDeCreacionDePersonaje() {
		return panelDeCreacionDePersonaje;
	}

	public void setPanelDeCreacionDePersonaje(PanelDeCreacionDePersonaje panelDeCreacionDePersonaje) {
		this.panelDeCreacionDePersonaje = panelDeCreacionDePersonaje;
	}

	public EntidadesJuego getEntidades() {
		return entidades;
	}

	public void setEntidades(EntidadesJuego entidades) {
		this.entidades = entidades;
	}

	public Modo_Juego getModo() {
		return modo;
	}

	public void setModo(Modo_Juego modo) {
		this.modo = modo;
	}

	public PanelMenuPrincipal getMenuPrincipal() {
		return menuPrincipal;
	}

	public void setMenuPrincipal(PanelMenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
	}


}
