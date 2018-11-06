package unitTests;

import static org.junit.Assert.assertEquals;
import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerros.modelo.Mutador;

class MutadorTests {
	
	Guerrero guerrero = new GuerreroJugador();

	@org.junit.Test
	void testMutarAtaque() {
		guerrero.getAtributos().setAtaque(5);
		Mutador.MUTAR_ATAQUE.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getAtaque());
	}
	
	@org.junit.Test
	void testMutarDefensa() {
		guerrero.getAtributos().setDefensa(5);
		Mutador.MUTAR_DEFENSA.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getDefensa());
	}
	
	@org.junit.Test
	void testMutarEnergia() {
		guerrero.getAtributos().setEnergia(5);
		Mutador.MUTAR_ENERGIA.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getEnergia());
	}
	
	@org.junit.Test
	void testMutarPresicion() {
		guerrero.getAtributos().setPresicion(5);
		Mutador.MUTAR_PRESICION.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getPresicion());
	}
	
	@org.junit.Test
	void testMutarVida() {
		guerrero.getAtributos().setVida(5);
		Mutador.MUTAR_VIDA.asignarPunto(guerrero);
		assertEquals(6,guerrero.getAtributos().getVida());
		assertEquals(6,guerrero.getAtributos().getVidaAux());
	}


}
