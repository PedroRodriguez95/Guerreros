package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerros.modelo.items.AnilloDeDefensa;

public class AnilloDeDefensaTest {
	@Test
	public void testAnilloDeDefensa() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(1, 18, 1, 1, 1);
		AnilloDeDefensa anillo = new AnilloDeDefensa(guerrero);
		assertEquals(19,(guerrero.getAtributos().getDefensa() + anillo.calcularAumento(guerrero.getAtributos().getDefensa(), 5)));
	}

}
