package unitTests;

import static org.junit.Assert.*;

import org.junit.Test;

import ar.edu.ub.testing.guerros.modelo.Guerrero;
import ar.edu.ub.testing.guerros.modelo.GuerreroJugador;
import ar.edu.ub.testing.guerros.modelo.items.AnilloDeEnergia;

public class AnilloDeEnergiaTest {

	@Test
	public void testAnilloDeDefensa() {
		Guerrero guerrero = new GuerreroJugador();
		guerrero.setAtributosSimple(1, 1, 18, 1, 1);
		AnilloDeEnergia anillo = new AnilloDeEnergia(guerrero);
		assertEquals(19,(guerrero.getAtributos().getEnergia() + anillo.calcularAumento(guerrero.getAtributos().getEnergia(), 5)));
	}

}
