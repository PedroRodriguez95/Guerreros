package ar.edu.ub.testing.guerreros.consola;


import java.util.Scanner;


public class Consola {
		
	private Scanner scan;
	
	public Consola() {
		 setScan(new Scanner(System.in)) ;
	}

	
	public void imprimirTitulo(){
		
		System.out.println("> > GUERREROS V1 < < ");
	}
	
	public void imprimirMenuPrincipal(){

		System.out.println("1) Un Jugador\n"
						 + "2)1 VS 1\n"
						 + "3)Cooperativo\n");
		
		
		
	}
	
	
	public void imprimir(String dato){
		
		System.out.println(dato);
		
	}
	
	
	public void limpiarPantalla(){
		
		for( int i = 0; i < 100 ; i++ )
			System.out.println();
		
	}
	
	public int pedirDato(){
		
		System.out.print("> ");
		return getScan().nextInt();
		
	}
	
	private Scanner getScan() {
		return scan;
	}

	private void setScan(Scanner scan) {
		this.scan = scan;
	}
	
	
}
