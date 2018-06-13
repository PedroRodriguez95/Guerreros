package ar.edu.ub.testing.guerros.modelo;

import ar.edu.ub.testing.guerreros.control.FuncionesGuerrero;

public enum Modo_Juego {
	UN_JUGADOR {
		@Override
		public void generarEntidades(EntidadesJuego entidades) {
			entidades.setJugador(new GuerreroJugador());
			entidades.setJugador2(null);
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[4]);
		}

		@Override
		public void generarEntidadesHumanas(EntidadesJuego entidades) {
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			FuncionesGuerrero.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			
		}



	},
	MULTI_VS {

		@Override
		public void generarEntidades(EntidadesJuego entidades) {
			entidades.setJugador(new GuerreroJugador());
			entidades.setJugador2(new GuerreroJugador());
			entidades.setGuerrerosEnemigos(null);
		}

		@Override
		public void generarEntidadesHumanas(EntidadesJuego entidades) {
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			entidades.setJugador2(FuncionesGuerrero.nuevoJugador());
			
		}
	
	},
	MULTI_COOP{
		@Override
		public void generarEntidades(EntidadesJuego entidades) {
			entidades.setJugador(new GuerreroJugador());
			entidades.setJugador2(new GuerreroJugador());
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[8]);
		}

		@Override
		public void generarEntidadesHumanas(EntidadesJuego entidades) {
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			entidades.setJugador(FuncionesGuerrero.nuevoJugador());
			FuncionesGuerrero.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			
		}


	};
	
	public abstract void generarEntidades(EntidadesJuego entidades);
	public abstract void generarEntidadesHumanas(EntidadesJuego entidades);
}