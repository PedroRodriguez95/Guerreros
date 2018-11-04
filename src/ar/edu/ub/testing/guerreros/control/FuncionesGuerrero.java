package ar.edu.ub.testing.guerreros.control;
import java.util.Random;
import java.util.Scanner;

import ar.edu.ub.testing.guerros.modelo.Cruzador;
import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerros.modelo.Mutador;

public class FuncionesGuerrero {
	
	static Random  rand = new Random();
	static Scanner scan = new Scanner(System.in);
	
	public static GuerreroJugador nuevoJugador() {
		
		GuerreroJugador jugador = new GuerreroJugador();
		System.out.println("Ingresar nombre: ");       //CREA UN NUEVO JUGADOR 
		jugador.getAtributos().setNombre(scan.next());
		mutarGuerreroManual(50, jugador);
		return jugador;
	}
	
	public static void generarGuerrerosEnemigos(GuerreroEnemigo[] enemigos) {
		for (int i = 0; i < enemigos.length; i++) {
			GuerreroEnemigo guerrero = new GuerreroEnemigo();              //CREA UN SET INICIAL DE GUERREROS ENEMIGOS
			mutarGuerrero(25,guerrero);
			guerrero.getAtributos().setNombre("Enemigo " + (i+1));
			enemigos[i] = guerrero;
		}
	}	
	public static void mutarGuerreroManual(int puntos, Guerrero guerrero){
		while (puntos > 0) {
			int eleccion = 0;
			while((1 <= eleccion && eleccion <= 5) != true) {
				EntidadesJuego.limpiarConsola();
				System.out.println("Puntos restantes =" + puntos);
				System.out.println("----------------------------");
				System.out.println("1) Ataque ->\t"     + guerrero.getAtributos().getAtaque());
				System.out.println("2) Defensa ->\t"    + guerrero.getAtributos().getDefensa());
				System.out.println("3) Presicion ->\t"  + guerrero.getAtributos().getPresicion());
				System.out.println("4) Vida ->\t"       + guerrero.getAtributos().getVida());
				System.out.println("5) Energia ->\t"    + guerrero.getAtributos().getEnergia());
				System.out.println("Seleccionar campo a asignar");
				eleccion = scan.nextInt();
			}
			Mutador.values()[eleccion - 1 ].asignarPunto(guerrero);  //SE ASIGNA MANUALMENTE EL TIPO DE MUTACION DESDE EL ENUM MUTADOR
			puntos--;
		}
	}
	
	public static void mutarGuerrero(int puntos, Guerrero guerrero) {
		for (int i = 0; i < puntos; i ++) {
			System.out.println("puntos = " + i);
			int eleccion = 1 + rand.nextInt((5 - 1) + 1);
			System.out.println(eleccion);
			System.out.println(Mutador.values()[eleccion - 1]);
			Mutador.values()[eleccion - 1 ].asignarPunto(guerrero);  //ASIGNA ALEATORIAMENTE EL TIPO DE MUTACION DESDE EL ENUM MUTADOR
		}
	}
	public static GuerreroEnemigo cruzarGuerreros(GuerreroEnemigo padre, GuerreroEnemigo madre,String nombre){
		Guerrero hijo = new GuerreroEnemigo();
		hijo.getAtributos().setNombre(nombre);
		Random rand = new Random();
		int eleccion = 1 + rand.nextInt((4 - 1) + 1);
		return Cruzador.values()[eleccion - 1 ].cruzar(padre, madre, nombre); //SELECCIONA ALEATORIAMENTE EL TIPO DE CRUZE DESDE EL ENUM CRUZADOR
	}
	
	public static void EvolucionarGuerrerosEnemigos(GuerreroEnemigo[] enemigos){
		// CRUZA Y MUTA LOS GUERREROS ENEMIGOS PARA FORMAR UNA NUEVA GENERACION
		
		GuerreroEnemigo[] nuevaGeneracion = new GuerreroEnemigo[enemigos.length];
		GuerreroEnemigo padre = null;
		GuerreroEnemigo madre = null;
		
		for (int i= 0; i < enemigos.length; i++){
			String nombre = "Enemigo " + (i+1);
			while(madre.getAtributos().equals(padre.getAtributos())){  //ME ASEGURO QUE NUNCA SE CRUZEN 2 GUERREROS IGUALES
				
				padre = enemigos[0 + rand.nextInt((3 - 1) + 1)];
				madre = enemigos[0 + rand.nextInt((3 - 1) + 1)];
				
			}
			GuerreroEnemigo hijo = cruzarGuerreros(padre,madre,nombre);  //SE CREA EL GUERRERO HIJO A PARTIR DE LOS PADRES
			mutarGuerrero(1,hijo);         //SE MUTA EL NUEVO GUERRERO
			nuevaGeneracion[i] = hijo;
		}
		enemigos = nuevaGeneracion;
	}
	
}