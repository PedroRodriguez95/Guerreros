package ar.edu.ub.testing.guerreros.control;

import ar.edu.ub.testing.guerros.modelo.EntidadesJuego;
import ar.edu.ub.testing.guerros.modelo.GuerreroEnemigo;

public enum Modo_Juego {
	UN_JUGADOR {
		@Override
		public EntidadesJuego generarEntidades(EntidadesJuego entidades) {
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[4]);
			LaboratorioGuerreros.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			entidades.setJugador(LaboratorioGuerreros.nuevoJugador());
			entidades.setInteligenciaBot(new AiSingleplayer(entidades));
			return entidades;
		}

		@Override
		public Integer key() {
			
			return 1;
		}

	},
	MULTI_VS {

		@Override
		public EntidadesJuego generarEntidades(EntidadesJuego entidades) {
			entidades.setJugador(LaboratorioGuerreros.nuevoJugador());
			entidades.setJugador2(LaboratorioGuerreros.nuevoJugador());
			return entidades;
		}

		@Override
		public Integer key() {
			return 3;
		}
		
	},
	MULTI_COOP{
		@Override
		public EntidadesJuego generarEntidades(EntidadesJuego entidades) {
			entidades.setGuerrerosEnemigos(new GuerreroEnemigo[8]);
			LaboratorioGuerreros.generarGuerrerosEnemigos(entidades.getGuerrerosEnemigos());
			entidades.setJugador(LaboratorioGuerreros.nuevoJugador());
			entidades.setJugador2(LaboratorioGuerreros.nuevoJugador());
			entidades.setInteligenciaBot(new AiMultiplayer());
			return entidades;
		}

		@Override
		public Integer key() {
			return 2;
		}

	};
	
	public abstract Integer key();
	public abstract EntidadesJuego generarEntidades(EntidadesJuego entidades);
}