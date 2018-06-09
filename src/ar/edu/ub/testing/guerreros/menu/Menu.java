package ar.edu.ub.testing.guerreros.menu;

import ar.edu.ub.testing.guerreros.consola.Consola;

public class Menu {
	
	Consola consola;
	
	public Menu() {
		
		consola = new Consola();
		
	}
	
	/*public void menuPrincipal(Juego juego){
		
		consola.limpiarPantalla();
		consola.imprimirMenuPrincipal();
		
		try {
			
			int dato = consola.pedirDato();
			Juego.setTablero(Modo_Juego.values()[dato-1].generarTablero());    //CREA EL TABLERO APROPIADO A PARTIR DE EL ENUM MODO_JUEGO
			Iniciar_Juego.values()[dato-1].iniciarTablero(Juego.getTablero());  //ASIGNA VALORES INICIALES (INICIO DE PARTIDA) DESDE EL ENUM INICIAR_JUEGO
			
		}catch ( Exception e )  {
			
			System.out.println("No es int");
			
		}
		
	}
	*/
	
}
