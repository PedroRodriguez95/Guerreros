package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public enum Modo_Juego {
	UN_JUGADOR {
		@Override
		public void generarEntidades(EntidadesJuego entidades) {
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[4]);
			FuncionesGuerrero.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			entidades.setInteligenciaBot(new AiSingleplayer(entidades));
		}

	},
	MULTI_VS {

		@Override
		public void generarEntidades(EntidadesJuego entidades) {
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			entidades.setJugador2(FuncionesGuerrero.nuevoJugador());
		}
		
	},
	MULTI_COOP{
		@Override
		public void generarEntidades(EntidadesJuego entidades) {
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[8]);
			FuncionesGuerrero.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			entidades.setInteligenciaBot(new AiMultiplayer());
		}

	};
	
	public abstract void generarEntidades(EntidadesJuego entidades);
}