package unitTests;

import static org.junit.Assert.assertEquals;
import ar.edu.ub.testing.guerros.modelo.Cruzador;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

class CruzadorTest {
	
	GuerreroEnemigo guerreroUno = new GuerreroEnemigo();
	GuerreroEnemigo guerreroDos = new GuerreroEnemigo();

	

	@org.junit.Test
	void testCruzarMetodo1() {
		guerreroUno.setAtributosSimple(4, 3, 3, 4, 3);
		guerreroDos.setAtributosSimple(3, 4, 4, 3, 4);
		GuerreroEnemigo hijo = Cruzador.CRUZA_1.cruzar(guerreroUno,guerreroDos,"guerreroHijo");
		assertEquals(4,hijo.getAtributos().getAtaque());
		assertEquals(4,hijo.getAtributos().getPresicion());
		assertEquals(3,hijo.getAtributos().getDefensa());
		assertEquals(3,hijo.getAtributos().getEnergia());
		assertEquals(3,hijo.getAtributos().getVida());
		
	}
	
	@org.junit.Test
	void testCruzarMetodo2() {
		guerreroUno.setAtributosSimple(4, 3, 3, 4, 3);
		guerreroDos.setAtributosSimple(3, 4, 4, 3, 4);
		GuerreroEnemigo hijo = Cruzador.CRUZA_2.cruzar(guerreroUno,guerreroDos,"guerreroHijo");
		assertEquals(3,hijo.getAtributos().getAtaque());
		assertEquals(3,hijo.getAtributos().getPresicion());
		assertEquals(3,hijo.getAtributos().getDefensa());
		assertEquals(3,hijo.getAtributos().getEnergia());
		assertEquals(3,hijo.getAtributos().getVida());
		
	}
	@org.junit.Test
	void testCruzarMetodo3() {
		guerreroUno.setAtributosSimple(4, 3, 3, 4, 3);
		guerreroDos.setAtributosSimple(3, 4, 4, 3, 4);
		GuerreroEnemigo hijo = Cruzador.CRUZA_2.cruzar(guerreroUno,guerreroDos,"guerreroHijo");
		assertEquals(4,hijo.getAtributos().getAtaque());
		assertEquals(4,hijo.getAtributos().getPresicion());
		assertEquals(3,hijo.getAtributos().getDefensa());
		assertEquals(3,hijo.getAtributos().getEnergia());
		assertEquals(3,hijo.getAtributos().getVida());
		
	}
	
	@org.junit.Test
	void testCruzarMetodo4() {
		guerreroUno.setAtributosSimple(4, 3, 3, 4, 3);
		guerreroDos.setAtributosSimple(3, 4, 4, 3, 4);
		GuerreroEnemigo hijo = Cruzador.CRUZA_2.cruzar(guerreroUno,guerreroDos,"guerreroHijo");
		assertEquals(3,hijo.getAtributos().getAtaque());
		assertEquals(3,hijo.getAtributos().getPresicion());
		assertEquals(4,hijo.getAtributos().getDefensa());
		assertEquals(4,hijo.getAtributos().getEnergia());
		assertEquals(4,hijo.getAtributos().getVida());
		
	}
}
