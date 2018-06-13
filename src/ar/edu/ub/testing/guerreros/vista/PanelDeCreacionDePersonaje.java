package ar.edu.ub.testing.guerreros.vista;


import java.awt.Color;
import java.awt.List;
import java.util.LinkedList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;

public class PanelDeCreacionDePersonaje extends JPanel{
	
	private static final long serialVersionUID = 1L;
	
	GuerreroJugador guerrero;
	LinkedList<JButton> botones;
	JPanel     imagenGuerrero           = new JPanel();
	JPanel     panelDeAsignacion        = new JPanel();
	JPanel     panelDeItems             = new JPanel();
	JTextField nombre                   = new JTextField();
	JLabel     nombreEtiqueta           = new JLabel("Nombre");
	JLabel     fuerza                   = new JLabel("Fuerza");
	JLabel     vida                     = new JLabel("Vida");
	JLabel     defensa                  = new JLabel("Defensa");
	JLabel     energia                  = new JLabel("Energia");
	JLabel     presicion                = new JLabel("Presicion");
	TitledBorder     borde;
	
	
	
	public PanelDeCreacionDePersonaje(){	
		botones = this.crearBotones();
		this.setLayout(null);
		this.pintarComponente(imagenGuerrero,Color.DARK_GRAY,null);
		this.pintarComponente(panelDeAsignacion,Color.DARK_GRAY,null);
		this.pintarComponente(panelDeItems,Color.DARK_GRAY,Color.BLACK);
		this.pintarComponente(nombre,Color.DARK_GRAY,null);
		this.pintarComponente(nombreEtiqueta,Color.DARK_GRAY,null);
		this.pintarComponente(fuerza,Color.DARK_GRAY,null);
		this.pintarComponente(vida,Color.DARK_GRAY,null);
		this.pintarComponente(defensa,Color.DARK_GRAY,null);
		this.pintarComponente(energia,Color.DARK_GRAY,null);
		this.pintarComponente(presicion,Color.DARK_GRAY,null);
		imagenGuerrero.setBounds(10, 10, 390,340);
		panelDeAsignacion.setBounds(410, 10 , 580 ,530);
		panelDeItems.setBounds(10, 360, 390, 180);
		panelDeAsignacion.setBorder(BorderFactory.createLineBorder(Color.BLACK,15));
		borde = BorderFactory.createTitledBorder(new LineBorder(Color.BLACK, 15), "Items");
		borde.setTitleColor(Color.BLACK);
		panelDeItems.setBorder(borde);
		imagenGuerrero.setBorder(BorderFactory.createLineBorder(Color.BLACK,15));
		panelDeAsignacion.add(nombreEtiqueta);
		this.setBackground(Color.GRAY);
		nombreEtiqueta.setBounds(460, 10, 100, 30);
		this.add(panelDeItems);
		this.add(panelDeAsignacion);
		this.add(imagenGuerrero);
	}
	
	public void pintarComponente(JComponent componente,Color color,Color color2) {
		componente.setBackground(color);
		componente.setForeground(color2);
		
	}
	
	public void pintarBotones(LinkedList<JButton> botones) {
		for (JButton boton : botones) {
			this.pintarComponente(boton,Color.BLACK,Color.WHITE);
		}
	}
	
	public LinkedList<JButton> crearBotones() {
		LinkedList<JButton> botones = new LinkedList<JButton>();
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
		JButton fuerzaMenosCinco = new JButton("-5");
		JButton fuerzaMenosUno = new JButton("-1");
		JButton energiaMenosUno = new JButton("-1");
		JButton energiaMenosCinco = new JButton("-5");
		JButton presicionMenosUno = new JButton("-1");
		JButton presicionMenoscinco = new JButton("-5");
		JButton vidaMenosuno = new JButton("-1");
		JButton vidaMenoscinco = new JButton("-5");
		JButton defensaMenosuno = new JButton("-1");
		JButton defensaMenoscinco = new JButton("-5");
		botones.add(fuerzaMasCinco);
		botones.add(fuerzaMasUno);
		botones.add(energiaMasUno);
		botones.add(energiaMasCinco);
		botones.add(presicionMasUno);
		botones.add(presicionMascinco);
		botones.add(vidaMasuno);
		botones.add(vidaMascinco);
		botones.add(defensaMasuno);
		botones.add(defensaMascinco);
		botones.add(fuerzaMenosCinco);
		botones.add(fuerzaMenosUno);
		botones.add(energiaMenosUno);
		botones.add(energiaMenosCinco);
		botones.add(presicionMenosUno);
		botones.add(presicionMenoscinco);
		botones.add(vidaMenosuno);
		botones.add(vidaMenoscinco);
		botones.add(defensaMenosuno);
		botones.add(defensaMenoscinco);
		this.pintarBotones(botones);
		return botones;
		
	}
	
	
	
}
